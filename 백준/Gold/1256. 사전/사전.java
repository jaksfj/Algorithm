import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // a개수
        int m = Integer.parseInt(st.nextToken()); // z개수
        long k = Long.parseLong(st.nextToken()); // k번째 문자열
        long[][] dp = new long[n+m+1][n+m+1]; // dp 배열
        // dp 배열 완성하기
        for(int i = 0;i<=n+m;i++){
            for(int j = 0;j<=i;j++){
                if(j==0 || i==j){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }

                if(dp[i][j]>1_000_000_000){
                    dp[i][j] = 1_000_000_000; // k의 범위로 인한 최댓값 설정
                }
            }
        }

        // dp 배열을 통한 k번째 문자열 찾기
        StringBuilder sb = new StringBuilder();
        if(dp[n+m][n]<k){ // 찾아야 하는 문자열의 개수가 k보다 작으면
            sb.append("-1");
        }else{
            while(n>0 || m>0){
                if(n>0 && dp[n+m-1][n-1]>=k){
                    n--;
                    sb.append("a");
                }else{
                    sb.append("z");
                    if(n>0) {
                        k -= dp[n + m - 1][n - 1];
                    }
                    m--;
                }
            }
        }
        System.out.println(sb);
    }
}
