package com.boobalan.leetcode

class `Substring with Concatenation of All Words` {

    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val wordLength = words[0].length

        val returnList = mutableListOf<Int>()
        for (start in 0 until wordLength) {
            val spanLength = wordLength * words.size
            if (start + spanLength > s.length) {
                continue
            } else {

                val wordCountMap = mutableMapOf<String, Int>()
                for (word in words) {
                    wordCountMap.computeIfPresent(word) { _, oldCount -> oldCount + 1 }
                    wordCountMap.computeIfAbsent(word) { 1 }
                }

                var index = start
                while (index < spanLength + start) {

                    val substring = s.substring(index, index + wordLength)
                    includeWordIntoMap(wordCountMap, substring)
                    index += wordLength

                }

                if (wordCountMap.isEmpty()) {
                    returnList.add(start)
                }

                var includingWordBeginIndex = index
                var excludingWordBeginIndex = includingWordBeginIndex - spanLength
                while (excludingWordBeginIndex > -1 && includingWordBeginIndex < s.length && includingWordBeginIndex + wordLength - 1 < s.length) {

                    val substringToInclude = s.substring(includingWordBeginIndex, includingWordBeginIndex + wordLength)
                    includeWordIntoMap(wordCountMap, substringToInclude)

                    val substringToExclude = s.substring(excludingWordBeginIndex, excludingWordBeginIndex + wordLength)
                    excludeWordIntoMap(wordCountMap, substringToExclude)

                    if (wordCountMap.isEmpty()) {
                        returnList.add(excludingWordBeginIndex + wordLength)
                    }

                    includingWordBeginIndex += wordLength
                    excludingWordBeginIndex += wordLength

                }


            }

        }
        return returnList

    }

    private fun includeWordIntoMap(
        wordCountMap: MutableMap<String, Int>,
        substring: String
    ) {
        val count = wordCountMap[substring]
        if (count == null) {
            wordCountMap[substring] = -1
        } else {
            if (count == 1) {
                wordCountMap.remove(substring)
            } else {
                wordCountMap[substring] = count - 1
            }
        }
    }

    private fun excludeWordIntoMap(
        wordCountMap: MutableMap<String, Int>,
        substring: String
    ) {
        val count = wordCountMap[substring]
        if (count == null) {
            wordCountMap[substring] = 1
        } else {
            if (count == -1) {
                wordCountMap.remove(substring)
            } else {
                wordCountMap[substring] = count + 1
            }
        }
    }
}