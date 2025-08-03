

import java.io.*;
import java.util.StringTokenizer;

public class Main { // 구간 합 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 합배열 만들기
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = arr[i - 1] + sum[i - 1];
        }
        // 구간합 구하기
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            bw.write(sum[j]-sum[i-1]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
