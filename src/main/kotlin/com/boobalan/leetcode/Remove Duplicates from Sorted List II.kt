package com.boobalan.leetcode

import com.boobalan.grokking.leetcode.ListNode


class `Remove Duplicates from Sorted List II` {


    inner class FirstAttempt {
        fun deleteDuplicates(head: ListNode?): ListNode? {

            var currentNode = head
            var currentValue: Int? = null
            val array = IntArray(300)
            var arrayPos = -1
            while (currentNode != null) {
                if (currentNode.`val` != currentValue) {
                    currentValue = currentNode.`val`
                    arrayPos++
                    array[arrayPos] = 1
                } else {
                    array[arrayPos] += 1
                }
                currentNode = currentNode.next
            }

            println(array.contentToString())


            return retainOnlyUnique(head, array)


        }

        private fun retainOnlyUnique(head: ListNode?, array: IntArray): ListNode? {

            var newHead: ListNode? = null
            var i = 0
            var checkpointNode: ListNode? = null
            var currentNode: ListNode? = head
            while (i < array.size && array[i] != 0) {
                if (array[i] != 1) {
                    // skip the entire chain of i length nodes
                    repeat(array[i]) {
                        currentNode = currentNode!!.next
                    }
                } else {
                    if (checkpointNode == null) {
                        checkpointNode = currentNode
                        newHead = checkpointNode
                    } else {
                        checkpointNode.next = currentNode
                        checkpointNode = checkpointNode.next
                    }
                    currentNode = currentNode!!.next

                }
                i++
            }

            checkpointNode?.next = null

            return newHead


        }
    }


    inner class SlidingWindow {
        fun deleteDuplicates(head: ListNode?): ListNode? {

            // give to next window -> first and last nodes in the window
            // if the window is 0-length, take the first node of the window and; i) append to the solution listNode, ii) or begin a next solution listNode
            // if the window in non-zero-length, loop to the next window
            // set the solution ListNode's last node's next reference to null
            // return the solution ListNode's head

            var windowBegin = head
            var window = firstWindow(head)
            var solutionListNodeHead: ListNode? = null
            var solutionListNodeCursor: ListNode? = null
            while (window != null) {
                if (window.first == window.second)
                    if (solutionListNodeHead == null) {
                        solutionListNodeHead = window.first
                        solutionListNodeCursor = window.first
                    } else {
                        solutionListNodeCursor!!.next = window.first
                        solutionListNodeCursor = window.first
                    }

                windowBegin = window.second.next
                window = firstWindow(windowBegin)
            }
            solutionListNodeCursor?.next = null
            return solutionListNodeHead


        }

        private fun firstWindow(head: ListNode?): Pair<ListNode, ListNode>? {
            return head?.let {
                val firstNodeInWindow = it
                val firstNodeValue = head.`val`
                var lastNodeInWindow = head
                while (lastNodeInWindow?.next != null) {
                    if (lastNodeInWindow.next!!.`val` != firstNodeValue) {
                        break
                    } else {
                        lastNodeInWindow = lastNodeInWindow.next
                    }
                }
                return Pair(firstNodeInWindow, lastNodeInWindow!!)
            }
        }
    }
}



