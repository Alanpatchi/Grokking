package com.boobalan.grokking.coding.treeBreadthFirstSearch

import java.util.LinkedList
import java.util.Queue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


fun traverse(treeNode: TreeNode): List<List<Int>> {
    var queue: LinkedList<TreeNode> = LinkedList<TreeNode>()
    queue.add(treeNode)
    var level = 0
    val traverseList = ArrayList<List<Int>>()
    while (queue.isNotEmpty()) {

        val size = queue.size;
        val levelList = ArrayList<Int>()
        for (i in 0 until size) {
            val elem = queue.remove()
            elem.left?.also {
                queue.add(it)
            }
            elem.right?.also {
                queue.add(it)
            }
            when (level.mod(2)) {
                0 ->             levelList.add(elem.`val`)
                else ->             levelList.add(0, elem.`val`)


            }
        }
        traverseList.add( levelList)
        level++
    }
    return traverseList
}

fun main(args: Array<String>) {
    val root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left!!.left = TreeNode(9)
    root.right!!.left = TreeNode(10)
    root.right!!.right = TreeNode(5)
    val result: List<List<Int>> = traverse(root)
    println("Level order traversal: $result")

}