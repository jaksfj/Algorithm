import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayDeque;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int n = sc.nextInt();
            String s = sc.next();
            ArrayDeque<Character> dq = new ArrayDeque<>();
            for(int i = 0;i<n;i++){
            	char c = s.charAt(i);
                if(!dq.isEmpty() && dq.peekLast() == c){
                	dq.pollLast();
                }else{
                	dq.addLast(c);
                }
            }
            System.out.print("#" + test_case + " ");
            for(char c : dq){
            	System.out.print(c);
            }
            System.out.println();
		}
	}
}