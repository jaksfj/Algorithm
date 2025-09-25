import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int dump = sc.nextInt();
            int[] boxs = new int[100];
            for(int i = 0;i<100;i++){
            	boxs[i] = sc.nextInt();
            }
            // 최고점과 최하점을 더해주고 빼주기.
            for(int i = 0;i<dump;i++){
				Arrays.sort(boxs);
                boxs[0]++;
                boxs[99]--;
            }
            Arrays.sort(boxs);
            System.out.println("#" + test_case + " " + (boxs[99]-boxs[0]));
		}
	}
}