package com.boobalan.leetcode

import com.boobalan.leetcode.incomplete.`Reverse Nodes in k-Group`
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.TypeSafeMatcher
import org.junit.jupiter.api.Test


/**
 * Matches a ListNode chain where the values of the nodes match the given list of values.
 *
 * @param expectedValues The expected values of the nodes in the chain.
 */
fun listNodeChainMatches(vararg expectedValues: Int): Matcher<ListNode?> {
    return object : TypeSafeMatcher<ListNode?>() {
        override fun matchesSafely(item: ListNode?): Boolean {
            var current: ListNode? = item
            for (expectedValue in expectedValues) {
                if (current == null || current.`val` != expectedValue) {
                    return false
                }
                current = current.next
            }
            return current == null // Ensure the chain ends at the expected length
        }

        override fun describeTo(description: Description) {
            description.appendText("a ListNode chain with values ")
            description.appendValueList("[", ", ", "]", expectedValues)
        }

        override fun describeMismatchSafely(item: ListNode?, mismatchDescription: Description) {
            mismatchDescription.appendText("was a ListNode chain with values [")
            var currentNode = item
            while (currentNode != null) {
                mismatchDescription.appendValue(currentNode.`val`)
                if (currentNode.next != null) {
                    mismatchDescription.appendText(", ")
                }
                currentNode = currentNode.next
            }
            mismatchDescription.appendText("]")
        }
    }
}


fun createLinkedList(values: IntArray): ListNode? {
    if (values.isEmpty()) return null

    val head = ListNode(values[0])
    var current = head
    for (i in 1 until values.size) {
        current.next = ListNode(values[i])
        current = current.next!!
    }
    return head
}


class `Reverse Nodes in k-Group Test` {

    @Test
    fun reverseKGroupSample1() {
        val reverseKGroup = `Reverse Nodes in k-Group`().reverseKGroup(createLinkedList(intArrayOf(1, 2, 3, 4, 5)), 2)
        assertThat(reverseKGroup, listNodeChainMatches(2, 1, 4, 3, 5))
    }

    @Test
    fun reverseKGroupSample2() {
        val reverseKGroup = `Reverse Nodes in k-Group`().reverseKGroup(createLinkedList(intArrayOf(1, 2, 3, 4, 5)), 3)
        assertThat(reverseKGroup, listNodeChainMatches(3, 2, 1, 4, 5))
    }
}