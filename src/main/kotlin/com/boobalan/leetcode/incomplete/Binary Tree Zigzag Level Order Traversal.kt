package com.boobalan.leetcode.incomplete

import com.boobalan.leetcode.TreeNode
import java.util.LinkedList

class `Binary Tree Zigzag Level Order Traversal` {

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {

        val oddLevelStack = LinkedList<TreeNode>()
        val evenLevelStack = LinkedList<TreeNode>()
        if (root == null) {
            return listOf()
        } else {
            val returnList = mutableListOf<MutableList<Int>>()
            oddLevelStack.push(root)
            var currentlyTraversingStack = oddLevelStack
            var isOddLevel = true
            while (currentlyTraversingStack.isNotEmpty()) {
                val levelNodesList = mutableListOf<Int>()
                isOddLevel = currentlyTraversingStack == oddLevelStack

                while (currentlyTraversingStack.isNotEmpty()) {
                    val element = currentlyTraversingStack.pop()
                    levelNodesList.add(element.`val`)
                    if (isOddLevel) {
                        element.left?.let { evenLevelStack.push(it) }
                        element.right?.let { evenLevelStack.push(it) }
                    } else {
                        element.right?.let { oddLevelStack.push(it) }
                        element.left?.let { oddLevelStack.push(it) }
                    }
                }


                returnList.add(levelNodesList)
                currentlyTraversingStack = if (isOddLevel) evenLevelStack else oddLevelStack
            }
            return returnList
        }

    }
}