package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Count Complete Tree Nodes Test` {

    @Test
    fun testCountNodes() {

        val node4 = TreeNode(4)
        val node5 = TreeNode(5)
        val node2 = TreeNode(2)
        node2.left = node4
        node2.right = node5

        val node6 = TreeNode(6)
        val node3 = TreeNode(3)
        node3.left = node6

        val node1 = TreeNode(1)
        node1.left = node2
        node1.right = node3

        Assertions.assertEquals( 6, `Count Complete Tree Nodes`().countNodes(node1))


    }

    @Test
    fun testCountNodesForOnceNode() {
        val node = TreeNode(1)

        Assertions.assertEquals( 1, `Count Complete Tree Nodes`().countNodes(node))
    }
}