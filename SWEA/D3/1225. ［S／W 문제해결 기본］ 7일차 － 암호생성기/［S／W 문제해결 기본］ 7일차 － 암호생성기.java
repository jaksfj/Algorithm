import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            int w = 1;
            while(true){
                int out = queue.poll()-w;
                if(out<=0){
                    queue.offer(0);
                    break;
                }else{
                    queue.offer(out);
                }
                w++;
                if(w>=6){
                    w = 1;
                }
            }
            System.out.print("#" + n + " ");
            for(int num : queue){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}