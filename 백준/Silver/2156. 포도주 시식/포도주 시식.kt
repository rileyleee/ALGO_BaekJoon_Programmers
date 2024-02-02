import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()

    val arr = IntArray(n + 1)

    for (i in 1..n) {
        arr[i] = sc.nextInt()
    }

    val dp = IntArray(n + 1)

    var con = 0

    if (n == 1) {
        dp[1] = arr[1]
    }

    if (n == 2) {
        dp[1] = arr[1]
        dp[2] = dp[1] + arr[2]
    }

    if (n > 2) {

        dp[1] = arr[1]
        dp[2] = dp[1] + arr[2]

        if (arr[1] != 0) {
            con = 1
            if (arr[2] != 0) {
                con = 2
            }
        } else {
            if (arr[2] != 0) {
                con = 1
            }
        }

        for (i in 3..n) {

            con++
            //println("이번 i: $i")

            if (con == 3) {

                val op1 = dp[i - 1]

                val op2 = dp[i - 2] + arr[i]

                val op3 = dp[i - 3] + arr[i - 1] + arr[i]

                if (op1 >= op2 && op1 >= op3) {
                    con = 0
                    dp[i] = op1
                    //println("op1: $op1")
                }

                if (op2 > op1 && op2 >= op3) {
                    con = 1
                    dp[i] = op2
                    //println("op2: $op2")
                }

                if (op3 > op1 && op3 > op2) {
                    con = 2
                    dp[i] = op3
                    //println("op3: $op3")
                }

            } else {
                dp[i] = dp[i - 1] + arr[i]
            }
            //println("dp[$i]: ${dp[i]}")
        }
    }

    println(dp[n])
}