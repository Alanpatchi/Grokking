package com.boobalan.grokking.coding.mergeIntervals

import kotlin.math.max
import kotlin.math.min


fun main(args: Array<String>) {
    val input: Array<Interval> = arrayOf(
        Interval(1, 3),
        Interval(5, 7),
    )

    val new = Interval(1, 4)

    val output = insertInterval(input, new)

    output.forEach { interval -> println("Interval(${interval.start},${interval.end})") }
    println()
}

fun insertInterval(input: Array<Interval>, new: Interval): Array<Interval> {

    val output = ArrayList<Interval>()
    val s = new.start
    val e = new.end
    var i = 0
    while (i < input.size && input[i].end < s) {
        output.add(input[i])
        i++
    }

    var mergedInterval: Interval = new
    while (i < input.size && input[i].start <= e) {
        mergedInterval = merge(mergedInterval, input[i])
        i++
    }

    output.add(mergedInterval)

    while (i < input.size) {
        output.add(input[i])
        i++
    }

    return output.toTypedArray()
}

/**
 *
 */
fun merge(interval1: Interval, interval2: Interval): Interval {
    if (interval1.end < interval2.start || interval2.start < interval1.start) {
        throw java.lang.IllegalStateException()
    }
    return Interval(min(interval1.start, interval2.start), max(interval1.end, interval2.end))
}
