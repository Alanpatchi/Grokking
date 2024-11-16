package com.boobalan.leetcode

import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * Algorithm: Max-heap
 *
 * refer:
 * 1. https://www.youtube.com/watch?v=76EKZuHeHxs&list=PLMDFPuH4ZxUFGC5ICUu8xstOxQIizMgX2&index=16
 * 2. https://www.youtube.com/watch?v=4-HelG_6t04&list=PLMDFPuH4ZxUFGC5ICUu8xstOxQIizMgX2&index=16
 */

class H_Index {

    fun hIndex(citations: IntArray): Int {

        for (i in citations.indices) {
            citations[i] = -citations[i]
        }

        // had to reverse the elements and initialize it because we need max-heap; and java PriorityQueue if initialized with collection will give only min-heap
        val heap = PriorityQueue(citations.asList())


        var paperCount = 0

        while(heap.isNotEmpty()) {

            val currentCitationCount = -heap.poll()
            if (currentCitationCount > paperCount) {
                paperCount++
            } else {
                break
            }
        }

        return paperCount


    }
}

fun main(args: Array<String>) {
    println(H_Index().hIndex(intArrayOf(3,0,6,1,5)))
}