package com.boobalan.leetcode.incomplete

import com.boobalan.leetcode.TreeNode
import java.util.ArrayDeque


class `Binary Tree Right Side View` {

    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null)
            return emptyList()
        else {
            val returnList = arrayListOf<Int>()
            val queue = ArrayDeque<TreeNode>()
            queue.add(root)
            var numberOfParentNodesLeft = 0
            var numberOfChildNodesAdded = 1
            while (numberOfChildNodesAdded != 0) {
                numberOfParentNodesLeft = numberOfChildNodesAdded
                numberOfChildNodesAdded = 0
                val rightMostElement = queue.element()
                returnList.add(rightMostElement.`val`)
                while (numberOfParentNodesLeft != 0) {
                    val top = queue.remove()
                    top.right?.also {
                        queue.add(it)
                        numberOfChildNodesAdded++
                    }
                    top.left?.also {
                        queue.add(it)
                        numberOfChildNodesAdded++
                    }
                    numberOfParentNodesLeft--
                }
            }

            return returnList
        }
    }
}