package com.boobalan.leetcode

class `Word Pattern` {

    fun wordPattern(pattern: String, s: String): Boolean {

        var patternCursor = 0
        var stringCursor = 0
        val letterWordMap = hashMapOf<Char, String>()
        val wordLetterMap = hashMapOf<String, Char>()
        while (patternCursor < pattern.length && stringCursor < s.length) {

            val patternLetter = pattern[patternCursor++]

            val beginIndex = stringCursor
            while (stringCursor < s.length && s[stringCursor] != ' ') {
                stringCursor++
            }
            val stringWord = s.substring(beginIndex, stringCursor)
            if (stringCursor < s.length && s[stringCursor] == ' ')
                stringCursor++

            val currentWordForLetter: String? = letterWordMap[patternLetter]
            val currentLetterForWord: Char? = wordLetterMap[stringWord]
            if (currentWordForLetter == null && currentLetterForWord == null) {
                letterWordMap[patternLetter] = stringWord
                wordLetterMap[stringWord] = patternLetter
            } else {
                if (currentWordForLetter != null) {
                    if (currentWordForLetter != stringWord) {
                        return false
                    }
                }
                if (currentLetterForWord != null) {
                    if (currentLetterForWord != patternLetter) {
                        return false
                    }
                }

            }
        }

        return (patternCursor == pattern.length && stringCursor == s.length)

    }
}