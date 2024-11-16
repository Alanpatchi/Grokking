package com.boobalan.leetcode.incomplete

class `Generate Parentheses` {


    fun generateParenthesis(n: Int): List<String> {
        val returnList = mutableListOf<String>()
        backTrack(n, StringBuffer(), 0, 0, n, n, returnList)
        return returnList
    }

    fun backTrack(n: Int, buffer: StringBuffer, openCount: Int, closeCount: Int, openLeft: Int, closeLeft: Int, returnList: MutableList<String>) {

        if (buffer.length == 2 * n) {
            if (openCount == closeCount) {
                returnList.add(buffer.toString())
            } else {
                return
            }
        } else {
            if (openCount < closeCount) {
                return
            } else {
                if (openLeft != 0) {
                    backTrack(n, buffer.append('('), openCount+1, closeCount, openLeft-1, closeLeft, returnList)
                    buffer.deleteCharAt(buffer.length -1)
                }
                if (closeLeft != 0) {
                    backTrack(n, buffer.append(')'), openCount, closeCount + 1, openLeft, closeLeft -1, returnList)
                    buffer.deleteCharAt(buffer.length -1)
                }
            }
        }

    }
}