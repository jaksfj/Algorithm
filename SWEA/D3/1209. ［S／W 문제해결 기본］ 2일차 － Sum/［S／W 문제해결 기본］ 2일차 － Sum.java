import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 1) 가로 세로 탐색
            int max = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    // 가로
                    int sum = 0;
                    for (int k = 0; k < 100; k++) {
                        sum += arr[i][k];
                    }
                    if(max<sum){
                        max = sum;
                    }
                    // 세로
                    sum = 0;
                    for (int k = 0; k < 100; k++) {
                        sum += arr[k][j];
                    }
                    if(max<sum){
                        max = sum;
                    }
                }
            }

            // 2) 대각선 탐색
            // 오른쪽 아래 대각선
            int sum = 0;
            // i: 99~0, j: 0~100
            int i = 99;
            int j = 0;
            while(i>=0 && j<100){
                sum += arr[i][j];
                i--;
                j++;
            }
            if(max<sum){
                max = sum;
            }

            // 오른쪽 위 대각선
            sum = 0;
            // i: 0~100, j: 0~100
            i = 0;
            j = 0;
            while(i<100 && j<100){
                sum += arr[i][j];
                i++;
                j++;
            }
            if(max<sum){
                max = sum;
            }

            System.out.println("#" + n + " " + max);
        }
    }
}