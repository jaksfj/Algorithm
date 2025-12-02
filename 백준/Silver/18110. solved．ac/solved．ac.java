
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // solved.ac
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i = 1;i<=n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int ex = (int)Math.round(n*0.15);
        long sum = 0;
        for(int i = ex+1;i<=n-ex;i++){
            sum += arr[i];
        }
        long answer = Math.round((float) sum/(n-(ex*2)));
        System.out.println(answer);
    }
}
