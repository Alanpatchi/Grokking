package com.boobalan.leetcode

import java.util.Deque
import java.util.LinkedList

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
class `Binary Search Tree Iterator` {

    class BSTIterator(root: TreeNode?) {

        private val stack = LinkedList<TreeNode>()
        init {

            addNodeToStack(root!!)

        }

        private fun addNodeToStack(node: TreeNode) {
            var cursor: TreeNode? = node
            while (cursor != null) {
                stack.push(cursor)
                cursor = cursor.left
            }
        }

        fun next(): Int {
            val pop = stack.pop()
            val right = pop.right
            if (right != null) {
                addNodeToStack(right)
            }
            return pop.`val`
        }

        fun hasNext(): Boolean {
            return stack.isNotEmpty()
        }

    }
}