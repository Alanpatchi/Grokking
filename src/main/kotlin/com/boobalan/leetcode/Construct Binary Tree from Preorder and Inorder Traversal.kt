package com.boobalan.leetcode

class `Construct Binary Tree from Preorder and Inorder Traversal` {

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {

        val preOrderList = preorder.asList()
        val inOrderList = inorder.asList()

        val inorderPositionMap = hashMapOf<Int, Int>()
        for (i in inorder.indices) {
            inorderPositionMap[inorder[i]] = i
        }
        return buildTree(preOrderList, inOrderList, 0, inorderPositionMap)


    }

    private fun buildTree(preorder: List<Int>, inorder: List<Int>, inOrderBeginIndex: Int, inOrderPositionMap: HashMap<Int, Int>): TreeNode? {

        if (preorder.isNotEmpty()) {
            val rootTree = TreeNode(preorder[0])
//            var i = 0
//            while (i < inorder.size) {
//                if (inorder[i] == preorder[0]) {
//                    break
//                }
//                i++
//            }
            val i = inOrderPositionMap[preorder[0]]!! - inOrderBeginIndex

            if (preorder.size > 1 && i < inorder.size) {
                val leftTree = buildTree(preorder.subList(1, i + 1), inorder.subList(0, i), inOrderBeginIndex, inOrderPositionMap)
                rootTree.left = leftTree
            }

            if (i + 1 < inorder.size) {
                val rightTree = buildTree(preorder.subList(i + 1, preorder.size), inorder.subList(i + 1, inorder.size), inOrderBeginIndex + i + 1, inOrderPositionMap)
                rootTree.right = rightTree
            }
            return rootTree
        } else {
            return null
        }
    }
}