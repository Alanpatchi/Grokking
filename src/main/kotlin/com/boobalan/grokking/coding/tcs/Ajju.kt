package com.boobalan.grokking.coding.tcs

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {

//    val reader = BufferedReader(InputStreamReader(System.`in`))
//
//    val readLine = reader.readLine()
//
//    val pillarHeights = readLine?.split(" ")?.map { it.toInt() }?.toTypedArray()
//
//    pillarHeights?.let { solve(it) }

    solve()


}

fun solve() {
    val pillarHeights = intArrayOf(1, 0, 2, 1, 0, 6, 2, 1, 0, 2)
//    val pillarHeights = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)


    if (pillarHeights.size == 1) {
        println(0)
    }

    val pillarsSortedByHeight: ArrayList<Pillar> = ArrayList()
    for (i in pillarHeights.indices) {
        pillarsSortedByHeight.add(Pillar(pillarHeights[i], i))
    }

    pillarsSortedByHeight.sortWith { o1, o2 -> o2.height.compareTo(o1.height) }

    var leftPillar = pillarsSortedByHeight[0]
    var rightPillar = pillarsSortedByHeight[0]
    var areaToFill = 0

    var j = 1

    while (j in 1 until pillarsSortedByHeight.size && (leftPillar.position != 0 || rightPillar.position != pillarHeights.size-1)) {
        val pillar= pillarsSortedByHeight[j++]
        when {
            pillar.position < leftPillar.position -> {
                // in left side
                areaToFill += pillar.height * (leftPillar.position - pillar.position -1)
                leftPillar = pillar;

            }
            pillar.position > rightPillar.position -> {
                // in right side
                areaToFill += pillar.height * (pillar.position - rightPillar.position -1)
                rightPillar = pillar;
            }
            else -> {
                // in range
                areaToFill -= pillar.height
            }
        }
    }

    var restOfSum = 0
    for (k in j until pillarHeights.size) {
        restOfSum += pillarsSortedByHeight[k].height
    }

    areaToFill -= restOfSum

    println(areaToFill)


}

data class Pillar(val height: Int, val position: Int)