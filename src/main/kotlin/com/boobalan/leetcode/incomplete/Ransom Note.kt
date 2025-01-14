package com.boobalan.leetcode.incomplete

class `Ransom Note` {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {

        val magazineLetterCount = IntArray(26)
        for (char in magazine) {
            magazineLetterCount[char - 'a']++
        }

        for (ransom in ransomNote) {
           if ( magazineLetterCount[ransom - 'a'] == 0) {
               return false
           } else {
               magazineLetterCount[ransom - 'a'] --
           }
        }
        return true

    }

}