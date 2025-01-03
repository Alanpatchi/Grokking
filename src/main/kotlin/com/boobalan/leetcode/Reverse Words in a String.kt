package com.boobalan.leetcode

class `Reverse Words in a String` {

    fun reverseWords(s: String): String {

        var i = s.lastIndex
        while (i > -1 && s[i] == ' ') {
            i--
        }

        val wholeStringBuilder = StringBuilder()

        while (i > -1) {

            val wordStringBuilder = StringBuilder()
            while (i > -1 && s[i] != ' ') {
                wordStringBuilder.append(s[i])
                i--
            }
            wholeStringBuilder.append(wordStringBuilder.reversed())
            while (i > -1 && s[i] == ' ') {
                i--
            }
            if (i > -1) {
                wholeStringBuilder.append(' ')
            }
        }

        return wholeStringBuilder.toString()
    }
}