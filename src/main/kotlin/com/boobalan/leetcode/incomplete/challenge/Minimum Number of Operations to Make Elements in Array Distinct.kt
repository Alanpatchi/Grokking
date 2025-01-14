package com.boobalan.leetcode.incomplete.challenge

class `Minimum Number of Operations to Make Elements in Array Distinct` {

    fun minimumOperations(nums: IntArray): Int {

        val batchSizeToCheck = nums.size % 3

        val presence: BooleanArray = BooleanArray(101)


        var duplicatedIndex = -1

        if (batchSizeToCheck != 0) {


            // check batch
            loop@ for (i in nums.size - 1 downTo nums.size - batchSizeToCheck) {
                if (presence[nums[i]]) {
                    duplicatedIndex = i
                    break@loop
                } else {
                    presence[nums[i]] = true
                }
            }

            if (duplicatedIndex != -1) {
                return (duplicatedIndex / 3) + 1
            }
        }

        var i = nums.size - batchSizeToCheck

        loop@ while (i > 0) {

            // check batch
            i -= 1
            if (presence[nums[i]]) {
                duplicatedIndex = i
                break@loop
            } else {
                presence[nums[i]] = true
            }

        }

        if (duplicatedIndex != -1) {
            return (duplicatedIndex / 3) + 1
        } else
            return 0

    }
}