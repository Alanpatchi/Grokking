package com.boobalan.grokking.coding.mergeIntervals

import kotlin.math.max
import kotlin.math.min

class `3_intervals_intersection` {
}

fun main(args: Array<String>) {
    val input1 = arrayOf(
        Interval(1, 3),
        Interval(5, 7),
        Interval(9, 12),
    )

    val input2 = arrayOf(
        Interval(5, 10),
    )

    val output: Array<Interval> = intervalsIntersection(input1, input2)

    output.forEach {
        println("Interval(${it.start}, ${it.end})")
    }
}

fun intervalsIntersection(input1: Array<Interval>, input2: Array<Interval>): Array<Interval> {
    var lastVisitedJ = 0
    var output = ArrayList<Interval>()
    for (i in input1.indices) {
        var j = lastVisitedJ
        val currentInterval = input1[i]
        val s = currentInterval.start
        val e = currentInterval.end
        while (j < input2.size && input2[j].end < s) {
            j++
        }

        while (j < input2.size && input2[j].start <= e) {
            intersectInterval(currentInterval, input2[j])?.apply {
                output.add(this)
            }
            j++
        }

        lastVisitedJ = max(j-1, lastVisitedJ)

    }

    return output.toTypedArray()
}

fun intersectInterval(currentInterval: Interval, interval: Interval): Interval? {
    val start = max(currentInterval.start, interval.start)
    val end = min(currentInterval.end, interval.end)
    return if (start <= end) Interval(start, end) else null
}
