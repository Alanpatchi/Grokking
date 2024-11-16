package com.boobalan.leetcode

class `Plus One` {

    fun plusOne(digits: IntArray): IntArray {

        var carryForward = 0
        for (i in digits.indices.reversed()) {
            var sum = digits[i] + carryForward
            if (i == digits.size -1) {
                sum++
            }
            carryForward = sum / 10
            digits[i] = sum % 10
        }
        return if (carryForward != 0) {
            val returnArray = IntArray(digits.size + 1)
            digits.copyInto(returnArray, 1)
            digits[0] = carryForward
            returnArray
        } else
            digits

    }
}