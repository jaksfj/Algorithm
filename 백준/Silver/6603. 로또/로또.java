import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] answer;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n==0){
                break;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            answer = new int[6];
            getLotto(arr,0,0);
            System.out.println();
        }
    }

    static void getLotto(int[] arr,int depth,int start){ // dfs 형식
        if(depth==6){
            for(int num : answer){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            answer[depth] = arr[i];
            getLotto(arr,depth+1,i+1);
        }
    }
}
