package com.boobalan.leetcode

import java.util.*

class `Design Add and Search Words Data Structure` {


    val root: TrieNode = TrieNode('$')

    class TrieNode(val char: Char, var terminates: Boolean = false, val nextLetters: Array<TrieNode?> = Array(26) { null })

    fun addWord(word: String) {
        var i = 0
        var currentNode = root
        var nextNode: TrieNode? = null
        while (i < word.length) {
            val char = word[i]
            nextNode = currentNode.nextLetters[char - 'a']
            if (nextNode == null) {
                val newNode = TrieNode(char)
                currentNode.nextLetters[char - 'a'] = newNode
                nextNode = newNode
            }
            currentNode = nextNode
            i++
        }
        currentNode.terminates = true

    }

    fun search(word: String): Boolean {
        var i = 0
        val queue = LinkedList<TrieNode>()
        queue.offer(root)
        var nodeCountInCurrentLevel = 1
        var nodeCountInNextLevel = 0
        while (queue.isNotEmpty() && i < word.length) {
            val node = queue.poll()
            nodeCountInCurrentLevel--
            val letterToMatch = word[i]
            if (letterToMatch != '.') {
                val nextLetterNode = node.nextLetters[letterToMatch - 'a']
                if (nextLetterNode != null) {
                    queue.offer(nextLetterNode)
                    nodeCountInNextLevel++
                }
            } else {
                for (nextLetter in node.nextLetters.filterNotNull()) {
                    queue.offer(nextLetter)
                    nodeCountInNextLevel++
                }
            }
            if (nodeCountInCurrentLevel == 0) {
                i++
                nodeCountInCurrentLevel = nodeCountInNextLevel
                nodeCountInNextLevel = 0
            }
        }

        return if (queue.isEmpty()) {
            false
        } else {
            queue.any {
                it.terminates
            }
        }

    }
}