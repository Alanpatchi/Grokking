package com.boobalan.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Coin Change Test` {

    @Test
    fun testCoinChange() {

        Assertions.assertEquals(`Coin Change`().coinChange(intArrayOf(1,2,5), 11)
        , 3)

        Assertions.assertEquals(`Coin Change`().coinChange(intArrayOf(2), 3)
            , -1)


    }
}