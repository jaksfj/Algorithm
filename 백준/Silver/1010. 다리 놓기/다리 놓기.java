import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        long[][] dp = new long[31][31];
        for(int i = 0;i<tc;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            for(int j = 1;j<=30;j++){
                for(int k = 0;k<=30;k++){
                    if(k==0){
                        dp[j][k]=1;
                    }else if(j==k){
                        dp[j][k]=1;
                    }else if(k==1){
                        dp[j][k] = j;
                    }else{
                        dp[j][k] = dp[j-1][k-1] + dp[j-1][k];
                    }
                }
            }
            bw.write(dp[m][n] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
