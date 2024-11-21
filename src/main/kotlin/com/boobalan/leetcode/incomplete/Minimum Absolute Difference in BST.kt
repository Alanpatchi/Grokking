package com.boobalan.leetcode.incomplete

import com.boobalan.leetcode.TreeNode
import java.util.ArrayDeque
import kotlin.math.min

class `Minimum Absolute Difference in BST` {

    // visit the BST in order and comapre the currentValue with the previous and find the difference. Get the min of all such difference
    fun getMinimumDifference(root: TreeNode?): Int {

        val stack = ArrayDeque<TreeNode>()
        addCurrentToStack(root, stack)
        var prev= TreeNode(-100000)
        var current: TreeNode?
        var minValue: Int = Int.MAX_VALUE
        while (stack.isNotEmpty()) {
            current = stack.pop()
            minValue = min(minValue, current.`val` - prev.`val`)
            if (current.right != null) {
                addCurrentToStack(current.right, stack)
            }
            prev = current
        }
        return minValue

    }

    private fun addCurrentToStack(
        current: TreeNode?,
        stack: ArrayDeque<TreeNode>
    ){
        var current1 = current
        while (current1 != null) {
            stack.push(current1)
            current1 = current1.left
        }
    }


}