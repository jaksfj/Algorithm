import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 토큰화해서 나누기
        int[] numArr = new int[n];
        int max = 0;
        // 배열에 값 받으면서 가장 큰 값 찾기
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            numArr[i] = num;
            if(max < num){
                max = num;
            }
        }

        // 조작한 점수의 평균 구하기
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (double)numArr[i] / max * 100;
        }
        System.out.println(sum/n);
    }
}
