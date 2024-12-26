package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Simplefy Path Test` {

    @Test
    fun simplifyPathCase1() {
        assertEquals("/home", `Simplify Path`().simplifyPath("/home/"))
    }

    @Test
    fun simplifyPathCase2() {
        assertEquals("/home/foo", `Simplify Path`().simplifyPath("/home//foo/"))
    }

    @Test
    fun simplifyPathCase3() {
        assertEquals( "/home/user/Pictures", `Simplify Path`().simplifyPath("/home/user/Documents/../Pictures"))
    }

    @Test
    fun simplifyPathCase4() {
        assertEquals("/", `Simplify Path`().simplifyPath("/../"))
    }

    @Test
    fun simplifyPathCase5() {
        assertEquals("/.../b/d", `Simplify Path`().simplifyPath("/.../a/../b/c/../d/./"))
    }
}