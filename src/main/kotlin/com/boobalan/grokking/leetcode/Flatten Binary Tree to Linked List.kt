package com.boobalan.grokking.leetcode

import com.boobalan.leetcode.TreeNode
import java.util.*

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-interview-150
 * algo: dfs (pre-order) using stack
 */
class `Flatten Binary Tree to Linked List` {

    class NodeHistory(var previousVisitedNode: TreeNode?) {
        fun visitNode(currentNode: TreeNode?) {
            this.previousVisitedNode?.let { it.left = null }
            this.previousVisitedNode?.let { it.right = currentNode }
            this.previousVisitedNode = currentNode
        }
    }

    fun flatten(root: TreeNode?): Unit {

        if (root == null)
            return

        val stack: Deque<TreeNode?> = LinkedList<TreeNode?>()
        stack.push(root)
        val nodeHistory = NodeHistory(null)
        while (stack.isNotEmpty()) {
            val node: TreeNode? = stack.pop()
            nodeHistory.visitNode(node)
            node?.right?.let { stack.push(it) }
            node?.left?.let { stack.push(it) }
        }

    }
}