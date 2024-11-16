package com.boobalan.leetcode

import java.util.PriorityQueue

data class Range(var from: BarData, var to: BarData)
class BarData(val position: Int, val height: Int) : Comparable<BarData> {
    override fun compareTo(other: BarData): Int {
        return other.height.compareTo(this.height)
    }
}

/**
 * https://leetcode.com/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150
 * algo: 25 mins (heap)
 * coding: 20 mins
 */
class `Trapping Rain Water` {

    fun trap(height: IntArray): Int {
        val bars: Array<BarData> = Array(height.size) {
            BarData(it, height[it])
        }
        val heap = PriorityQueue(bars.asList())
        val max = heap.poll()!!
        val filledRange = Range(max, max)
        var filledWaterVolume = 0

        while (heap.isNotEmpty()) {
            val maxBar = heap.poll()
            filledWaterVolume += displacementAreaFromRange(filledRange, maxBar)

            filledRange.from = if (maxBar.position < filledRange.from.position) {
                maxBar
            } else
                filledRange.from
            filledRange.to = if (maxBar.position > filledRange.to.position) {
                maxBar
            } else
                filledRange.to
        }
        return filledWaterVolume

    }
    
    fun displacementAreaFromRange(range: Range, barData: BarData): Int {
        return when {
            (range.from.position <= barData.position) && (range.to.position >= barData.position) -> -barData.height
            (range.from.position > barData.position) -> (range.from.position - barData.position -1) * barData.height
            else -> (barData.position - range.to.position -1) * barData.height
        }
    }
}