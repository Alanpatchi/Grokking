package com.boobalan.leetcode.incomplete

class `Word Ladder` {


    class WordNode(val word: String, var parent: WordNode? = null) {
    }


    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        // pick out endWord form the list
        // pick out words from wordList that are 1-char away from endWord and add each as parent to the corresponding previousTime Pickout work to the endWord

        // everytime when pickout word check if the word is 1-char away from begin Word, if so traverse output the length of the traversal from beginWord through the pickout word's parent link to endWord

        val beginWordNode = WordNode(beginWord)
        val endWordNode = WordNode(endWord)

        val mutableWordList = MutableList(wordList.size) {

            if (wordList[it] == beginWord) {
                return@MutableList beginWordNode
            } else if (wordList[it] == endWord) {
                return@MutableList endWordNode
            }
            WordNode(wordList[it])
        }


        var latestPickoutWordList = listOf(endWordNode)

        if (mutableWordList.contains(endWordNode)) {
            mutableWordList.remove(endWordNode)
        } else
            return 0

        var currentPickoutList = mutableListOf<WordNode>()


        var newPickOutListFormed = true

        var reachablePickoutWordFromBeginNode: WordNode? = null

        outer@ while (newPickOutListFormed) {
            newPickOutListFormed = false
            for (pickOutWord in latestPickoutWordList) {

                if (beginWordNode.isSingleLetterDifference(pickOutWord)) {
                    reachablePickoutWordFromBeginNode = pickOutWord
                    beginWordNode.parent = pickOutWord
                    break@outer
                } else {
                    val wordNodeMutableIterator = mutableWordList.iterator()
                    while (wordNodeMutableIterator.hasNext()) {
                        val wordNode = wordNodeMutableIterator.next()
                        if (wordNode.isSingleLetterDifference(pickOutWord)) {
                            newPickOutListFormed = true
                            wordNode.parent = pickOutWord
                            currentPickoutList.add(wordNode)
                            wordNodeMutableIterator.remove()
                        }
                    }

                }

            }
            latestPickoutWordList = currentPickoutList
            currentPickoutList = mutableListOf()
        }

        if (reachablePickoutWordFromBeginNode != null) {
            var currentNode = beginWordNode
            var distance = 0
            while (currentNode.word != endWord) {
                currentNode = currentNode.parent!!
                distance++
            }
            return distance + 1
        }


        return 0


    }

    private fun WordNode.isSingleLetterDifference(word2: WordNode): Boolean {
        return isSingleLetterDifference(this.word, word2.word)
    }

    private fun isSingleLetterDifference(word1: String, word2: String): Boolean {

        var isSingleLetterDifference = false
        for (i in word1.indices) {
            if (word1[i] != word2[i]) {
                if (isSingleLetterDifference) {
                    return false
                }
                isSingleLetterDifference = true
            }
        }
        return isSingleLetterDifference
    }


}