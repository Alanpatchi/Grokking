package com.boobalan.leetcode

import kotlin.math.min

/**
 * https://leetcode.com/problems/coin-change/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * Pattern: Dynamic programming
 */
class `Coin Change` {

    fun coinChange(coins: IntArray, amount: Int): Int {

        val dp= IntArray(amount + 1) {amount + 1}

        dp[0] = 0

        for(coin in coins) {

            for(value in coin..amount) {
                dp[value] = min(dp[value],  dp[value - coin] + 1)
            }

        }
        return if (dp[amount] == amount + 1) -1 else dp[amount]
    }
}