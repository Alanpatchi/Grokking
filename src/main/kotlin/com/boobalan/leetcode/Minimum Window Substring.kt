package com.boobalan.leetcode

class `Minimum Window Substring` {


    fun minWindow(s: String, t: String): String {
        val tCharSet = hashSetOf<Char>()
        val remainingBucketMap = hashMapOf<Char, Int>()
        val excessBucket = hashMapOf<Char, Int>()
        // prepare remaining bucket
        for (char: Char in t) {
            tCharSet.add(char)
            val charBucket = remainingBucketMap[char]
            if (charBucket == null) {
                remainingBucketMap[char] = 1
            } else {
                remainingBucketMap[char] = charBucket + 1
            }
        }


        if (t.length == 1) {
            return if (s.toHashSet().contains(t[0])) {
                t
            } else {
                ""
            }
        } else {
            var minimumContainingWindowLength = Int.MAX_VALUE
            var finalMinimumContainingWindowBegin: Int = 0
            var finalMinimumContainingWindowEnd: Int = -1
            var minimumContainingWindowBegin = 0
            var minimumContainingWindowEnd = -1


            fun includeTCharInWindow(char: Char) {
                val remainingCount = remainingBucketMap[char]
                if (remainingCount != null) {
                    if (remainingCount == 1) {
                        remainingBucketMap.remove(char)
                    } else {
                        remainingBucketMap[char] = remainingCount - 1
                    }
                } else {
                    val countInExcess = excessBucket[char]
                    if (countInExcess == null) {
                        excessBucket[char] = 1
                    } else {
                        excessBucket[char] = countInExcess + 1
                    }
                }
            }

            fun increaseRightWindowCursor(rightCursorPosition: Int) {
                if (tCharSet.contains(s[rightCursorPosition])) {
                    includeTCharInWindow(s[rightCursorPosition])
                }
            }


            fun deductTCharFromWindow(char: Char) {

                val countInExcess = excessBucket[char]
                if (countInExcess != null) {

                    if (countInExcess == 1) {
                        excessBucket.remove(char)
                    } else {
                        excessBucket[char] = countInExcess - 1
                    }

                } else {
                    val remainingCount = remainingBucketMap[char]
                    if (remainingCount == null) {
                        remainingBucketMap[char] = 1
                    } else {
                        remainingBucketMap[char] = remainingCount + 1
                    }
                }
            }

            fun decreaseLeftWindowCursor(leftCursorPosition: Int) {
                if (tCharSet.contains(s[leftCursorPosition])) {
                    deductTCharFromWindow(s[leftCursorPosition])
                }
            }

            // find valid begin cursor
            while (minimumContainingWindowBegin < s.length && !tCharSet.contains(s[minimumContainingWindowBegin])) {
                minimumContainingWindowBegin++
            }
            if (minimumContainingWindowBegin == s.length) {  // no letter in t found in s
                return ""
            }
            minimumContainingWindowEnd = minimumContainingWindowBegin
            increaseRightWindowCursor(minimumContainingWindowEnd)


            while (minimumContainingWindowBegin < s.length && minimumContainingWindowEnd < s.length) {

                // expand window until valid solution found
                while (minimumContainingWindowEnd < s.length) {
                    minimumContainingWindowEnd++
                    if (minimumContainingWindowEnd < s.length) {
                        increaseRightWindowCursor(minimumContainingWindowEnd)
                        if (remainingBucketMap.isEmpty()) {
                            val windowLength = minimumContainingWindowEnd - minimumContainingWindowBegin
                            if (windowLength < minimumContainingWindowLength) {
                                minimumContainingWindowLength = windowLength
                                finalMinimumContainingWindowBegin = minimumContainingWindowBegin
                                finalMinimumContainingWindowEnd = minimumContainingWindowEnd
                            }
                            break
                        }
                    }
                }

                // shrink window until invalid solution
                while (minimumContainingWindowEnd < s.length && minimumContainingWindowBegin <= minimumContainingWindowEnd) {
                    minimumContainingWindowBegin++
                    if (minimumContainingWindowBegin <= minimumContainingWindowEnd) {
                        decreaseLeftWindowCursor(minimumContainingWindowBegin - 1)
                        if (remainingBucketMap.isNotEmpty() && tCharSet.contains(s[minimumContainingWindowBegin])) {
                            break
                        } else if (remainingBucketMap.isEmpty()) {
                            val windowLength = minimumContainingWindowEnd - minimumContainingWindowBegin
                            if (windowLength < minimumContainingWindowLength) {
                                minimumContainingWindowLength = windowLength
                                finalMinimumContainingWindowBegin = minimumContainingWindowBegin
                                finalMinimumContainingWindowEnd = minimumContainingWindowEnd
                            }
                        }
                    }
                }
            }

            return if (minimumContainingWindowLength == Int.MAX_VALUE) {
                ""
            } else
                s.substring(finalMinimumContainingWindowBegin..finalMinimumContainingWindowEnd)
        }


    }
}