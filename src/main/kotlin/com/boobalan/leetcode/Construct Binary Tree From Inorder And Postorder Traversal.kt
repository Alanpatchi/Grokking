package com.boobalan.leetcode

class `Construct Binary Tree From Inorder And Postorder Traversal` {

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {

        // have a window in inOrder (inWB, inWE)
        // have a window in postOrder (poWB, poWE)
        // for the last element in postOrder window (as root)
            // search for that element in inOrder window (lets say you find at position i)
            // split the inOrder window into two left = (inWB, i-1), right = (i+1, inWE)
            // if either of these windows are of size 0; then the that side of root is null
        // recursively call the whose function for the right inOrder window and then the left.
        return null
    }
}