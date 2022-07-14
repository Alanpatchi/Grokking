package com.boobalan.grokking.coding.sliding

fun main(args: Array<String>) {
    val input = "cbbebi"
    val k = 3

    val inputChars = input.toCharArray()

    val frequencyMap = hashMapOf<Char, Int>()

    var longestSubarray = ""

    var s = 0 // alias windowStart
    var e = 0 // alias windowEnd

    try {
        while (e < input.length) {
            // reposition e
            do {
                val windowEndChar = inputChars[e]
                frequencyMap[windowEndChar] = (frequencyMap[windowEndChar] ?: 0) + 1
                e++
            } while (frequencyMap.size <= k)

            if (longestSubarray.length < e -s -1) {
                longestSubarray = String(chars = inputChars, offset = s, length = e -s -1)
            }

            // reposition s
            do {
                val windowStartChar = inputChars[s]
                when(frequencyMap[windowStartChar]) {
                    1 -> {
                        frequencyMap.remove(windowStartChar)
                    }
                    else -> {
                        frequencyMap[windowStartChar] = frequencyMap[windowStartChar]!! - 1;
                    }
                }
                s++
            } while (frequencyMap.size > k)

        }
    } catch (_: ArrayIndexOutOfBoundsException) {
    }

    println(longestSubarray)






//    // reposition e
//    do {
//        val windowEndChar = inputChars[e]
//        frequencyMap[windowEndChar] = (frequencyMap[windowEndChar] ?: 0) + 1
//        e++
//    } while (frequencyMap.size <= k)
//
//    // reposition s
//    do {
//        val windowStartChar = inputChars[s]
//        when(frequencyMap[windowStartChar]) {
//            1 -> {
//                frequencyMap.remove(windowStartChar)
//            }
//            else -> {
//                frequencyMap[windowStartChar] = frequencyMap[windowStartChar]!! - 1;
//            }
//        }
//        s++
//    } while (frequencyMap.size > k)
}