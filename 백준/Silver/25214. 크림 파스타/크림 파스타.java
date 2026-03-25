import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = 0;
		long[] dp = new long[n+1];
		int index = 1;
		while(st.hasMoreTokens()) {
			long num = Long.parseLong(st.nextToken());
			if(index==1) {
				bw.write(dp[index] + " ");
				dp[index] = 0;
				min = num;
				index++;
				continue;
			}
			if(num<min) { // 최소값 갱신
				min = num;
			}
			dp[index] = Math.max(dp[index-1], num-min);
			bw.write(dp[index] + " ");
			index++;
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
