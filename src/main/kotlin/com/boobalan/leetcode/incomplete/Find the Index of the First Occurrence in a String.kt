package com.boobalan.leetcode.incomplete

class `Find the Index of the First Occurrence in a String` {

    fun strStr(haystack: String, needle: String): Int {
        var needleFound = false
        outer@for(i in 0 until haystack.length - (needle.length -1)) {
            inner@for (j in needle.indices) {
                if (haystack[i + j] != needle[j]) {
                    continue@outer
                }
            }
            return i
        }
        return -1
    }
}