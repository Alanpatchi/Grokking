package com.boobalan.leetcode.incomplete

fun main(args: Array<String>) {
    println(`Happy Number`().isHappy(2))
}
class `Happy Number` {

    fun isHappy(n: Int): Boolean {

        val set = HashSet<Int>()
        var digitSquareSumValue = digitSquaredSum(n)
        while(!set.contains(digitSquareSumValue)) {
            if(digitSquareSumValue == 1) {
                return true
            } else {
                set.add(digitSquareSumValue)
                digitSquareSumValue = digitSquaredSum(digitSquareSumValue)
            }
        }
        return false
    }


     private fun digitSquaredSum(n: Int): Int {
        var number = n
        var digit = n % 10
        var sumDigit = 0
        while (number != 0) {
            sumDigit += (digit * digit)
            number /= 10
            digit = (number) % 10
        }
        return sumDigit
    }
}