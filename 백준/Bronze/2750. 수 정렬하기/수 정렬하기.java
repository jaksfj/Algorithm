import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수의 개수
        int[] numArr = new int[n];

        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (numArr[j] > numArr[j + 1]) {
                    int tmp = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(numArr[i]);
        }
    }
}
