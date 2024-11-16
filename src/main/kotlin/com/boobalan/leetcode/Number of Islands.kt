package com.boobalan.leetcode

import java.util.LinkedList

/**
 * https://leetcode.com/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-interview-150
 * Patten: Tree traversal using DFS or BFS
 */
class `Number of Islands` {


    fun numIslands(grid: Array<CharArray>): Int {
        //using dfs (bfs can also be used)

        var islandCount = 0
        val m = grid.size
        val n = grid[0].size
        var position = moveToNextIslandPosition(Pair(-1, 0), m, n, grid)
        val stack = LinkedList<Pair<Int, Int>>()
        while (position != null) {
            stack.push(position)
            while (stack.isNotEmpty()) {
                val stackTop = stack.pop()
                if (grid[stackTop.first][stackTop.second] != '0') { // if not visited
                    grid[stackTop.first][stackTop.second] = '0'  // visit
                    for (adjacentIsland in getAdjacentIslandNodes(stackTop, m, n, grid)) {
                        stack.push(adjacentIsland)
                    }
                }

            }
            position = moveToNextIslandPosition(position, m, n, grid)
            islandCount++
        }
        return islandCount


    }

    private fun getAdjacentIslandNodes(position: Pair<Int, Int>, m: Int, n: Int, grid: Array<CharArray>): List<Pair<Int, Int>> {
        val adjacentIslands = mutableListOf<Pair<Int, Int>>()
        if (position.first < m-1) {
            if (grid[position.first +1][position.second] == '1')
                adjacentIslands.add(Pair(position.first +1, position.second))
        }
        if (position.second < n-1) {
            if (grid[position.first][position.second +1] == '1')
                adjacentIslands.add(Pair(position.first, position.second +1))
        }
        if (position.second > 0) {
            if (grid[position.first][position.second -1] == '1')
                adjacentIslands.add(Pair(position.first, position.second -1))
        }
        if (position.first > 0) {
            if (grid[position.first -1][position.second] == '1')
                adjacentIslands.add(Pair(position.first -1, position.second))
        }
        return adjacentIslands
    }

    private fun moveToNextIslandPosition(position: Pair<Int, Int>, m: Int, n: Int, grid: Array<CharArray>): Pair<Int, Int>? {
        var nextPosition = moveToNextPosition(position, m, n)
        while (nextPosition != null && grid[nextPosition.first][nextPosition.second] == '0'){
            nextPosition = moveToNextPosition(nextPosition, m, n)
        }
        return nextPosition
    }

    private fun moveToNextPosition(position: Pair<Int, Int>, m: Int, n: Int): Pair<Int, Int>? {
        return if (position.first < m - 1) {
            Pair(position.first + 1, position.second)
        } else {
            if (position.second < n - 1) {
                Pair(0, position.second + 1)
            } else
                null
        }

    }
}

fun main(args: Array<String>) {
    `Number of Islands`().numIslands(arrayOf(charArrayOf('1','1','1','1','0'), charArrayOf('1','1','0','1','0'), charArrayOf('1','1','0','0','0'), charArrayOf('0','0','0','0','0')))
}