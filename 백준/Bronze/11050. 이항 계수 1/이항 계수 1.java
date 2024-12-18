import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 이항계수 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int numerator = 1; // 분자
        int denominator = 1; // 분모
        while(k>0){
            numerator *= n;
            denominator *= k;
            n--;
            k--;
        }
        System.out.println(numerator/denominator);
    }
}
