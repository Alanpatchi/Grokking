package com.boobalan.grokking.leetcode

class `8_Palindrome_Number` {
    fun isPalindrome(x: Int): Boolean {

        val digits = IntArray(11)
        when {
            x == 0 -> {
                return true
            }
            x < 0 -> {
                return false
            }
            else -> {
                var input = -x
                var i = 0
                while (input != 0) {
                    val nextInput = input / 10
                    digits[i] = input - (nextInput * 10)
                    input = nextInput
                    i++
                }

                val length = i
                var j = 0
                var palindromeFound = true
                while (j <= (length / 2) - 1) {
                    palindromeFound = palindromeFound && (digits[j] == digits[length - 1 - j])
                    j++
                }
                return palindromeFound
            }
        }

    }
}

fun main(args: Array<String>) {

    println(`8_Palindrome_Number`().isPalindrome(-10))
}