package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150
 * Used: Hash Map
 */
class `Isomorphic Strings` {

    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val charMap = HashMap<Char, Char>()
        val reverseCharMap = HashMap<Char, Char>()
        for (i in s.indices) {
            val c: Char = s[i]
            val mappingChar = charMap[s[i]]
            if (mappingChar != null) {
                if (mappingChar != t[i]) {
                    return false
                }
            } else {

                val tempVal = t[i]
                if (reverseCharMap[tempVal] != null) {
                    return false
                } else {
                    charMap[s[i]] = t[i]
                    reverseCharMap[t[i]] = s[i]
                }

            }
        }
        return true
    }
}