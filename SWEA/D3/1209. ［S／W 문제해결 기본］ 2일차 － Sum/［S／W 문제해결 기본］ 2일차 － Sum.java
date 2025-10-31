import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 1) 가로 세로 탐색
            int max = 0;
            int upDiagonalSum = 0; // 오른쪽 위 대각선
            int downDiagonalSum = 0; // 오른쪽 아래 대각선
            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                int columnSum = 0;
                for (int j = 0; j < 100; j++) {
                    // 가로 세로 합 구하기
                    rowSum += arr[i][j];
                    columnSum += arr[j][i];
                }
                // 가로, 세로
                max = Math.max(max,columnSum);
                max = Math.max(max,rowSum);

                // 오른쪽 위,아래 대각선
                upDiagonalSum += arr[i][i];
                downDiagonalSum += arr[99-i][i];
            }
            max = Math.max(upDiagonalSum,max);
            max = Math.max(downDiagonalSum,max);

            System.out.println("#" + n + " " + max);
        }
    }
}