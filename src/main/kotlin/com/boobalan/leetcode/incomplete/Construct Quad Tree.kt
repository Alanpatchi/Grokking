package com.boobalan.leetcode.incomplete


class `Construct Quad Tree` {


    /**
     * Definition for a QuadTree node.
     * */

    class Node(var `val`: Boolean, var isLeaf: Boolean) {
        var topLeft: Node? = null
        var topRight: Node? = null
        var bottomLeft: Node? = null
        var bottomRight: Node? = null
    }

    fun construct(grid: Array<IntArray>): Node? {
        return construct(grid, 0, grid.size - 1, 0, grid[0].size - 1)
    }

    fun construct(grid: Array<IntArray>, rowBegin: Int, rowEnd: Int, colBegin: Int, colEnd: Int): Node {

        if (rowBegin == rowEnd && colBegin == colEnd) {
            return Node(grid[rowEnd][colEnd] == 1, true)
        }

        val rowTemp = (rowBegin + rowEnd) / 2
        val uRowBegin = rowBegin
        val uRowEnd = rowTemp
        val dRowBegin = rowTemp + 1
        val dRowEnd = rowEnd

        val colTemp = (colBegin + colEnd) / 2
        val lColBegin = colBegin
        val lColEnd = colTemp
        val rColBegin = colTemp + 1
        val rColEnd = colEnd

        val nodeLeftUp = construct(
            grid = grid,
            rowBegin = uRowBegin,
            rowEnd = uRowEnd,
            colBegin = lColBegin,
            colEnd = lColEnd
        )

        val nodeRightUp = construct(
            grid = grid,
            rowBegin = uRowBegin,
            rowEnd = uRowEnd,
            colBegin = rColBegin,
            colEnd = rColEnd
        )

        val nodeLeftDown = construct(
            grid = grid,
            rowBegin = dRowBegin,
            rowEnd = dRowEnd,
            colBegin = lColBegin,
            colEnd = lColEnd
        )

        val nodeRightDown = construct(
            grid = grid,
            rowBegin = dRowBegin,
            rowEnd = dRowEnd,
            colBegin = rColBegin,
            colEnd = rColEnd
        )




        val allChildNodesAreLeaf = nodeLeftUp.isLeaf && nodeLeftDown.isLeaf && nodeRightDown.isLeaf && nodeRightUp.isLeaf

        var allChildNodeValuesAreEqual = false
        if (nodeLeftUp.`val` == nodeLeftDown.`val`) {
            if (nodeLeftDown.`val` == nodeRightDown.`val`) {
                if (nodeRightDown.`val` == nodeRightUp.`val`) {
                    allChildNodeValuesAreEqual = true
                }
            }
        }
        if (allChildNodesAreLeaf && allChildNodeValuesAreEqual) {
            return Node(nodeLeftUp.`val`, true)
        } else {
            val node = Node(`val` = false, isLeaf = false)
            node.topLeft = nodeLeftUp
            node.topRight = nodeRightUp
            node.bottomLeft = nodeLeftDown
            node.bottomRight = nodeRightDown
            return node
        }


    }
}