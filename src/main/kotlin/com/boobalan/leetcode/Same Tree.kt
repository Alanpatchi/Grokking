package com.boobalan.leetcode

class `Same Tree` {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null || q == null) {
            return q == p
        } else {
            if (p.`val` != q.`val`) {
                return false
            } else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
            }
        }
    }
}
