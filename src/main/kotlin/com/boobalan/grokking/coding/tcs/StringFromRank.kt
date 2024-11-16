package com.boobalan.grokking.coding.tcs

fun main(args: Array<String>) {
    solve(8, 1)
    solve(29, 2)

}

fun solve(R: Int, N: Int) {

    var r = R;

    var baseCalculation = permute(N)


    for (n in N downTo  1) {
        var rLookup = 0

        if (n -1 == 0) {
            rLookup = r -1;
        } else {
            rLookup = r / baseCalculation
            r %= baseCalculation

        }

        // get char value of rLookup
        println(rLookup)

    }
}
// 25 P  N-1
private fun permute(N: Int): Int {
    var perm = 1;

    if (N - 1 != 0) {
        for (i in 1 until N) {
            perm *= (26 - i);
        }
    }
    return perm
}

