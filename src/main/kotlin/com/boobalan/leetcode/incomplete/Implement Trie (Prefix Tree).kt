package com.boobalan.leetcode.incomplete


class `Implement Trie (Prefix Tree)` {

    class TrieNode (var count: Int = 0, var nextLetterArray: Array<TrieNode?>? = null)

    var ROOTNODE = TrieNode()

    private fun lookUpIndex(char: Char): Int {
        return char - 'a'
    }
    private fun getCharForIndex(index: Int): Char {
        return 'a' + index
    }


    fun insert(word: String) {
        var currentNode: TrieNode = ROOTNODE
        for (i in word.indices) {
            if (currentNode.nextLetterArray == null) {
                currentNode.nextLetterArray = arrayOfNulls(26)
            }
            val lookUpIndex = lookUpIndex(word[i])
            if (currentNode.nextLetterArray!![lookUpIndex] == null) {
                currentNode.nextLetterArray!![lookUpIndex] = TrieNode()
            }
            currentNode= (currentNode.nextLetterArray!![lookUpIndex])!!
        }
        currentNode.count = 1

    }

    fun search(word: String): Boolean {
        try {
            var currentNode: TrieNode = ROOTNODE
            for (i in word.indices) {
                val lookUpIndex = lookUpIndex(word[i])
                currentNode = currentNode.nextLetterArray!![lookUpIndex]!!
            }
            return currentNode.count == 1
        } catch (e: Throwable) {
            return false
        }
    }

    fun startsWith(prefix: String): Boolean {
        try {
            var currentNode: TrieNode = ROOTNODE
            for (i in prefix.indices) {
                val lookUpIndex = lookUpIndex(prefix[i])
                currentNode = currentNode.nextLetterArray!![lookUpIndex]!!
            }
            return true
        } catch (e: Throwable) {
            return false
        }

    }
}