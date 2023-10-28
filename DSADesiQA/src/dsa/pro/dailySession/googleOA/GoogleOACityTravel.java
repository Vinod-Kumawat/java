package dsa.pro.dailySession.googleOA;

import java.util.Scanner;

/**
 * You work as a consultant and have clients in cityA and cityB. On a given day,
 * say i, you can either
 * work in cityA and make Ai dollars or you can work in cityB and make Bi dollars. You can also spend
 * the day traveling between cityA and cityB in which case your earnings that day are 0.
 *
 *
 *
 * Given Al,A2, ....An and B1, B2,....., Bn, return a schedule S of N days which maximizes your earnings,
 * You can start either in cityA or cityB.
 *
 * You need to print the final maximum earning
 *
 * Example1: A = [23, 4,5 ,101] B = [21,1,10, 100] The optimal schedule S here would be ->"ATBB"
 * Example 2:
 * A[25,10,15,10,70] B = [5,5,50,5,30] The optimal schedule S here would be-> "ATBTA"
 *
 * Follow up :-> solve the problem for 3 cities A,B,C
 *
 * All dollars are positive!
 */
public class GoogleOACityTravel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] a = new long[n + 1];
        long[] b = new long[n + 1];
        long[][] dp = new long[100005][2];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextLong();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextLong();
        }

        dp[1][0] = a[1];
        dp[1][1] = b[1];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + a[i], dp[i - 2][1] + a[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + b[i], dp[i - 2][0] + b[i]);
        }

        System.out.println(dp[n][0] + " " + dp[n][1]);
    }
}
