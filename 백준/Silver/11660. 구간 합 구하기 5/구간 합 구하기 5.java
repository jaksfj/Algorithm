import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 배열의 가로,세로 크기
        int m = Integer.parseInt(st.nextToken()); // 질의 개수
        int[][] sumArr = new int[n + 1][n + 1]; // 합배열
        // 합 배열 생성
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) { // 공식 : sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] + numArr[i][j] - sumArr[i-1][j-1]
                sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] + Integer.parseInt(st.nextToken()) - sumArr[i - 1][j - 1];
            }
        }

        // 범위 구하기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(sumArr[x2][y2] - sumArr[x2][y1 - 1] - sumArr[x1 - 1][y2] + sumArr[x1 - 1][y1 - 1]);
        }
    }
}
