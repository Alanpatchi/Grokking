package com.boobalan.leetcode.incomplete

import kotlin.math.max

class `Best Time to Buy and Sell Stock IV` {

    fun maxProfit(k: Int, prices: IntArray): Int {

        val dayCount = prices.size
        val dp = Array(k+1)  // row index indicates times
        {
            IntArray(dayCount)  // column in dex indicates days
        }

        for (time in 1 .. k) {
            for (day in 1 until dayCount) {

                // n- times
                // d - day
                // s(n, d) = maxOf (s(n-1, i) + pr(d) - pr(i+1) -->  for i = 0 to d-1, pr(d) - pr(0), s(n , d-1)

                var maxPrice = prices[day] - prices[0]
                for (i in 0 until  day) {
                    maxPrice = max(maxPrice, dp[time-1][i] + prices[day] - prices[i+1])
                }
                maxPrice = max(maxPrice, dp[time][day-1])
                dp[time][day] = maxPrice
            }
        }

        return dp[k][dayCount-1]

    }
}