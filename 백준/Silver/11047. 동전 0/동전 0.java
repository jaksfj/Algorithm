import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException { // 동전 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전의 수
        int k = Integer.parseInt(st.nextToken()); // 가치의 합 (동전으로 만들려는 목표 수)
        int[] coins = new int[n];
        // 동전 가치 저장
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for (int i = n-1; i >= 0; i--) {
            if(k/coins[i]!=0){
                sum += k/coins[i];
            }
            k %= coins[i]; // 나머지로 저장 (앞자리 수 제거)
        }

        System.out.println(sum);
    }
}