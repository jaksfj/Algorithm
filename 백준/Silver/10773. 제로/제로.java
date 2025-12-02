import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        // 제로
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        ArrayDeque<Long> stack = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            long k = Long.parseLong(br.readLine());
            if(k==0){
                stack.pop();
            }else{
                stack.push(k);
            }
        }
        int answer = 0;
        for(long num : stack){
            answer += num;
        }
        System.out.println(answer);
    }
}
