package com.boobalan.grokking.coding.sliding

fun main(args: Array<String>) {
    val input: Array<Int> = arrayOf<Int>(1, 3, 2, 6, -1, 4, 1, 8, 2)
    val k = 5

    // necessary output data as required
    val output = DoubleArray(input.size -k + 1)

    // choose any appropriate window position for initialization
    // index where the window ends in input array
    var windowEnd = 0
    // index where the window starts in the input array
    var windowStart = windowEnd -k +1
    // windowStart and windowEnd already initialized to a window position


    // necessary sliding variables
    var currentSum= 0.0

    // for every window position
    // as long as the windowEnd doesn't overflow
    while (windowEnd <= input.size -1) {

        // action -- start

        // consider the new elements
        currentSum += input[windowEnd]

        // remove the effects of old elements
        try {
            currentSum -= input[windowStart-1]
        } catch (_: ArrayIndexOutOfBoundsException) {
        }

        // make final changes before sliding the window
        try {
            output[windowStart] = currentSum/k
        } catch (_: ArrayIndexOutOfBoundsException) {
        }

        // action -- end


        // slide action to move to new window position
        windowEnd++
        windowStart++

    }

//    val outputAsString = output.joinToString { String }
//    println(outputAsString)

    output.forEach { println(it) }


}