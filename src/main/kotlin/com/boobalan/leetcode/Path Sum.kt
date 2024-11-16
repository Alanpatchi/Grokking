package com.boobalan.leetcode

class `Path Sum` {

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {

        if (hasPath(root, targetSum)) return true
        return false

    }

    private fun hasPath(node: TreeNode?, remainder: Int): Boolean {
        if (node != null) {
            if (node.`val` == remainder) {
                if (node.left == null && node.right == null) {
                    return true
                }
            }
            return hasPath(node.left, remainder - node.`val`) || hasPath(node.right, remainder - node.`val`)
        }
        return false
    }
}