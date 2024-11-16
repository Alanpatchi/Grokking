package com.boobalan.leetcode

class `Rotate Image` {

    fun rotate(matrix: Array<IntArray>): Unit {

        val baseLeftTop = intArrayOf(0, 0)
        val baseRightTop = intArrayOf(0, matrix.size -1)
        val baseLeftBottom = intArrayOf(matrix.size -1, 0)
        val baseRightBottom = intArrayOf(matrix.size -1, matrix.size -1)

        val leftTop = IntArray(2)
        val rightTop = IntArray(2)
        val leftBottom = IntArray(2)
        val rightBottom = IntArray(2)

        for (step in 0 .. (matrix.size - 1)/2) {

            leftTop[0] =baseLeftTop[0] + step
            leftTop[1] =baseLeftTop[1] + step
            rightTop[0] =baseRightTop[0] + step
            rightTop[1] =baseRightTop[1] - step
            leftBottom[0] =baseLeftBottom[0] - step
            leftBottom[1] =baseLeftBottom[1] + step
            rightBottom[0] =baseRightBottom[0] - step
            rightBottom[1] =baseRightBottom[1] - step

            for(i in 0 until baseRightTop[1] - step - (baseLeftTop[1] + step)) {


                val leftBottomValue = matrix[leftBottom[0] - i][leftBottom[1]]
                matrix[leftBottom[0] - i][leftBottom[1]] = matrix[rightBottom[0]][rightBottom[1] -i]
                matrix[rightBottom[0]][rightBottom[1] -i] = matrix[rightTop[0] +i][rightTop[1]]
                matrix[rightTop[0] +i][rightTop[1]] =  matrix[leftTop[0]][leftTop[1] + i]
                matrix[leftTop[0]][leftTop[1] + i] = leftBottomValue

//                println("")
            }


        }

    }
}