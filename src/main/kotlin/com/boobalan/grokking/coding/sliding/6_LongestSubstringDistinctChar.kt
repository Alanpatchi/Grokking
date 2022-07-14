package com.boobalan.grokking.coding.sliding

fun main(args: Array<String>) {
    val input = "abccde"

    // map of char with its last position
    val map = hashMapOf<Char, Int?>()


    val charsInput = input.toCharArray()
//    chars.forEach { println(it) }

    var longestSubstring: String = ""

    var windowEnd = 0
    var windowStart = 0

    do {
        val c = charsInput[windowEnd]
        when (val indexOfLastOccurrence = map[c]) {
            null -> {
                map[c] = windowEnd
                windowEnd++
            }
            else -> {
                val windowLength = windowEnd - windowStart
                if (windowLength >= longestSubstring.length) {
                    longestSubstring = String(chars = charsInput, offset = windowStart, length = windowLength)
                }
                var clearMapCursor = windowStart
                do {
                    map[charsInput[clearMapCursor]] = null
                    clearMapCursor++
                } while (clearMapCursor <= indexOfLastOccurrence)
                windowStart = clearMapCursor
                map[c] = windowEnd
                windowEnd++
            }
        }
    } while (windowEnd < input.length)



    println(longestSubstring)
}