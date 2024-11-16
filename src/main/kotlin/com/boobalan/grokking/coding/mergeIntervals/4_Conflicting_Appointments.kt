package com.boobalan.grokking.coding.mergeIntervals

import java.util.*
import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val input = arrayOf(Interval(1, 4), Interval(2, 5), Interval(7, 9))
    Arrays.sort(input, Comparator.comparing {
        it.start
    })


    if (input.isEmpty()) {
        println(false)
        exitProcess(0)
    }

    var conflicts: Boolean = false
    var prevInterval: Interval = input[0]
    var i = 1
    while (i < input.size) {
        val interval = input[i]
        if (interval.start < prevInterval.end) {
            conflicts = true
            break
        }
        prevInterval = interval
        i++
    }

    println(conflicts)
}