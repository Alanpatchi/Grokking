package com.boobalan.leetcode

/**
 * https://leetcode.com/problems/longest-common-prefix/solutions/3273176/python3-c-java-19-ms-beats-99-91/?envType=study-plan-v2&envId=top-interview-150
 *
 */
class `Longest Common Prefix` {

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        } else {
            // initialization
            val prefix: CharArray = strs[0].toCharArray()
            var prefixLastMatchingIndex = prefix.lastIndex
            for (str in strs) {
                var i = -1 // initialization
                while (i < prefixLastMatchingIndex && i < str.lastIndex) {
                    if (str[i+1] == prefix[i+1] ) {
                        i++
                    } else
                        break
                }
                prefixLastMatchingIndex = i

            }

            return if (prefixLastMatchingIndex == -1) {
                ""
            } else {
                String(prefix, 0, prefixLastMatchingIndex + 1)
            }
        }
    }
}