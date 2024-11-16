package com.boobalan.leetcode

import java.util.LinkedList
import java.util.Queue
import kotlin.random.Random

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/?envType=study-plan-v2&envId=top-interview-150
 */

class `Sum Root to Leaf Numbers` {

    var sum: Int = 0
    fun sumNumbers(root: TreeNode?): Int {

        return if (Random.nextInt(1) == 1) {
            BFS().sumNumbers(root)
        } else {
            Recursive().sumNumbers(root)
        }

    }

    class BFS {

        fun sumNumbers(root: TreeNode?): Int {

            var sum = 0
            root?.let { treeNode ->
                val queue: Queue<Pair<TreeNode, Int>> = LinkedList()
                queue.add(Pair(treeNode, 0))
                while (queue.isNotEmpty()) {
                    val v = queue.poll()
                    val node = v.first
                    val nodeValue = (v.second * 10) + node.`val`
                    if (node.left == null && node.right == null) {
                        sum += nodeValue
                    } else {
                        node.left?.let { queue.add(Pair(it, nodeValue)) }
                        node.right?.let { queue.add(Pair(it, nodeValue)) }
                    }

                }

            }
            return sum


        }

    }

    class Recursive {

        var sum: Int = 0
        fun sumNumbers(root: TreeNode?): Int {

            root?.let { visitNode(it, 0)  }
            return sum

        }

        private fun visitNode(node: TreeNode, prefixInt: Int) {

            val leftChild = node.left
            val rightChild = node.right

            if (leftChild == null && rightChild == null) {
                sum += (prefixInt * 10) + node.`val`
            }

            leftChild?.let { visitNode(it, (prefixInt * 10) + node.`val`) }
            rightChild?.let { visitNode(it, (prefixInt * 10) + node.`val`) }

        }

    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

