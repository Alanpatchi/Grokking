package com.boobalan.leetcode

class `Binary Tree Maximum Path Sum` {

    fun maxPathSum(root: TreeNode?): Int {

        val maxSum = intArrayOf(Int.MIN_VALUE)
        val pathSum = intArrayOf(root!!.`val`)
        maxPathSum(root, pathSum, maxSum)
        return maxSum[0]
    }

    private fun maxPathSum(node: TreeNode, pathSum: IntArray, maxSum: IntArray) {
        val leftNode = node.left
        val rightNode = node.right
        if (leftNode == null && node.right == null) {
            if(maxSum[0] < pathSum[0]) {
                maxSum[0] = pathSum[0]
            }
        } else {
            if (leftNode != null) {
                pathSum[0] += leftNode.`val`
                maxPathSum(leftNode, pathSum, maxSum)
                pathSum[0] -= leftNode.`val`
            }

            if (rightNode != null) {
                pathSum[0] += rightNode.`val`
                maxPathSum(rightNode, pathSum, maxSum)
                pathSum[0] -= rightNode.`val`
            }
        }
    }
}