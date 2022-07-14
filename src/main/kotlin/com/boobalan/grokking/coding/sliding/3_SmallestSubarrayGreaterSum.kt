package com.boobalan.grokking.coding.sliding


fun main(args: Array<String>) {
    val input: Array<Int> = arrayOf<Int>(3, 4, 1, 1, 6)
    val S = 8

    var smallestSubarrayStart = 0
    var smallestSubarrayEnd = input.size -1

    var s = 0 // alias windowStart
    var e = 0 // alias windowEnd

    var subArraySum = 0

    try {
        while (e < input.size) {

            // reposition e
            while (subArraySum < S) {
                subArraySum += input[e]
                e++
            }

            // recompute
            if (smallestSubarrayEnd - smallestSubarrayStart + 1 > e - s) {
                smallestSubarrayStart = s
                smallestSubarrayEnd = e -1
            }

            // reposition s
            do {
                subArraySum -= input[s]
                s++
            } while (subArraySum >=S)

            // recompute
            if (smallestSubarrayEnd - smallestSubarrayStart  > e- s  ) {
                smallestSubarrayStart = s -1
                smallestSubarrayEnd = e-1
            }
        }
    } catch (_: ArrayIndexOutOfBoundsException) {
    }

    println(input.copyOfRange(smallestSubarrayStart, smallestSubarrayEnd + 1).contentToString())

}