package com.boobalan.leetcode.incomplete.challenge

import kotlin.math.min

class `Button with Longest Push Time` {


    fun buttonWithLongestTime(events: Array<IntArray>): Int {

        var maxTimeInterval = -1
        var maxTimeIntervalIndex = -1

        var prevTime = 0

        for (event in events) {
            val timeInterval = event[1] - prevTime
            if (timeInterval >= maxTimeInterval) {
                maxTimeIntervalIndex = if (timeInterval == maxTimeInterval) {
                    min(maxTimeIntervalIndex, event[0])
                } else {
                    event[0]
                }
                maxTimeInterval = timeInterval
            }
            prevTime = event[1]
        }

        return maxTimeIntervalIndex

    }
}