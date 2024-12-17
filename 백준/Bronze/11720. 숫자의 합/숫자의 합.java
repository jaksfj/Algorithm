import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 숫자의 개수
        String line = br.readLine(); // 숫자들
        char[] numArr = line.toCharArray();
        int sum = 0; // 숫자들의 합
        for (int i = 0; i < numArr.length; i++) {
            sum += Integer.parseInt(String.valueOf(numArr[i]));
        }
        System.out.println(sum);
    }
}
