package com.boobalan.leetcode

import java.util.*

/**
 * https://leetcode.com/problems/simplify-path/?envType=study-plan-v2&envId=top-interview-150
 */
class `Simplify Path` {
    fun simplifyPath(path: String): String {
        val stackOfPath = LinkedList<String>()
        var index = 0
        while (index < path.length) {
            // move until next / or end of string
            while (index < path.length && path[index] == '/') {
                index++
            }

            var end = index
            while (end + 1 < path.length && path[end + 1] != '/') {
                end++
            }
            if (index in path.indices && end <= path.length) {
                nextDirectory(path.substring(index..end), stackOfPath)
            }

            index = end + 1
        }

        val returnPath = StringBuilder()
        while (stackOfPath.isNotEmpty()) {
            returnPath.append("/").append(stackOfPath.removeLast())
        }
        if (returnPath.isEmpty()) {
            returnPath.append("/")
        }
        return returnPath.toString()
    }

    private fun nextDirectory(directory: String, stackOfPath: LinkedList<String>) {
        when(directory) {
            ".." ->  {
                if (stackOfPath.isNotEmpty()) {
                    stackOfPath.pop()
                }
            }
            "." -> {

            }
            else -> stackOfPath.push(directory)
        }
    }

}