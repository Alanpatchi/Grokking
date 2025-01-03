package com.boobalan.leetcode

class `Integer to Roman` {

    fun intToRoman(num: Int): String {
        val thousands = num / 1000
        val hundreds = (num / 100) % 10
        val tens = (num / 10) % 10
        val ones = num % 10

        val stringBuilder = StringBuilder()
        repeat(thousands) {
            stringBuilder.append("M")
        }
        if (hundreds != 0) {
            val onesCharacter = 'C'
            val fivesCharacter = 'D'
            val tensCharacter = 'M'
            calculateRomanLetterForDigit(hundreds, stringBuilder, onesCharacter, fivesCharacter, tensCharacter)
        }

        if (tens != 0) {
            val onesCharacter = 'X'
            val fivesCharacter = 'L'
            val tensCharacter = 'C'
            calculateRomanLetterForDigit(tens, stringBuilder, onesCharacter, fivesCharacter, tensCharacter)
        }

        if (ones != 0) {
            val onesCharacter = 'I'
            val fivesCharacter = 'V'
            val tensCharacter = 'X'
            calculateRomanLetterForDigit(ones, stringBuilder, onesCharacter, fivesCharacter, tensCharacter)
        }

        return stringBuilder.toString()
    }

    private fun calculateRomanLetterForDigit(
        digit: Int,
        stringBuilder: StringBuilder,
        onesCharacter: Char,
        fivesCharacter: Char,
        tensCharacter: Char
    ) {
        when {
            digit == 9 -> {
                stringBuilder.append(onesCharacter).append(tensCharacter)
            }

            digit == 4 -> stringBuilder.append(onesCharacter).append(fivesCharacter)
            digit >= 5 -> {
                stringBuilder.append(fivesCharacter)
                repeat(digit - 5) {
                    stringBuilder.append(onesCharacter)
                }
            }

            else -> {
                repeat(digit) {
                    stringBuilder.append(onesCharacter)
                }
            }
        }
    }
}