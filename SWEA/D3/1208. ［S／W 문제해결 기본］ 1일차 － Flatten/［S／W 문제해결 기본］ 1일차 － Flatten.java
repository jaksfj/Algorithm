import java.util.Scanner;
import java.io.FileInputStream;

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
            // 최고점과 최하점을 찾고 dump하기
            for(int i = 0;i<dump;i++){
                int max = 1;
            	int maxIndex = 0;
            	int min = 100;
            	int minIndex = 0;
            	for(int j = 0;j<100;j++){
                	if(max<boxs[j]){
                    	max = boxs[j];
                        maxIndex = j;
                    }
                    if(min>boxs[j] && boxs[j]!=0){
                    	min = boxs[j];
                        minIndex = j;
                    }
                }
                boxs[maxIndex] -= 1;
                boxs[minIndex] += 1;
            }
            int max = 1;
            int min = 100;
            for(int i = 0;i<100;i++){
            	if(max<boxs[i]){
                    	max = boxs[i];
                }
                if(min>boxs[i] && boxs[i]!=0){
                    min = boxs[i];
                }
            }
            System.out.println("#" + test_case + " " + (max-min));
		}
	}
}