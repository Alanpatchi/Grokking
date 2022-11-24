package com.boobalan.grokking.coding.twoPointers

import java.util.Arrays

fun main(args: Array<String>) {
    val input = intArrayOf(-3, 0, 1, 2, -1, 1, -2)

    Arrays.sort(input)

    val n = input.size
    val output: MutableSet<IntArray> = HashSet()
    for (i in input.indices) {
        if (i == 0 /*but always consider 1st element*/ || input[i] != input[i-1] /*remove duplicates*/) {

            val targetSum = 0-input[i]

            var p1 = i+1
            var p2 = n-1

            var currentSum: Int
            while ( p1 < p2) {

                if (p1 == i+1 /*always consider 1st element*/  || input[p1] != input[p1-1] /*remove duplicates*/ ) {
                    if (p2 == n-1 /*always consider 1st element*/  || input[p2] != input[p2+1] /*remove duplicates*/ ) {
                        currentSum = input[p1] + input[p2]
                        when {
                            currentSum < targetSum -> p1++
                            currentSum > targetSum -> p2--
                            else -> {
                                output.add(intArrayOf(input[i], input[p1], input[p2]))
                                p1++
                            }
                        }
                    } else {
                        p2--
                    }
                } else {
                    p1++
                }



            }

        }
    }

    println(output.size)

    output.forEach { ints: IntArray ->
        println(ints.contentToString())
    }


}