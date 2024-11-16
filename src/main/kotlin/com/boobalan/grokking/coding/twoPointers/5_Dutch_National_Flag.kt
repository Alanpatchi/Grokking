package com.boobalan.grokking.coding.twoPointers


fun main(args: Array<String>) {
    var arr = intArrayOf(1, 0, 2, 1, 0)
    `5_Dutch_National_Flag`().sort(arr)
    for (num in arr) print("$num ")
    println()
    arr = intArrayOf(2, 2, 0, 1, 2, 0)
    `5_Dutch_National_Flag`().sort(arr)
    for (num in arr) print("$num ")
}


class `5_Dutch_National_Flag` {



    fun sort(arr: IntArray) {


        var lp = 0
        var rp = arr.size -1

        val checkArray = intArrayOf(0, 2)

        for(i in arr.indices) {
            while (!inRange(i, lp, rp, arr) && arr[i] != 1) {

                if (arr[i] == 0) {
                    swap(arr, i, lp)
                    lp++

                } else if (arr[i]  == 2) {
                    swap(arr, i, rp)
                    rp--
                }
            }

        }


    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val buffer = arr[i]
        arr[i] = arr[j]
        arr[j] = buffer
    }

    private fun inRange(i: Int, lp: Int, rp: Int, arr: IntArray): Boolean {

        return when {
            arr[i] == 0 -> {
                i < lp;
            }
            arr[i] == 1 -> {
                i in (lp + 1)..rp
            }
            arr[i] == 2 -> {
                i > rp;
            }
            else -> false
        }
    }

}