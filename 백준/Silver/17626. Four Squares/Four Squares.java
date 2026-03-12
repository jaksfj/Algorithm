import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 최악의 경우 1^2 를 i번 사용 (ex : 5 -> 1의 제곱 5번 더하기)
            for (int j = 1; j * j<=i; j++) { // dp[i] : i 를 만들 수 있는 최소 제곱수의 개수
                dp[i] = Math.min(dp[i],dp[i-j*j]+1); // [i - 제곱수]르 ㄹ만드는 최소 개수 + 제곱수 하나
            }
        }
        System.out.println(dp[n]);
    }
}
