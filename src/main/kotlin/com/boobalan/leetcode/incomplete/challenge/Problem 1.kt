package com.boobalan.leetcode.incomplete.challenge

import kotlin.math.max

class `Problem 1` {

    fun minimumOperations(grid: Array<IntArray>): Int {

        var operationCount = 0
        for(col in grid[0].indices) {
            var i = 0
            var minimumRequiredCount =-1
            while (i < grid.size) {
                val value = grid[i][col]
                if (value < minimumRequiredCount) {
                    operationCount += (minimumRequiredCount - value)
                }
                minimumRequiredCount = max(minimumRequiredCount, value) + 1
                i++
            }
        }
        return operationCount

    }


}