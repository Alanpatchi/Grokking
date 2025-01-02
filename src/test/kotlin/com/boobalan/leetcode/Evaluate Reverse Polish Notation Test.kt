package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Evaluate Reverse Polish Notation Test` {

    @Test
    fun evalRPNCase1() {
        val evalRPN = `Evaluate Reverse Polish Notation`().evalRPN(arrayOf("2", "1", "+", "3", "*"))
        assertEquals(9, evalRPN)

    }

    @Test
    fun evalRPNCase2() {
        val evalRPN = `Evaluate Reverse Polish Notation`().evalRPN(arrayOf("4","13","5","/","+"))
        assertEquals(6, evalRPN)

    }

    @Test
    fun evalRPNCase3() {
        val evalRPN = `Evaluate Reverse Polish Notation`().evalRPN(arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+"))
        assertEquals(22, evalRPN)

    }


}