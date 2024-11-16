package com.boobalan.grokking.leetcode


fun lengthOfLongestSubstring(s: String): Int {

    var b = 0
    var e = 0
    var maxSubStringLength = 0

    val freqMap = HashMap<Char, Int>()
    while (e < s.length) {

        // start expanding window by absorbing element in e
        val endChar = s[e]
        if (endChar in freqMap) {
            freqMap[endChar] = freqMap[endChar]!! + 1
        } else {
            freqMap[endChar] = 1
        }
        if (freqMap[endChar] == 1) { // keep absorbing
            if (e -b +1 > maxSubStringLength) {
                maxSubStringLength = e-b+1
            }
            e++
        } else {
            // start shrinking window by kicking element in b
            shrink@while (true) {
                val beginChar = s[b]
                freqMap[beginChar] = freqMap[beginChar]!! - 1
                if (freqMap[beginChar] == 0) { // keep kicking
                    b++
                } else {
                    b++
                    e++
                    break@shrink
                }
            }
        }

    }

    return maxSubStringLength
}

fun main(args: Array<String>) {
    println(lengthOfLongestSubstring("abcabcbb"))
}