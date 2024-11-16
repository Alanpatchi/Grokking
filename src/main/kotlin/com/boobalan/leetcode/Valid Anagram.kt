package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/valid-anagram/?envType=study-plan-v2&envId=top-interview-150
 */
class `Valid Anagram` {

    fun isAnagram(s: String, t: String): Boolean {

        if (t.length != s.length) {
            return false
        }
        val charMap = HashMap<Char, Int>()
        for (char in s) {
            charMap.putIfAbsent(char, 0)
            charMap[char] = charMap[char]!! + 1
        }
        for (char in t) {
            if (!charMap.containsKey(char))
                return false
            else {
                if (charMap[char] == 1)
                    charMap.remove(char)
                else {
                    charMap[char] = charMap[char]!! - 1
                }
            }
        }
        return charMap.isEmpty()

    }
}