package com.boobalan.grokking.coding.sliding

fun main(args: Array<String>) {
    val s = "aabdec"
    val n = s.length
    val pk = "abc"
    val pm = HashMap<Char, Int?>()

    for (element: Char in pk) {
        pm[element] = (pm[element] ?: 0) +1
    }

    val l = pm.size

    var rb = 0
    var re = n


    var match =0

    var prevWb = 0
    for (j in 0 until n) {

        if (pm[s[j]] != null) {
            pm[s[j]] = pm[s[j]]!! -1
            if (pm[s[j]]!! == 0)
                match++
        }

        if (match == l) {

            // store match in result
            if (re - rb > j - prevWb) {
                rb = prevWb
                re = j
            }

            while (match == l) {
                if (pm[s[prevWb]] != null) {

                    pm[s[prevWb]] = pm[s[prevWb]]!! +1
                    if (pm[s[prevWb]]!! > 0) {
                        match --
                    }

                }
                prevWb++
                if (match == l) {

                    // store match in result
                    if (re - rb > j - prevWb) {
                        rb = prevWb
                        re = j
                    }
                }


            }
        }
    }

    // display output
    if (re < n)
        println("\" ${s.substring(rb, re+1)} \"")
    else {
        println("""  ""  """)
    }

}