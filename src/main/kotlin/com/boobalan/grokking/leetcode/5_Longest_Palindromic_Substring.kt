package com.boobalan.grokking.leetcode

private class PalindromeSolution {
    fun longestPalindrome(s: String): String {
        var palindrome = ""

        var cpl: Int
        var ne: Int
        var no: Int
        var rightEnd: Int
        var leftEnd: Int
        for (i in s.indices) {

            // finding even palindrome
            cpl = palindrome.length
            ne = if (cpl % 2 == 0) {
                cpl + 2
            } else {
                cpl + 1
            }
            rightEnd = i + (ne/2)
            leftEnd = i - (ne/2 -1)

            if (leftEnd in s.indices
                && rightEnd in s.indices
                && s[leftEnd] == s[rightEnd]) { // checking for possible next palindrome

                var j = 1
                while (i+j in s.indices && i-(j-1) in s.indices && s[i+j] == s[i-(j-1)]) {
                    if (j >= ne/2) {
                        palindrome = s.substring(i-(j-1)..(i+j))
                    }
                    j++
                }

            }

            // finding odd palindrome
            cpl = palindrome.length
            no = if (cpl % 2 == 0) {
                cpl + 1
            } else {
                cpl + 2
            }

            rightEnd = i + (no - 1)/2
            leftEnd = i - (no -1)/2

            if (leftEnd in s.indices
                && rightEnd in s.indices
                && s[leftEnd] == s[rightEnd]) { // checking for possible next palindrome

                var j = 0
                while (i+j in s.indices && i-j in s.indices && s[i+j] == s[i-j]) {
                    if (j >= (no -1)/2) {
                        palindrome = s.substring((i-j)..i+j)
                    }
                    j++
                }

            }

        }

        return  palindrome
    }
}

fun main(args: Array<String>) {
    println(PalindromeSolution().longestPalindrome("a"))

}