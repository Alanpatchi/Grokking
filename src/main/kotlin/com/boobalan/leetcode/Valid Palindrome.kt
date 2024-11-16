package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 * Pattern: 2 pointers
 */
class `Valid Palindrome` {


    fun isPalindrome(s: String): Boolean {

        var forward = 0
        var backward = s.length -1

        while (true) {

            var forwardChar: Char? = null
            forward@while (forward < s.length) {

                forwardChar = s[forward]
                forwardChar = when (forwardChar) {
                    in 'A'..'Z' -> forwardChar + 32
                    in 'a'..'z' -> forwardChar
                    in '0'..'9' -> forwardChar
                    else -> null
                }
                if (forwardChar != null) {
                    break@forward
                }

                forward++
            }

            var backwardChar: Char? = null
            backward@while (backward > -1) {

                backwardChar = s[backward]
                backwardChar = when (backwardChar) {
                    in 'A'..'Z' -> backwardChar + 32
                    in 'a'..'z' -> backwardChar
                    in '0'..'9' -> backwardChar
                    else -> null
                }
                if (backwardChar != null) {
                    break@backward
                }

                backward--
            }

            if (forward <= backward) {
                if (forwardChar != null) {
                    if (forwardChar == backwardChar) {
                        forward ++
                        backward --
                        continue
                    } else {
                        return false
                    }
                }
            } else {
                return true
            }

        }

    }


}