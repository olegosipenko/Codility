package com.github.olegosipenko.training.codility

private const val IN_1 = 9
private const val OUT_1 = 2
private const val IN_2 = 529
private const val OUT_2 = 4
private const val IN_3 = 20
private const val OUT_3 = 1
private const val IN_4 = 15
private const val OUT_4 = 0
private const val IN_5 = 32
private const val OUT_5 = 0
private const val IN_6 = 1041
private const val OUT_6 = 5
private const val IN_7 = 6
private const val OUT_7 = 0
private const val IN_8 = 328
private const val OUT_8 = 2
private const val IN_9 = 1162
private const val OUT_9 = 3
private const val IN_10 = 51712
private const val OUT_10 = 2
private const val IN_11 = 66561
private const val OUT_11 = 9

fun main() {
    println(solution(IN_1) == OUT_1)
    println(solution(IN_2) == OUT_2)
    println(solution(IN_3) == OUT_3)
    println(solution(IN_4) == OUT_4)
    println(solution(IN_5) == OUT_5)
    println(solution(IN_6) == OUT_6)
    println(solution(IN_7) == OUT_7)
    println(solution(IN_8) == OUT_8)
    println(solution(IN_9) == OUT_9)
    println(solution(IN_10) == OUT_10)
    println(solution(IN_11) == OUT_11)
}

fun solution(N: Int): Int {
    if (N <= 1) return 0

    val binary = Integer.toBinaryString(N)

    var gapLen = 0
    var isOpen = false
    var tempLen = 0

    for (i in 0 until binary.length) {
        val char = binary[i]

        if (char == '1') {
            if (tempLen > gapLen) {
                gapLen = tempLen
            }
            isOpen = true
            tempLen = 0
        } else {
            if (isOpen) {
                tempLen++
            }
        }
    }

    return gapLen
}
