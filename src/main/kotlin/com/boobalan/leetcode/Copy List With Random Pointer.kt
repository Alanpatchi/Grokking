package com.boobalan.leetcode




class `Copy List With Random Pointer` {

    class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }

    fun copyRandomList(node: Node?): Node? {

        val oldToNewNodeMap = hashMapOf<Node, Node>()

        creatingNewNodes(node, oldToNewNodeMap)

        // making random references
        copyingRandomReferences(node, oldToNewNodeMap)

        return node?.let { oldToNewNodeMap[node] }

    }

    private fun copyingRandomReferences(
        node: Node?,
        oldToNewNodeMap: HashMap<Node, Node>
    ) {

        var oldNode: Node? = node

        while (oldNode != null) {
            oldNode.random?.let {
                val newNode = oldToNewNodeMap[oldNode]
                val newNodeReference = oldToNewNodeMap[it]
                newNode!!.random = newNodeReference

            }
            oldNode = oldNode.next
        }


    }

    /**
     * creating new node using node.next references chain-ing
      */
    private fun creatingNewNodes(
        node: Node?,
        oldToNewNodeMap: HashMap<Node, Node>
    ) {
        var prevOldNode: Node? = null
        var prevNewNode: Node? = null

        var currentOldNode: Node? = node
        var currentNewNode: Node? = currentOldNode?.let newNode@{
            val newNode = Node(it.`val`)
            oldToNewNodeMap[currentOldNode!!] = newNode
            return@newNode newNode
        }

        while (currentOldNode != null) {
            val tempOldNode = currentOldNode
            val tempNewNode = currentNewNode

            currentOldNode = currentOldNode.next
            currentNewNode = currentOldNode?.let newNode@{
                val newNode = Node(it.`val`)
                oldToNewNodeMap[it] = newNode
                return@newNode newNode
            }
            tempNewNode!!.next = currentNewNode

            prevOldNode = tempOldNode
            prevNewNode = tempNewNode

        }
    }

}