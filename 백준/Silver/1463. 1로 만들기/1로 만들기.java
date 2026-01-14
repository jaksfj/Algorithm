import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int min = dp[i-1]; // 1을 뺀 수가 완성되기까지의 횟수가 기준
            if(i%2==0){
                min = Math.min(dp[i/2],min); // 2로 나눠진 수가 완성되기까지의 횟수
            }
            if(i%3==0){
                min = Math.min(dp[i/3],min); // 3로 나눠진 수가 완성되기까지의 횟수
            }
            dp[i] = min+1; // 최소 한번의 연산은 더해야 i가 될수있음
        }
        System.out.println(dp[n]);
    }
}
