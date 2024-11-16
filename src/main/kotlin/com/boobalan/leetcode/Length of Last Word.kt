package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/length-of-last-word/
 */
class `Length of Last Word` {

    fun lengthOfLastWord(s: String): Int {

        var wordLength = 0

        var insideWord = false

        for (i in s.indices.reversed()) {

            if (s[i] != ' ') {

                if (!insideWord) {
                    insideWord = true
                    wordLength++
                } else {
                    wordLength++
                }

            } else {

                if (insideWord) {
                    break
                }

            }

        }

        return wordLength
    }
}