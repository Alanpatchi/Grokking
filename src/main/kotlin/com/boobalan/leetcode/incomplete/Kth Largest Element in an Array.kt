package com.boobalan.leetcode.incomplete

import java.util.PriorityQueue

class `Kth Largest Element in an Array` {

    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue(nums.map { -it })
        for (i in 1 until k) {
            heap.poll()
        }
        return - heap.poll()

    }
}