package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/symmetric-tree/submissions/?envType=study-plan-v2&envId=top-interview-150
 */
class `Symmetric Tree` {

    fun isSymmetric(root: TreeNode?): Boolean {

       return areTwoTreesEquivalent(root!!.left, root!!.right)
    }

    private fun areTwoTreesEquivalent(left: TreeNode?, right: TreeNode?): Boolean {

        if (left == null || right == null) {
            return left == right
        } else {
            if (left.`val` == right.`val`) {
                return areTwoTreesEquivalent(left.left, right.right) && areTwoTreesEquivalent(left.right, right.left)
            } else {
                return false
            }
        }
    }
}