package com.boobalan.leetcode

import kotlin.experimental.and
import kotlin.experimental.or
import kotlin.experimental.xor
import kotlin.math.max

class `Add Binary` {

    fun addBinary(a: String, b: String): String {
        var aIndex = a.length -1
        var bIndex = b.length -1
        val sb = StringBuilder()
        var carry = 0
        while (aIndex >= 0 || bIndex >= 0 || carry == 1) {
            if (aIndex >= 0) {
                carry += a[aIndex] - '0'
            }
            if (bIndex >= 0) {
                carry += b[bIndex] - '0'
            }
            sb.append(carry % 2)
            carry /=2
            aIndex--
            bIndex--
        }
        return sb.reverse().toString()
    }


    private fun getByteValueOfChar(char: Char): Byte {
        return if (char == '1')
            1
        else
            0
    }



}