package com.boobalan.leetcode.incomplete

import kotlin.math.abs

class `Pow(x, n)` {


    fun myPow(x: Double, n: Int): Double {

        return myPow(x, n, HashMap())
    }

    private fun myPow(x: Double, n: Int, memoization: MutableMap<Int, Double?>): Double {

        when (n) {
            -1 -> {
                return 1 / x
            }

            0 -> return 1.0
            1 -> return x
        }

        val divider = n / 2
        val otherDivider = n - divider
        val secondHalf: Double = memoization[abs(otherDivider)] ?: myPow(x, otherDivider, memoization)
        val firstHalf = memoization[abs(divider)] ?: myPow(x, divider, memoization)
        val value = firstHalf * secondHalf
        memoization[abs(n)] = value
        return value

    }




}