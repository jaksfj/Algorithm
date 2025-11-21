import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String bit = sc.nextLine();
			char prevBit = '0';
			int answer = 0; // 바뀌어야 되는 횟수
			for(int i = 0;i<bit.length();i++) {
				char startBit = bit.charAt(i);
				if(prevBit != startBit) {
					answer++;
				}
				prevBit = startBit;
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}