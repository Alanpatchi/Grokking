package com.boobalan.leetcode

import java.util.stream.Collectors

/**
 * https://leetcode.com/problems/word-break/?envType=study-plan-v2&envId=top-interview-150
 * Pattern: dp
 */

class `Word Break` {

    fun wordBreak(s: String, wordDict: List<String>): Boolean {

        val wordMap: MutableMap<Int, MutableList<String>> = wordDict
            .stream()
            .collect(Collectors.groupingBy { it.length })

        val dp = BooleanArray(s.length + 1)
        dp[0] = true

        for (i in s.indices) {

            populateDP@for (wordData in wordMap) {
                if (dp[i + 1]) break
                val prevEndPos = i - wordData.key
                if (prevEndPos >= -1 && dp[prevEndPos + 1]) {
                    val slice = s.substring(prevEndPos + 1..i)
                    for (word in wordData.value) {
                        if (word == slice) {
                            dp[i + 1] = true
                            break@populateDP
                        }
                    }
                }
            }
        }

        return dp[s.length]

    }
}