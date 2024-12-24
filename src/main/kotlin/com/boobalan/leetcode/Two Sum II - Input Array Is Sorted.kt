package com.boobalan.leetcode

class `Two Sum II - Input Array Is Sorted` {

    fun twoSum(numbers: IntArray, target: Int): IntArray {

        var pointer1 = 0
        var pointer2 = numbers.lastIndex

        while (pointer1 != pointer2) {
            while (numbers[pointer1] + numbers[pointer2] > target) {
                pointer2--
            }
            if (numbers[pointer1] + numbers[pointer2] == target) {
                return intArrayOf(pointer1 + 1, pointer2 + 1)
            } else {
                pointer1++
            }
        }
        return intArrayOf()


    }
}