package com.boobalan.leetcode.incomplete

class `Bitwise AND of Numbers Range` {
    fun rangeBitwiseAnd(left: Int, right: Int): Int {

        var leftTemp = left
        var rightTemp = right

        var leftBitCount = 0
        while (leftTemp != 0) {
            leftBitCount ++
            leftTemp = leftTemp shr 1
        }

        var rightBitCount = 0
        while (rightTemp != 0) {
            rightBitCount ++
            rightTemp = rightTemp shr 1
        }

        if (leftBitCount != rightBitCount || leftBitCount == 0)
            return 0
        else {
            val tempAnd = left and right
            var `one followed by zeros` = 1 shl (leftBitCount -1)
            var result = 0
            while (`one followed by zeros` != 0) {
//                if ((tempAnd and `one followed by zeros`) != 0) {
//                    result += `one followed by zeros`
//                } else {
//                    break
//                }

                val `i digit followed by zeros` = left and `one followed by zeros`
                if (`i digit followed by zeros` == (right and `one followed by zeros`)) {
                    result += `i digit followed by zeros`
                } else
                    break

                `one followed by zeros` = `one followed by zeros` shr 1
            }
            return result

        }


    }

}