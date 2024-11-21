package com.boobalan.leetcode.incomplete

class `Reverse Bits` {

    fun reverseBits(n:Int):Int {
        var value = n
        var returnValue = 0
        for ( i in 1..32) {
            val digit = (value and 1)
            returnValue = returnValue shl 1
            returnValue += digit
            value = value ushr 1
        }
        return returnValue
    }
}