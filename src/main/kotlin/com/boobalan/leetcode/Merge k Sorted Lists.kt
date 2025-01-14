package com.boobalan.leetcode

import java.util.PriorityQueue

class `Merge k Sorted Lists` {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {

        val priorityQueue = PriorityQueue<ListNode>(Comparator.comparingInt { it -> it.`val` })
        for (head in lists) {
            if (head != null) {
                priorityQueue.offer(head)
            }
        }



        if (priorityQueue.isNotEmpty()) {
            val lowest = priorityQueue.poll()
            val head: ListNode = lowest
            var tail: ListNode = lowest
            val nextToLowest = lowest.next
            if (nextToLowest != null) {
                priorityQueue.offer(nextToLowest)
            }
            while (priorityQueue.isNotEmpty()) {
                val poll: ListNode = priorityQueue.poll()
                tail.next = poll
                tail = poll
                val next = poll.next
                if (next != null) {
                    priorityQueue.offer(next)
                }
            }
            return head
        } else {
            return null
        }



    }
}