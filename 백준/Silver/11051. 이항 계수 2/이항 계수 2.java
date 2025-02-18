import java.io.*;
import java.util.*;

public class Main {
    static int MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1부터 시작
        int m = Integer.parseInt(st.nextToken());
        long[][] dp = new long[n+1][n+1];
        for(int i = 1;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(j==1){
                    dp[i][j] = i;
                }else if(j==0){
                    dp[i][j] = 1;
                }else if(i==j){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%MOD;
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
