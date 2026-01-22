import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long[] dp = new long[n+2];
            dp[1] = 1;
            dp[2] = 1;
            if(n>2){
                for (int j = 3; j <= n; j++) {
                    dp[j] = dp[j-2] + dp[j-3];
                }
            }
            System.out.println(dp[n]);
        }
    }
}
