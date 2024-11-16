package com.boobalan.leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/?envType=study-plan-v2&envId=top-interview-150
 * algo: sliding window kind of Window-management
 */
class `Minimum Number of Arrows to Burst Balloons` {

    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortWith(compareBy { it[1] })  // we want to sort by the Xend, because we want to handle one end at a time

        var windowBegin = points[0][0]
        var windowEnd = points[0][1]

        var arrows = 1
        for(balloon in points) {
            val beginTemp = max(windowBegin, balloon[0])
            val endTemp = min(windowEnd, balloon[1])

            if (beginTemp > endTemp) {
                windowBegin = balloon[0]
                windowEnd = balloon[1]
                arrows++
            } else {
                windowBegin = beginTemp
                windowEnd = endTemp
            }
        }

        return arrows

    }
}