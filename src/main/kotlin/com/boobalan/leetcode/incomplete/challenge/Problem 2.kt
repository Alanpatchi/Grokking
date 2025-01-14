package com.boobalan.leetcode.incomplete.challenge

import java.util.TreeMap
import kotlin.math.min

class `Problem 2` {
    fun answerString(word: String, numFriends: Int): String {

        val endIndex: Int = if (numFriends == 1) {
            numFriends
        } else {
            word.length
        }
        val length= word.length - numFriends + 1

        var maxSubstring = ""
        for (start in 0 until endIndex) {
            val substring = word.substring(start, min(start + length, word.length))
           if (substring > maxSubstring) {
               maxSubstring = substring
           }
        }
        return maxSubstring



    }


}