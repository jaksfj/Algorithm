

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{ // 체스판 다시 칠하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] chess = new char[n][m];
        for (int i = 0; i < n; i++) {
            chess[i] = br.readLine().toCharArray();
        }
        int result = getMin(chess,n,m);
        System.out.println(result);
    }

    static int getMin(char[][] chess, int n, int m) {
        int minCnt = Integer.MAX_VALUE;
        for (int i = 0; i <= n-8; i++) {
            for (int j = 0; j <= m-8; j++) {
                int wrongBlackCnt = 0;
                int wrongWhiteCnt = 0;
                for (int k = i; k < i+8; k++) {
                    for (int l = j; l < j+8; l++) {
                        char expectedBlack = ((k+l)%2==0) ? 'B' : 'W'; // 검은색이 시작 칸일 경우
                        char expectedWhite = ((k+l)%2==0) ? 'W' : 'B'; // 흰색칸이 시작 칸일 경우
                        // 매 줄 마다 바꿔야 되는 검은색과 하얀색 칸을 더하기
                        if(expectedBlack != chess[k][l]) {
                            wrongBlackCnt++;
                        }
                        if(expectedWhite != chess[k][l]) {
                            wrongWhiteCnt++;
                        }
                    }
                }
                minCnt = Math.min(minCnt,Math.min(wrongBlackCnt,wrongWhiteCnt));
            }
        }
        return minCnt;
    }
}