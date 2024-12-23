package com.boobalan.leetcode.incomplete

import java.util.LinkedList

/**
 * https://leetcode.com/problems/evaluate-division/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * path travesral in graph between 2 nodes from both sides with bfs
 * Pg:109 Cracking the coding interview
 */
class `Evaluate Division` {


    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {

        val adjacencyGraph = hashMapOf<String, HashMap<String, Double>>()

        for (equationIndex in equations.indices) {
            val equation = equations[equationIndex]
            val value = values[equationIndex]

            if (adjacencyGraph[equation[0]] == null) {
                adjacencyGraph[equation[0]] = HashMap()
            }
            adjacencyGraph[equation[0]]!![equation[1]] = value

            if (adjacencyGraph[equation[1]] == null) {
                adjacencyGraph[equation[1]] = HashMap()
            }
            adjacencyGraph[equation[1]]!![equation[0]] = 1 / value
         }

        // bfs from both ends of query entries
        val returnArray = DoubleArray(queries.size)
        for (i in queries.indices) {

            val source = queries[i][0]
            val dest = queries[i][1]

            val reachableFromSource = hashMapOf<String, Double>() // also use as markedArray
            val reachableFromDest = hashMapOf<String, Double>() // also use as markedArray


            val bfsQueueForSource = LinkedList<String>()
            val bfsQueueForDest = LinkedList<String>()

            if (adjacencyGraph[source] == null || adjacencyGraph[dest] == null) {
                returnArray[i] = -1.0
            } else {
                bfsQueueForSource.push(source)
                reachableFromSource[source] = 1.0

                bfsQueueForDest.push(dest)
                reachableFromDest[dest] = 1.0

                var returnValue = -1.0
                while (bfsQueueForDest.isNotEmpty() || bfsQueueForSource.isNotEmpty()) {

                    if (bfsQueueForSource.isNotEmpty()) {
                        val node = bfsQueueForSource.poll()
                        // visit
                        if (reachableFromDest[node] != null) {
                            returnValue = reachableFromSource[node]!! / reachableFromDest[node]!!
                            break
                        }

                        if (adjacencyGraph[node] != null) {
                            for (entry in adjacencyGraph[node]!!.entries) {
                                if (reachableFromSource[entry.key] == null) {
                                    reachableFromSource[entry.key] = adjacencyGraph[node]!![entry.key]!! * reachableFromSource[node]!!
                                    bfsQueueForSource.push(entry.key)
                                }
                            }
                        }


                    }

                    if (bfsQueueForDest.isNotEmpty()) {
                        val node = bfsQueueForDest.poll()
                        // visit
                        if (reachableFromSource[node] != null) {
                            returnValue = reachableFromSource[node]!! /  reachableFromDest[node]!!
                            break
                        }

                        if (adjacencyGraph[node] != null) {
                            for (entry in adjacencyGraph[node]!!.entries) {
                                if (reachableFromDest[entry.key] == null) {
                                    reachableFromDest[entry.key] = adjacencyGraph[node]!![entry.key]!! * reachableFromDest[node]!!
                                    bfsQueueForDest.push(entry.key)
                                }
                            }
                        }

                    }

                }
                returnArray[i] = returnValue
            }



        }

        return returnArray


    }
}