import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            sc.nextLine();
            int[][] arr = new int[n][n]; // 101 x 101 배열 생성
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(sc.nextLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < 100; i++) { // 가로 행
                int current = 0;
                for (int j = 0; j < 100; j++) { // 세로 열
                    int next = arr[j][i];
                    if(current == 0 && next!=2){ // 내려오다가 2가 next면 그대로 올라가면됨
                        current = next;
                        continue;
                    }

                    if(current==1 && next==2){
                        answer++;
                        current = 0;
                    }
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}