package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/is-subsequence/solutions/1811180/c-easy-3-approaches-brute-force-recursive-memoization/?envType=study-plan-v2&envId=top-interview-150
 * Pattern: 2 pointers
 */
class `Is Subsequence` {

    fun isSubsequence(s: String, t: String): Boolean {

        var firstPointer = 0
        var secondPointer = 0

        if (s.isEmpty()) {
            return true
        }

        while (firstPointer < t.length) {
            if (t[firstPointer] == s[secondPointer]) {
                secondPointer++
                if (secondPointer == s.length) {
                    return true
                }
            }
            firstPointer++
        }

        return false


    }

}