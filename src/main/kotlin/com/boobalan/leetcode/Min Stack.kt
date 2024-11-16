package com.boobalan.leetcode

import java.util.*

class MinStack() {

    data class ElemMinData(val elem: Int, val minimum: Int)

    var stack = LinkedList<ElemMinData>()

    fun push(`val`: Int) {
        if (stack.isEmpty()) {
            stack.push(ElemMinData(elem = `val`, minimum = `val`))
        } else {
            stack.push(ElemMinData(elem = `val`, minimum = minOf(stack.peek().minimum, `val`)))
        }
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack.peek().elem
    }

    fun getMin(): Int {
        return stack.peek().minimum
    }

}