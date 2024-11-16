package com.boobalan.leetcode.incomplete

fun main(args: Array<String>) {


//    var letter: Char = 'a'
//    var number: Int = 96
//    var lt: Char = number.toChar()
//    println(lt)

    val groupAnagrams = groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))

    for(uniqueWords: List<String> in groupAnagrams) {
        println(uniqueWords)
    }


}


class Word (val letterMap: IntArray, val size: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (this.size == (other as Word).size) {
            if (this.letterMap.contentEquals(other.letterMap)) {
                return true
            }
        }
        return false
    }

    override fun hashCode(): Int {
        return (31 * this.letterMap.contentHashCode()) + size
    }
}


fun groupAnagrams(strs: Array<String>): List<List<String>> {

    val uniqueWords: MutableMap<Word, MutableList<String>> = mutableMapOf()

    for (word in strs) {
        val letterMap = IntArray(26)
        for (letter: Char in word.toCharArray()) {
            val pos = letter - 'a'
            letterMap[pos]++
        }
       val letterCount = letterMap.sum()

        val wordObj = Word(letterMap, letterCount)

        val uniqueWordsList: MutableList<String>? = uniqueWords[wordObj]
        if (uniqueWordsList == null) {
            uniqueWords[wordObj] = arrayListOf(word)
        } else {
            uniqueWordsList += word
        }

    }

    return uniqueWords.values.toList()
}