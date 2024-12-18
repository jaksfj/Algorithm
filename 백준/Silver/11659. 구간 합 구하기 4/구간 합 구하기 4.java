import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
         int n,m;
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken()); // 숫자 배열의 크기
         m = Integer.parseInt(st.nextToken()); // 질의 개수
         int[] numArr = new int[n+1];
         st = new StringTokenizer(br.readLine());

         // 숫자 배열 생성
         for (int i = 1; i < n+1; i++) {
             numArr[i] = Integer.parseInt(st.nextToken());
         }

         int[] sumArr = new int[n+1];
         // 합 배열 생성
         for (int i = 1; i < n+1; i++) {
             sumArr[i] = sumArr[i-1] + numArr[i];
         }

         for (int k = 1; k < m+1; k++) {
             st = new StringTokenizer(br.readLine());
             int i = Integer.parseInt(st.nextToken()); // 시작점
             int j = Integer.parseInt(st.nextToken()); // 끝점
             System.out.println(sumArr[j] - sumArr[i-1]);
         }
    }
}
