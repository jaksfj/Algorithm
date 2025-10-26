import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int[][] arr = new int[n][n];
            sc.nextLine();
            for(int i = 0;i<n;i++){
                String str = sc.nextLine();
            	for(int j = 0;j<n;j++){
                	arr[i][j] = Integer.parseInt(str.substring(j,j+1));
                }
            }
            int mid = n/2; //  중앙 인덱스
            int answer = 0;
            int weight;
            for(int i = 0;i<n;i++){
                if(i==mid){
                   weight = mid;
                }else if(i<mid){
                    weight= i;
                }else{
                	weight = 2*mid-i;
                }
              	for(int j = mid-weight;j<=mid+weight;j++){
                    answer += arr[i][j];
                }
           }
           System.out.println("#" + test_case + " " + answer);
        }
	}
}