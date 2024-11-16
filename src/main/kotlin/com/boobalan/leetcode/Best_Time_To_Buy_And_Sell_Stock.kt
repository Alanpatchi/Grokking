package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150
 */
class Best_Time_To_Buy_And_Sell_Stock {

    fun maxProfit(prices: IntArray) : Int {

        var lastDayValue = Int.MAX_VALUE
        var profit = 0
        for (i in prices.indices) {
            if (prices[i] > lastDayValue) {
                profit += prices[i] - lastDayValue
            }
            lastDayValue = prices[i]
        }
        return profit;
    }
}