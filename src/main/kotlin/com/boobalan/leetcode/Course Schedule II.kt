package com.boobalan.leetcode

import java.util.LinkedList
import java.util.Queue

/**
 * https://leetcode.com/problems/course-schedule-ii/description/?envType=study-plan-v2&envId=top-interview-150
 * Pattern: Topological Sort (Graph)
 */
class `Course Schedule II` {


    /**
     * algo: Kahns' algo for topological sorting -> https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/?ref=lbp
     */
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {

        val inDegrees = IntArray(numCourses)
        val adjacencyList = HashMap<Int, MutableList<Int>>()
        for (prerequisite in prerequisites) {
            val to = prerequisite[0]
            val from = prerequisite[1]
            inDegrees[to]++
            if (adjacencyList[from] == null) {
                adjacencyList[from] = LinkedList<Int>()
            }
            adjacencyList[from]!!.add(to)

        }

        val queue: Queue<Int> = LinkedList()
        for (i in inDegrees.indices) {
            if (inDegrees[i] == 0) {
                queue.offer(i)
            }
        }

        val finalOrderArray = IntArray(numCourses)

        var visitedNodes = 0
        while(queue.isNotEmpty()) {

            val node = queue.poll()
            finalOrderArray[visitedNodes] = node
            visitedNodes++
            if(adjacencyList[node] == null) {
                continue
            } else {
                for(neighbour in adjacencyList[node]!!) {
                    inDegrees[neighbour]--
                    if (inDegrees[neighbour] == 0) {
                        queue.offer(neighbour)
                    }
                }
            }

        }

        return if (visitedNodes != numCourses) {
            intArrayOf()
        } else {
            finalOrderArray
        }
    }
}