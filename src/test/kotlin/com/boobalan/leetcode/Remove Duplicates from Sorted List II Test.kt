package com.boobalan.leetcode

import com.boobalan.grokking.leetcode.ListNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Remove Duplicates from Sorted List II Test` {

    @Test
    fun testInput1() {
        val head = ListNode(1)
        head.next = ListNode(2)
        head.next!!.next = ListNode(3)
        head.next!!.next!!.next = ListNode(3)
        head.next!!.next!!.next!!.next = ListNode(4)
        head.next!!.next!!.next!!.next!!.next = ListNode(4)
        head.next!!.next!!.next!!.next!!.next!!.next = ListNode(5)

        val solution = `Remove Duplicates from Sorted List II`()
        //    solution.FirstAttempt().deleteDuplicates(null)
        val solutionHead = solution.SlidingWindow().deleteDuplicates(head)

        // printing code
        val generateSequence = generateSequence(
            solutionHead
        ) { node -> node.next }

        println(
            generateSequence.map { it.`val` }.toList().toIntArray().contentToString()
        )

        Assertions.assertEquals(solutionHead!!.`val`, 1)
        Assertions.assertEquals(solutionHead.next!!.`val`, 2)
        Assertions.assertEquals(solutionHead.next!!.next!!.`val`, 5)
        Assertions.assertEquals(solutionHead.next!!.next!!.next, null)
    }
}