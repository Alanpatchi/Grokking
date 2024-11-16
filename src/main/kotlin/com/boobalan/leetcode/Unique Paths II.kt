package com.boobalan.leetcode

class `Unique Paths II` {

    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size
        val uniquePathCountArray = Array(m) {
            IntArray(n)
        }

        // starting position initialization
        if (obstacleGrid[0][0] == 1) {
            uniquePathCountArray[0][0] = 0
        } else {
            uniquePathCountArray[0][0] = 1
        }

        // first row initialization
        for (j in 1 until n) {
            if (obstacleGrid[0][j] == 1) {
                uniquePathCountArray[0][j] = 0
            } else {
                uniquePathCountArray[0][j] = uniquePathCountArray[0][j-1]
            }
        }

        // for each row
        for (i in 1 until m) {

            // first element initialization
            if (obstacleGrid[i][0] == 1) {
                uniquePathCountArray[i][0] = 0
            } else {
                uniquePathCountArray[i][0] = uniquePathCountArray[i -1][0]
            }

            // current row
            for (j in 1 until n) {

                if (obstacleGrid[i][j] == 1) {
                    uniquePathCountArray[i][j] = 0
                } else {
                    uniquePathCountArray[i][j] = uniquePathCountArray[i -1][j] + uniquePathCountArray[i][j -1]
                }

            }

        }


        return uniquePathCountArray[m-1][n-1]
    }


}