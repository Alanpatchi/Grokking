package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Contains Duplicate II Test` {

    @Test
    fun testContainsNearbyDuplicate() {
        Assertions.assertTrue(`Contains Duplicate II`().containsNearbyDuplicate(intArrayOf(1,2,3,1), 3))
    }
}