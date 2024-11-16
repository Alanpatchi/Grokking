package com.boobalan.leetcode.incomplete

class Combinations {


    // TODO solve via backtracking
    fun combine(n: Int, k: Int): List<List<Int>> {

        return combine(1, k, n)

    }


    fun combine(begin: Int, numberOfElementsToChoose: Int, n: Int): MutableList<MutableList<Int>> {
       var elementChosen = begin
        if (numberOfElementsToChoose == 1) {
            return  (begin .. n).map { mutableListOf(it) }.toMutableList()
        }
        if ( numberOfElementsToChoose == (n - begin + 1) ){
            return mutableListOf((begin .. n).toMutableList())
         }

        // begin chosen
        val beginChosen = combine(begin + 1, numberOfElementsToChoose - 1, n)

        beginChosen.forEach { list -> list.add(elementChosen) }

        val beginNotChosen = combine(begin + 1, numberOfElementsToChoose, n)

         beginChosen.addAll(beginNotChosen)

        return beginChosen
    }
}