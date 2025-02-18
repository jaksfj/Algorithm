import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine()); // 돌의 색상 종류
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] stones = new int[m];
        int n = 0; // 돌의 총 개수
        for(int i = 0;i<m;i++){
            stones[i] = Integer.parseInt(st.nextToken());
            n += stones[i];
        }
        double[][] dp = new double[n+1][n+1];
        for(int i =1;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(j==0){
                    dp[i][j]=1;
                }else if(j==1){
                    dp[i][j] = i;
                }else if(i==j){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
            }
        }
        int k = Integer.parseInt(br.readLine()); // 꺼내야 하는 돌의 수
        double sum = 0;
        for(int i = 0;i<m;i++){
            sum += dp[stones[i]][k];
        }
        System.out.println(sum/dp[n][k]);
    }
}
