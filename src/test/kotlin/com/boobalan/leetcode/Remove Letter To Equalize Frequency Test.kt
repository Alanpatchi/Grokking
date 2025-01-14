package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class `Remove Letter To Equalize Frequency Test` {

    @Test
    fun equalFrequency() {
        val equalFrequency = `Remove Letter To Equalize Frequency`().equalFrequency("abcc")
        assertTrue(equalFrequency)
    }

    @Test
    fun equalFrequencyCase1() {
        val equalFrequency = `Remove Letter To Equalize Frequency`().equalFrequency("aazz")
        assertFalse(equalFrequency)
    }

    @Test
    fun equalFrequencyCase3() {
        val equalFrequency = `Remove Letter To Equalize Frequency`().equalFrequency("cccaa")
        assertTrue(equalFrequency)
    }

    @Test
    fun equalFrequencyCase2() {
        val equalFrequency = `Remove Letter To Equalize Frequency`().equalFrequency("bac")
        assertTrue(equalFrequency)
    }

    @Test
    fun equalFrequencyCase4() {
        val equalFrequency = `Remove Letter To Equalize Frequency`().equalFrequency("nrasgxxgzbauawveefbuidghpsrresgremsawuybxsxmfamdesxabrcdrdcf")
        assertFalse(equalFrequency)
    }

    @Test
    fun equalFrequencyCase5() {
        val equalFrequency = `Remove Letter To Equalize Frequency`().equalFrequency("zz")
        assertTrue(equalFrequency)
    }

    @Test
    fun equalFrequencyCase6() {
        val equalFrequency = `Remove Letter To Equalize Frequency`().equalFrequency("cccd")
        assertTrue(equalFrequency)
    }

    @Test
    fun equalFrequencyCase7() {
        val equalFrequency = `Remove Letter To Equalize Frequency`().equalFrequency("cbccca")
        assertFalse(equalFrequency)
    }

}