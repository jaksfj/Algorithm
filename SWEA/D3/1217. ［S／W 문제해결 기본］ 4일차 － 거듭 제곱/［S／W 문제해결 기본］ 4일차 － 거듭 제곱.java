import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n = sc.nextInt();
            int num = sc.nextInt();
            int pow = sc.nextInt();
            int cnt = 1;
            int answer = 1;
            while(cnt<=pow){
            	answer *= num;
                cnt++;
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
}