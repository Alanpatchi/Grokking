package com.boobalan.leetcode.incomplete

import kotlin.math.min

class `Minimum Path Sum` {
    fun minPathSum(grid: Array<IntArray>): Int {
        for (r in 1 until grid.size) {
            grid[r][0] += grid[r-1][0]
        }
        for (c in 1 until grid[0].size) {
            grid[0][c] += grid[0][c-1]
        }
        for (r in 1 until grid.size) {
            for (c in 1 until grid[0].size) {
                grid[r][c] += min(grid[r-1][c], grid[r][c-1])
            }
        }
        return grid[grid.size-1][grid[0].size -1]
    }

}