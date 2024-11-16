package com.boobalan.leetcode

import java.util.*

class Node(var `val`: Int) {
var left: Node? = null
var right: Node? = null
var next: Node? = null
}

class `Populating Next Right Pointers in Each Node II` {

    fun connect(root: Node?): Node? {

        var currentRow = 0
        val queue = LinkedList<Node>()
        if (root == null) return null
        queue.add(root)
        currentRow += queue.size
        var nextRow = 0
        while (queue.isNotEmpty()) {

            val head = queue.remove()
            head.left?.let {
                queue.add(it)
                nextRow++
            }
            head.right?.let {
                queue.add(it)
                nextRow++
            }
            currentRow--
            if (currentRow == 0) {
                head.next = null
                currentRow = nextRow
                nextRow = 0
            } else {
                head.next = queue.peekFirst()
            }


        }

        return root


    }
}