package com.boobalan.grokking.coding.sliding

import java.util.TreeMap

fun main(args: Array<String>) {
    println(checkInclusion("ab", "eidbaoo"))

}

fun checkInclusion(s1: String, s2: String): Boolean {
    val input = s2
    val pattern = s1

    val inputMap = TreeMap<Char, Int>()
    val patternMap = TreeMap<Char, Int>()


    for (element: Char in pattern) {
        patternMap[element] = (patternMap[element] ?: 0) + 1
    }

    var s = 0 // alias of windowStart
    var e = 0 // alias of windowEnd

    var outputWindowElementStart = 0
    var outputWindowElementEnd = 0


    var patternfound = false
    try {
        while (e < input.length) {

            // reposition e
            do {
                val windowEndElement = input[e]
                inputMap[windowEndElement] = (inputMap[windowEndElement] ?: 0) + 1

                e++
            } while (e - s <= pattern.length - 1)

            // recalculate
            if (inputMap == patternMap) {
                patternfound = true
                outputWindowElementStart = s
                outputWindowElementEnd = e - 1
                break
            }

            // reposition s
            val windowStartElement = input[s]

            when (val windowStartElementFreq = inputMap[windowStartElement]!!) {
                1 -> inputMap.remove(windowStartElement)
                else -> {
                    inputMap[windowStartElement] = windowStartElementFreq - 1
                }
            }
            s++
        }
    } catch (_: StringIndexOutOfBoundsException) {
    }

    println("$patternfound: from $outputWindowElementStart to $outputWindowElementEnd")

    return patternfound
}