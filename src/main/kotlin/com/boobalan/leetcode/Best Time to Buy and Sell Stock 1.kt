package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/?envType=study-plan-v2&envId=top-interview-150
 */
class `Best Time to Buy and Sell Stock 1` {

    fun maxProfit(prices: IntArray): Int {

        var previousDayPrice = prices[0]
        var maximumProfit = 0
        var contiguousProfit = 0
        for ( i in 1 until prices.size) {

            val dayProfit = prices[i] - previousDayPrice
            contiguousProfit += dayProfit
            if (contiguousProfit < 0) {
                contiguousProfit = 0
            }
//            if (dayProfit >= 0) {
//                contiguousProfit += dayProfit
//            } else {
//                contiguousProfit = 0
//            }
            if (contiguousProfit > maximumProfit) {
                maximumProfit = contiguousProfit
            }
            previousDayPrice = prices[i]
        }
        return maximumProfit
    }

}

fun main(args: Array<String>) {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println( `Best Time to Buy and Sell Stock 1`().maxProfit(prices) )
}