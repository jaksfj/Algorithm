import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException { // 소수 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // m 이상 n 이하 중 소수 찾기
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i < n; i++) {
            if(arr[i]!=0){ // 지워지지 않은 수라면
                for (int j = i+i; j <= n; j+=i) { // 해당 수의 배수 다 제거
                    arr[j] = 0;
                }
            }
        }

        for (int i = m; i <= n; i++) {
            if(arr[i]!=0){
                System.out.println(arr[i]);
            }
        }
    }
}
