import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            char [][] arr = new char[8][8];
            int n = sc.nextInt();
            for(int i = 0;i<8;i++){
                String str = sc.next();
                for(int j = 0;j<8;j++){
                    arr[i][j] = str.charAt(j);
                }
            }

            int answer = 0; // 회문의 수
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    // 1칸씩 이동하면서 오 아래 순으로 확인하기
                    if(j+(n-1)<8){ // 오른쪽 확인 가능
                        int start = j;
                        int end = j+(n-1);
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
                            answer++;
                        }
                    }

                    if(i+(n-1)<8){ // 아래쪽 확인 가능
                        int start = i;
                        int end = i+(n-1);
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
                            answer++;
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}