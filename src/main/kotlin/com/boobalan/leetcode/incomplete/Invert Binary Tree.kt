package com.boobalan.leetcode.incomplete

import com.boobalan.leetcode.TreeNode

class `Invert Binary Tree` {

    fun invertTree(root: TreeNode?): TreeNode? {

        if (root == null)
            return null
        val left = root.left
        root.left = root.right
        invertTree(root.left)
        root.right =left
        invertTree(root.right)
        return root
    }
}