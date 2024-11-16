package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/description/?envType=study-plan-v2&envId=top-interview-150
 */


class `Count Complete Tree Nodes` {

    fun countNodes(root: TreeNode?): Int {

       return countNodesOLogn(root)

    }

    fun countNodesRecursive(root: TreeNode?): Int {

        if (root == null) {
            return 0
        }

        return countNodes(root.left) + countNodes(root.right) + 1

    }

    fun countNodesOLogn(root: TreeNode?): Int {

        var walkPath = 0

        if(root == null) {
            return calculateWithHeightAndTraversal(0, walkPath)
        }

        var walkPathIndex = 0
        var currentNode = root
        while (true) {
            val left = currentNode?.left
            val right = currentNode?.right
            if (right == null && left == null) {
                break
            }
            if (right == null) {
                walkPathIndex++
                currentNode = left
                continue
            }

            val leftNodeData = isNodeBalanced(left!!)
            if (!leftNodeData.balanced) {
                walkPathIndex++
                currentNode = left
                continue
            }
            val rightNodeDAta = isNodeBalanced(right)
            if (!rightNodeDAta.balanced) {
                walkPath += 1 shl walkPathIndex
                walkPathIndex++
                currentNode = right
                continue
            }

            if (leftNodeData.height == rightNodeDAta.height) {
                walkPath += 1 shl walkPathIndex
                walkPathIndex++
                currentNode = right
                continue
            } else {
                walkPathIndex++
                currentNode = root.left
                continue
            }

        }

        var walkPathReordered = 0
        for(i in 0 until walkPathIndex) {
            val ithDigit = (walkPath shr i) and 1
            walkPathReordered += if (ithDigit == 0) 0 else 1 shl (walkPathIndex - 1 -i)
        }

        return calculateWithHeightAndTraversal(walkPathIndex + 1, walkPathReordered)


    }

    data class NodeData(val balanced: Boolean, val height: Int?) {

    }

    fun isNodeBalanced(treeNode: TreeNode): NodeData {

        var leftLength = 0
        var leftNode = treeNode.left
        while (leftNode != null) {
            leftLength++
            leftNode = leftNode.left
        }
        var rightLength = 0
        var rightNode = treeNode.right
        while (rightNode != null) {
            rightLength++
            rightNode = rightNode.right
        }
        return if (leftLength == rightLength) {
            NodeData(true, leftLength)
        } else
            NodeData(false, null)

    }

    fun calculateWithHeightAndTraversal(height: Int, walkPath: Int): Int {

        return if (height == 0) {
            0
        } else {
            val `2_power_height-1` = 1 shl (height - 1)
            walkPath + `2_power_height-1`
        }

    }



}