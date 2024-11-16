package com.boobalan.grokking.leetcode

class StringToInt {
    fun myAtoi(s: String): Int {

        var i =0
        while (i < s.length && s[i] == ' ' ) {
            i++
        }


        var isNegative = false
        if (i < s.length && (s[i] == '+' || s[i] == '-')) {
            if (s[i] == '-') {
                isNegative = true
            }
            i++
        }

        var output = 0
        if (isNegative) {
            loop@while (i < s.length && Character.isDigit(s[i])) {

                if (output < Int.MIN_VALUE / 10) {
                    output = Int.MIN_VALUE
                    break@loop
                }
                output *= 10

                if (output < Int.MIN_VALUE + (s[i] - '0')) {
                    output = Int.MIN_VALUE
                } else {
                    output -= s[i] - '0'
                }
                i++
            }
        } else {
            loop@while (i < s.length && Character.isDigit(s[i])) {

                if (output > Int.MAX_VALUE / 10) {
                    output = Int.MAX_VALUE
                    break@loop
                }
                output *= 10

                if (output > Int.MAX_VALUE - (s[i] - '0')) {
                    output = Int.MAX_VALUE
                } else {
                    output += s[i] - '0'
                }
                i++
            }
        }

        return output

    }
}

fun main(args: Array<String>) {
    println(StringToInt().myAtoi("42"))
    println(StringToInt().myAtoi("     -42"))
    println(StringToInt().myAtoi("4193 with words"))
    println(StringToInt().myAtoi("2147483648"))
}