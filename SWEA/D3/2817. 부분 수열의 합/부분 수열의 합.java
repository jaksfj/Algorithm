import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int[] arr;
    static int answer,k,n;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            n = sc.nextInt(); // 숫자 개수
            k = sc.nextInt(); // 목표 수
            arr = new int[n];
            for(int i =0;i<n;i++){
            	arr[i] = sc.nextInt();
            }
            answer = 0;
            dfs(0,0);
            System.out.println("#" + test_case + " " + answer);
		}
	}
    
    static void dfs(int index, int sum){
        if(sum==k){ // 만약 합이 k와 같다면
        	answer++;
            return;
        }
        
        if(index==n) {
        	return;
        }
        dfs(index+1,sum+arr[index]);
        dfs(index+1,sum);
    }
}