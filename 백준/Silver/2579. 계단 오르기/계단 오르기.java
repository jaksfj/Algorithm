import java.util.Scanner;

public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] dp = new int[n+1];
        int[] stairs = new int[n+1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
        }
        dp[1] = stairs[1];
        if (n >= 2) {
            dp[2] = stairs[1] + stairs[2];
            for (int i = 3; i <= n; i++) { // dp[i-1] 은 반드시 3연속이 될 수 있으므로 사용불가!
                dp[i] = Math.max((dp[i-2] + stairs[i]), (dp[i-3]+stairs[i-1]+stairs[i]));
            }
        }
        System.out.println(dp[n]);
    }
}
