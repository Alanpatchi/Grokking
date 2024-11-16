package com.boobalan.leetcode

class `Letter Combinations of a Phone Number` {


    private val numberLettersMap: Map<Char, String>
        get() =
            mapOf(
                Pair('2', "abc"),
                Pair('3', "def"),
                Pair('4', "ghi"),
                Pair('5', "jkl"),
                Pair('6', "mno"),
                Pair('7', "pqrs"),
                Pair('8', "tuv"),
                Pair('9', "wxyz")
            )

    fun letterCombinations(digits: String): List<String> {

        val returnList = mutableListOf<String>()

        val currentStringBuilder = StringBuilder()

        val currentIndexPos = 0

        if (digits.isEmpty()) {
            return emptyList()
        }

        backTrack(digits, currentStringBuilder, currentIndexPos, returnList)

        return returnList
    }

    private fun backTrack(
        digits: String,
        currentStringBuilder: StringBuilder,
        currentIndexPos: Int,
        returnList: MutableList<String>
    ) {

        for (char in numberLettersMap[digits[currentIndexPos]]!!) {

            currentStringBuilder.append(char)
            if (currentIndexPos == digits.length - 1) {
                returnList.add(currentStringBuilder.toString())
            } else {
                backTrack(digits, currentStringBuilder, currentIndexPos + 1, returnList)
            }
            currentStringBuilder.deleteAt(currentIndexPos)

        }

    }


}