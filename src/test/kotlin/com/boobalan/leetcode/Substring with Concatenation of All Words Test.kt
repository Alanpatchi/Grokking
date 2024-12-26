package com.boobalan.leetcode

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.collection.IsArrayContainingInOrder
import org.hamcrest.collection.IsEmptyIterable
import org.hamcrest.collection.IsIterableContainingInAnyOrder
import org.junit.jupiter.api.Test

class `Substring with Concatenation of All Words Test` {

    @Test
    fun findSubstringCase1() {
        val findSubstring =
            `Substring with Concatenation of All Words`().findSubstring("barfoothefoobarman", arrayOf("foo", "bar"))
        assertThat(findSubstring, IsIterableContainingInAnyOrder.containsInAnyOrder(0, 9))
    }

    @Test
    fun findSubstringCase2() {
        val findSubstring = `Substring with Concatenation of All Words`().findSubstring(
            "wordgoodgoodgoodbestword",
            arrayOf("word", "good", "best", "word")
        )
        assertThat(findSubstring, IsEmptyIterable.emptyIterable())
    }

    @Test
    fun findSubstringCase3() {
        val findSubstring = `Substring with Concatenation of All Words`().findSubstring(
            "barfoofoobarthefoobarman",
            arrayOf("bar", "foo", "the")
        )
        assertThat(findSubstring, IsIterableContainingInAnyOrder.containsInAnyOrder(6,9,12))
    }

    @Test
    fun findSubstringCase4() {
        val findSubstring = `Substring with Concatenation of All Words`().findSubstring(
            "a",
            arrayOf("a")
        )
        assertThat(findSubstring, IsIterableContainingInAnyOrder.containsInAnyOrder(0))
    }

    @Test
    fun findSubstringCase5() {
        val findSubstring = `Substring with Concatenation of All Words`().findSubstring(
            "ababababab",
            arrayOf("ababa","babab")
        )
        assertThat(findSubstring, IsIterableContainingInAnyOrder.containsInAnyOrder(0))
    }
}