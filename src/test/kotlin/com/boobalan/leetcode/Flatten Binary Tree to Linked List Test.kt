package com.boobalan.leetcode

import com.boobalan.grokking.leetcode.`Flatten Binary Tree to Linked List`
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Flatten Binary Tree to Linked List Test` {

    @Test
    fun testFlatten() {

        val one = TreeNode(1)
        val two = TreeNode(2)
        val thee = TreeNode(3)
        val four = TreeNode(4)
        val five = TreeNode(5)
        val six = TreeNode(6)
        one.left = two
        one.right = five
        two.left = thee
        two.right = four
        five.right = six

        `Flatten Binary Tree to Linked List`().flatten(one)

        Assertions.assertEquals(two, one.right )
        Assertions.assertEquals(thee, two.right )
        Assertions.assertEquals(four, thee.right)
        Assertions.assertEquals(five, four.right)
        Assertions.assertEquals(six, five.right)
    }
}