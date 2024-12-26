package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Search in Rotated Sorted Array Test` {

    @Test
    fun searchSample1() {
        val search = `Search in Rotated Sorted Array`().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0)
        assertEquals(4, search)
    }

    @Test
    fun searchSample2() {
        val search = `Search in Rotated Sorted Array`().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3)
        assertEquals(-1, search)
    }

    @Test
    fun searchSample3() {
        val search = `Search in Rotated Sorted Array`().search(intArrayOf(1), 0)
        assertEquals(-1, search)
    }

    @Test
    fun searchSample4() {
        val search = `Search in Rotated Sorted Array`().search(intArrayOf(8, 1, 2, 4, 5, 6, 7), 0)
        assertEquals(-1, search)
    }

    @Test
    fun searchSample5() {
        val search = `Search in Rotated Sorted Array`().search(intArrayOf(4, 5, 6, 7, 0, 1, 2, 3), 0)
        assertEquals(4, search)
    }

    @Test
    fun searchSample6() {
        val search = `Search in Rotated Sorted Array`().search(intArrayOf(1, 2, 4, 5, 6, 7, 9, 0), 0)
        assertEquals(7, search)
    }

    @Test
    fun searchSample7() {
        val search = `Search in Rotated Sorted Array`().search(intArrayOf(1, 2, 4, 5, 6, 7, 9), 0)
        assertEquals(-1, search)
    }

    @Test
    fun searchSample8() {
        val search = `Search in Rotated Sorted Array`().search(intArrayOf(9, 1, 2, 4, 5, 6, 7, 8), 0)
        assertEquals(-1, search)
    }

    @Test
    fun searchSample9() {
        val search = `Search in Rotated Sorted Array`().search(intArrayOf(1, 3), 1)
        assertEquals(0, search)
    }
}