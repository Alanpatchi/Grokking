package com.boobalan.grokking.coding.mergeIntervals

import java.util.*

class Interval(var start: Int, var end: Int)
object MergeIntervals {

    fun merge(intervals: List<Interval>): List<Interval> {
        return intervals
    }

}
fun main(args: Array<String>) {

    val input: MutableList<Interval> = java.util.ArrayList()

    val mergedInterval: MutableList<Interval> = java.util.ArrayList()

    input.add(Interval(1, 4))
    input.add(Interval(2, 6))
    input.add(Interval(3, 5))

    input.sortBy { interval -> interval.start }

    for (i in 0 until input.size) {
        when (i) {
            0 -> {
                mergedInterval.add(input[i])
            }
            else -> {
                val current = input[i]
                val prev = mergedInterval.last()
                if (prev.end > current.start) { // overlap found
                    prev.end = maxOf(current.end, prev.end)
                } else {
                    mergedInterval.add(current)
                }
            }
        }

    }

    mergedInterval.forEach { interval -> println("[${interval.start}:${interval.end}]") }


}