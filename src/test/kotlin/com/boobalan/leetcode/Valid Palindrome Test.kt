package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Valid Palindrome Test` {

    @Test
    fun isPalindromeTest() {
        Assertions.assertFalse(`Valid Palindrome`().isPalindrome("race a car"))
        Assertions.assertTrue(`Valid Palindrome`().isPalindrome("A man, a plan, a canal: Panama"))

        Assertions.assertTrue(`Valid Palindrome`().isPalindrome(" "))
    }
}