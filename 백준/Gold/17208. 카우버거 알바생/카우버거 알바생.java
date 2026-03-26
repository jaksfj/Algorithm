import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 치즈버거 최대
        int k = Integer.parseInt(st.nextToken()); // 감자튀김 최대
        int[] cheese = new int[n];
        int[] fry = new int[n];
        int[][] dp = new int[m+1][k+1];
        for(int i = 0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	int c = Integer.parseInt(st.nextToken());
        	int f = Integer.parseInt(st.nextToken());
        	cheese[i] = c;
        	fry[i] = f;
        }
        
        for(int s = 0; s < n; s++){
            int x = cheese[s];
            int y = fry[s];
            for(int i = m;i>=x;i--) {
            	for(int j = k;j>=y;j--) {
            		dp[i][j] = Math.max(dp[i][j], dp[i-x][j-y]+1);
            	}
            }
        }
        System.out.print(dp[m][k]);
    }
}