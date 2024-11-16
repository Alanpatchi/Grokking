package com.boobalan.leetcode.incomplete


/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}

class `Clone Graph` {

    fun cloneGraph(node: Node?): Node? {
        val nodeMap = mutableMapOf<Int, Node>()
        return if (node == null) null else cloneNode(node, nodeMap)
    }

    fun cloneNode(node: Node, nodeMap: MutableMap<Int, Node>): Node {
        val copy = Node(node.`val`)
        nodeMap[node.`val`] = copy
        for(neighbor in node.neighbors) {
            if (nodeMap[neighbor!!.`val`] != null) {
                copy.neighbors.add(nodeMap[neighbor.`val`])
            } else
                copy.neighbors.add(cloneNode(neighbor, nodeMap))

        }
        return copy
    }

}