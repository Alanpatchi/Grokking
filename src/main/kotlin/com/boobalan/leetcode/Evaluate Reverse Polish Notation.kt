package com.boobalan.leetcode

import java.util.IllegalFormatException
import java.util.LinkedList

class `Evaluate Reverse Polish Notation` {

    fun evalRPN(tokens: Array<String>): Int {

        if (tokens.size == 1) {
            return Integer.valueOf(tokens[0])
        }
        var tokenPosition = 0
        val allowedOperationsArray = arrayOf("*", "/", "+", "-")
        val operationQueue = LinkedList<String>()
        while (tokenPosition < tokens.size) {
            while (tokens[tokenPosition] !in allowedOperationsArray) {
                operationQueue.push(tokens[tokenPosition++])
            }

            val b = operationQueue.pop()
            val a = operationQueue.pop()
            val evalOperation = evalOperation(Integer.valueOf(a), Integer.valueOf(b), tokens[tokenPosition++])
            operationQueue.push(evalOperation.toString())


        }

        return Integer.valueOf(operationQueue.pop())



    }

    fun evalOperation(a: Int , b: Int , operationString: String ): Int {
        return when(operationString) {
            "*" -> a * b
            "/" -> a / b
            "-" -> a - b
            else -> a + b
        }
    }

}