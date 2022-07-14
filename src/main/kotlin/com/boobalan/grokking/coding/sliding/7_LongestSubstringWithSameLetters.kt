package com.boobalan.grokking.coding.sliding

fun main(args: Array<String>) {
    val input = "abccde"
    val k = 1

    val charsInput = input.toCharArray()

    val freqMap = hashMapOf<Char, Int>()

    var longestSubstring = ""

    var s = 0 // alias windowStart
    var e = 0 // alias windowEnd

    try {
        while (e < input.length) {

            // reposition e
            do {
                val windowEndChar = charsInput[e]
                freqMap[windowEndChar] = (freqMap[windowEndChar] ?: 0) + 1
                val necessaryReplacementCount = freqMap.values.sum() - (freqMap.maxOfOrNull { it.value }?: 0)

                e++
            } while (necessaryReplacementCount <= k)

            // recalculate
            if (longestSubstring.length < e -1 - s) {
                longestSubstring = String(chars = charsInput, offset = s, length = e -1 - s)
            }

            // reposition s
//            do {
//                val windowStartChar = charsInput[s]
//                val freqOfWindowStartChar = freqMap[windowStartChar]!!
//                if(freqOfWindowStartChar != 0) {
//                    freqMap[windowStartChar] = freqOfWindowStartChar -1
//                } else {
//                    freqMap.remove(windowStartChar)
//                }
//                val necessaryReplacementCount = freqMap.values.sum() - (freqMap.maxOfOrNull { it.value }?: 0)
//
//                s++
//            } while (necessaryReplacementCount == k)


            // reposition s
            val windowStartChar = charsInput[s]
            val freqOfWindowStartChar = freqMap[windowStartChar]!!
            if (freqOfWindowStartChar != 0) {
                freqMap[windowStartChar] = freqOfWindowStartChar - 1
            } else {
                freqMap.remove(windowStartChar)
            }
            s++


        }
    } catch (_: ArrayIndexOutOfBoundsException) {
        // recalculate
        if (longestSubstring.length < e - s) {
            longestSubstring = String(chars = charsInput, offset = s, length = e - s)
        }
    }

    println(longestSubstring)
}