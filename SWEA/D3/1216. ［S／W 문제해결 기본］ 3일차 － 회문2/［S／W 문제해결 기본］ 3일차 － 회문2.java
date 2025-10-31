import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            sc.nextLine();
            char[][] arr = new char[100][100];
            for (int i = 0; i < 100; i++) {
                String str = sc.nextLine();
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            int max = 0; // 최대 회문의 길이
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    // 위치 설정
                    int size = 0;
                    // 오른쪽 탐색
                    while(j+size-1<100){
                        int start = j;
                        int end = j+size-1;
                        boolean isValid = true;
                        while(start<=end){
                            if(arr[i][start]!=arr[i][end]){
                                isValid = false;
                                break;
                            }
                            start++;
                            end--;
                        }
                        if(isValid){
                            max = Math.max(max,size);
                        }
                        size++;
                    }

                    size = 0;
                    // 아래로 탐색
                    while(i+size-1<100){
                        int start = i;
                        int end = i+size-1;
                        boolean isValid = true;
                        while(start<=end){
                            if(arr[start][j]!=arr[end][j]){
                                isValid = false;
                                break;
                            }
                            start++;
                            end--;
                        }
                        if(isValid){
                            max = Math.max(max,size);
                        }
                        size++;
                    }
                }
            }
            System.out.println("#" + n + " " + max);
        }
    }
}