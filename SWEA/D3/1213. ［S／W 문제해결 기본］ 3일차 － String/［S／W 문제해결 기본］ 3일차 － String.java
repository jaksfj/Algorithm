import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int answer = 0;
            int n = sc.nextInt();
            sc.nextLine();
            String object = sc.nextLine();
            String str = sc.nextLine();
            for (int i = 0; i <= str.length()-object.length(); i++) {
                if(object.equals(str.substring(i,i+object.length()))){
                    answer++;
                }
            }
            System.out.println("#" + n + " " + answer);
        }
    }
}