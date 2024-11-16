package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.`Clone Graph`
import org.junit.jupiter.api.Test
import  com.boobalan.leetcode.incomplete.Node

class `Clone Grap Test` {

    @Test
    fun testCloneGraphInput1 () {
        val one: Node = Node(1)
        val two = Node(2)
        val three = Node(3)
        val four = Node(4)
        one.neighbors.add(two)
        one.neighbors.add(four)
        two.neighbors.add(one)
        two.neighbors.add(three)
        three.neighbors.add(two)
        three.neighbors.add(four)
        four.neighbors.add(one)
        four.neighbors.add(three)
        `Clone Graph`().cloneGraph(one)
    }

    @Test
    fun testCloneGraphInput2 () {
        val one: Node = Node(1)
        `Clone Graph`().cloneGraph(one)
    }

}