package com.boobalan.leetcode.incomplete

import kotlin.math.min

class `Zigzag Conversion` {

    fun convert(s: String, numRows: Int): String {

        val h = numRows - 1
        val stringBuilder: StringBuilder = StringBuilder()

        if (h == 1) {
            return s
        }

        for (startIndex in 0..min(h, s.length - 1)) {
            stringBuilder.append(s[startIndex])
            if(s.length == 1) {
                break
            }
            val oddGap = 2 * (h - startIndex)
            val evenGap = 2 * startIndex
            var nextIndex = startIndex + oddGap
            var isOddGap = false
            if (oddGap == 0) {
                nextIndex = startIndex + evenGap
                isOddGap = true
            }
            while (nextIndex <= s.length - 1) {
                stringBuilder.append(s[nextIndex])
                if (oddGap == 0 || evenGap == 0) {
                    isOddGap = !isOddGap
                }
                nextIndex += if (isOddGap) {
                    oddGap
                } else {
                    evenGap
                }
                isOddGap = !isOddGap
            }

        }



        return stringBuilder.toString()

    }
}