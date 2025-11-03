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
            System.out.println("#" + test_case + " " + power(num,pow));
		}
	}
    
    static int power(int num,int pow){
    	if(pow==0){
            return 1;
        }
        return num * power(num,pow-1);
    }
}