import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int n, cnt;
    static int[] chess;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
            cnt = 0;
            // 체스판에 여왕의 위치를 모두 -1 로 초기화
            chess = new int[n];
            for(int i = 0;i<n;i++){
            	chess[i] = -1; 
            }
            dfs(0);
            System.out.println("#" + test_case + " " + cnt);
		}
	}
    
    static void dfs(int index){
    	// 먼저 체스판의 끝열에 도달했는지 확인
        if(index==n){
            cnt++;
        	return;
        }
        
        boolean isValid;
        // 열에서 0번행부터 n번 행까지 조건 검사
        // 1. 왼쪽끝까지 값이 없는지?
        // 2. 왼쪽위, 아래 대각선으로 값이 없는지?
     	for(int row = 0;row<n;row++){ // 0번 행 ~ n-1번 행
            isValid = true;
            int move = 1;
            for(int col = index-1; col>=0; col--){ // index-1번 열 ~ 0번 열까지 값이 있는지 확인
        		if(chess[col]==row || chess[col]==row-move || chess[col]==row+move){ 
            		isValid = false;
                	break;
            	}
                move++;
          	}
            if(isValid){
                chess[index] = row;
            	dfs(index+1);
                chess[index] = -1; // 백트래킹으로 체스판 다시 초기화
            }
        }
    }
}