package com.boobalan.leetcode

class `Gas Station` {

    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {

        var currentSum = 0

        val size = gas.size

        var minCumulativeGas = 0
        var minCumulativeGasIndex = 0

        var cumulativeGas = 0
        for (i in 1 .. gas.lastIndex) {
            cumulativeGas += gas[i -1] - cost[i -1]
            if (cumulativeGas < minCumulativeGas) {
                minCumulativeGas = cumulativeGas
                minCumulativeGasIndex = i
            }
        }

        cumulativeGas += gas[size - 1] - cost[size - 1]
        return if (cumulativeGas >= 0) {
            minCumulativeGasIndex
        } else {
            -1
        }
    }
}