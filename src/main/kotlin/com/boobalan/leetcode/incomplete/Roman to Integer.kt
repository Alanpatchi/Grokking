package com.boobalan.leetcode.incomplete

class `Roman to Integer` {


    fun romanToInt(s: String): Int {
        val romanCharToIntMap = mapOf<Char, Int>(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000,
        )

        var returnInt = 0
        var i = 0
        while (i < s.length) {
            val nextIndex = i + 1

            when (s[i]) {
                'I' -> {
                    if (nextIndex < s.length) {
                        if (s[nextIndex] == 'V') {
                            returnInt += 4
                            i+=2
                        } else if (s[nextIndex] == 'X') {
                            returnInt += 9
                            i+=2
                        } else {
                            returnInt += 1
                            i++
                        }
                    } else {
                        returnInt += 1
                        i++
                    }

                }

                'X' -> {
                    if (nextIndex < s.length) {
                        if (s[nextIndex] == 'L') {
                            returnInt += 40
                            i +=2
                        } else if (s[nextIndex] == 'C') {
                            returnInt += 90
                            i +=2
                        } else {
                            returnInt += 10
                            i ++
                        }
                    } else {
                        returnInt += 10
                        i++
                    }

                }

                'C' -> {
                    if (nextIndex < s.length) {
                        if (s[nextIndex] == 'D') {
                            returnInt += 400
                            i +=2
                        } else if (s[nextIndex] == 'M') {
                            returnInt += 900
                            i +=2
                        } else {
                            returnInt += 100
                            i ++
                        }
                    } else {
                        returnInt += 100
                        i++
                    }
                }

                else -> {
                    returnInt += romanCharToIntMap[s[i]]!!
                    i++
                }
            }
        }
        return returnInt
    }
}