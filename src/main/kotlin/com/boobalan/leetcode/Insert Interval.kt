package com.boobalan.leetcode

import java.util.Comparator
import java.util.PriorityQueue

class `Insert Interval` {

    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

        val priorityQueue = PriorityQueue<Pair<Char, Int>>(Comparator.comparingInt<Pair<Char, Int>?> { it.second }
            .thenComparing { it -> it.first })
        priorityQueue.add('b' to newInterval[0])
        priorityQueue.add('e' to newInterval[1])

        var nextBegin: Int? = null
        var nextEnd: Int? = null

        val returnList = arrayListOf<IntArray>()
        var bCount = 0
        for (interval in intervals) {
            priorityQueue.add('b' to interval[0])
            priorityQueue.add('e' to interval[1])


            while (priorityQueue.peek().first != 'e') {
                val poll = priorityQueue.poll()
                if (bCount == 0) {
                    nextBegin = poll.second
                }
                bCount++
            }

            val poll = priorityQueue.poll()
            bCount--
            if (bCount == 0) {
                if (priorityQueue.peek().second != poll.second) {
                    nextEnd = poll.second
                    returnList.add(intArrayOf(nextBegin!!, nextEnd))
                } else {
                    if (priorityQueue.peek().first == 'b') {
                        priorityQueue.poll()
                        bCount++
                    } else {
                        priorityQueue.poll()
                        bCount--
                    }

                }

            }


        }
        while (priorityQueue.isNotEmpty()) {
            val poll = priorityQueue.poll()
            if (poll.first == 'b') {
                nextBegin = poll.second
            } else {
                returnList.add(intArrayOf(nextBegin!!, poll.second))
            }
        }

        return returnList.toArray(arrayOf<IntArray>())


    }
}