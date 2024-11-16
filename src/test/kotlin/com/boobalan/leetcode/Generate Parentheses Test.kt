package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.`Generate Parentheses`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Generate Parentheses Test` {

    @Test
    fun generateParenthesisTest1() {
        val generateParenthesis = `Generate Parentheses`().generateParenthesis(3)
        assertThat(generateParenthesis, Matchers.containsInAnyOrder("((()))","(()())","(())()","()(())","()()()"))
    }
}