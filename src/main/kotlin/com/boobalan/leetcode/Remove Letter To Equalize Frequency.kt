package com.boobalan.leetcode

import kotlin.math.max
import kotlin.math.min

class `Remove Letter To Equalize Frequency` {

    fun equalFrequency(word: String): Boolean {
        val uniqueLetterToFrequency = hashMapOf<Char, Int>()
        val frequencyToUniqueLetterCount = hashMapOf<Int, Int>()
        for (char in word) {
            val currentFrequency = uniqueLetterToFrequency[char]
            val newFrequency: Int
            if (currentFrequency == null) {
                newFrequency = 1
                uniqueLetterToFrequency[char] = newFrequency
                val uniqueLettersWith1Frequency = frequencyToUniqueLetterCount[1]
                if (uniqueLettersWith1Frequency == null) {
                    frequencyToUniqueLetterCount[1] = 1
                } else {
                    frequencyToUniqueLetterCount[1] = uniqueLettersWith1Frequency + 1
                }
            } else {
                newFrequency = currentFrequency + 1
                uniqueLetterToFrequency[char] = newFrequency

                val uniqueLettersWithCurrentFrequency = frequencyToUniqueLetterCount[currentFrequency]!!
                if (uniqueLettersWithCurrentFrequency == 1) {
                    frequencyToUniqueLetterCount.remove(currentFrequency)
                } else {
                    frequencyToUniqueLetterCount[currentFrequency] = uniqueLettersWithCurrentFrequency - 1
                }

                val uniqueLettersWithNewFrequencyFrequency =  frequencyToUniqueLetterCount[newFrequency]
                if (uniqueLettersWithNewFrequencyFrequency == null) {
                    frequencyToUniqueLetterCount[newFrequency] = 1
                } else {
                    frequencyToUniqueLetterCount[newFrequency] = uniqueLettersWithNewFrequencyFrequency + 1
                }
            }
        }

        // only one unique letter
        if (uniqueLetterToFrequency.size == 1) {
            return true
        }

        // all letters have count 1
        if (frequencyToUniqueLetterCount.size == 1) {
            if (frequencyToUniqueLetterCount[1] != null) {
                return true
            }
        }

        // if one letter has count 1; and rest other have one other frequency
        if (frequencyToUniqueLetterCount.size == 2) {
            if (frequencyToUniqueLetterCount[1] != null && frequencyToUniqueLetterCount[1] == 1) {
                return true
            }
        }

        // if one letter has count frequency + 1; and rest other have one other frequency
        if (frequencyToUniqueLetterCount.size == 2) {
            var maxKeyValue: Int = Int.MIN_VALUE
            var minKeyValue: Int = Int.MAX_VALUE
            for(key in frequencyToUniqueLetterCount.keys) {
                maxKeyValue = max(key, maxKeyValue)
                minKeyValue = min(key, minKeyValue)
            }

            if (frequencyToUniqueLetterCount[maxKeyValue] == 1 && (maxKeyValue - minKeyValue) == 1) {
                return true
            }
        }

        return false
    }



}