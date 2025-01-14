package com.boobalan.leetcode

import java.util.HashMap


fun main(args: Array<String>) {
    `Construct Binary Tree From Inorder And Postorder Traversal`().buildTree(intArrayOf(1, 2), intArrayOf(2, 1))
}

class `Construct Binary Tree From Inorder And Postorder Traversal` {

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {

        val inOrderValtoPositionMap = hashMapOf<Int, Int>()

        for (i in inorder.indices) {
            inOrderValtoPositionMap[inorder[i]] = i
        }

        val inOrderList = inorder.asList()
        val postOrderList = postorder.asList()

        return if (inorder.isEmpty()) {
            null
        } else {
            val buildTree = buildTree(inOrderList, postOrderList, inOrderBeginningRef = 0, inOrderValtoPositionMap)
            buildTree
        }

    }

    private fun buildTree(
        inorder: List<Int>,
        postorder: List<Int>,
        inOrderBeginningRef: Int,
        inOrderValtoPositionMap: HashMap<Int, Int>
    ): TreeNode {

        val sizeOfTree = inorder.size
        val nodeVal = postorder[sizeOfTree - 1]
        val node = TreeNode(nodeVal)
        if (sizeOfTree != 1) {
            val positionOfNodeInInorder = inOrderValtoPositionMap[nodeVal]!! - inOrderBeginningRef
            if (positionOfNodeInInorder != 0) {
                val leftPostOrder = postorder.subList(0, positionOfNodeInInorder)
                val leftInOrder = inorder.subList(0, positionOfNodeInInorder)
                node.left = buildTree(leftInOrder, leftPostOrder, inOrderBeginningRef, inOrderValtoPositionMap)
            }
            if (positionOfNodeInInorder != sizeOfTree - 1) {
                val rightPostOrder = postorder.subList(positionOfNodeInInorder, sizeOfTree - 1)
                val rightInOrder = inorder.subList(positionOfNodeInInorder + 1, sizeOfTree)
                node.right = buildTree(rightInOrder, rightPostOrder, positionOfNodeInInorder + 1 + inOrderBeginningRef, inOrderValtoPositionMap)
            }
        }
        return node
    }
}