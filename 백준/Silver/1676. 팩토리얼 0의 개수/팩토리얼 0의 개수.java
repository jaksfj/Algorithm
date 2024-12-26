import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 5; i <= n; i*=5) { // 5의 개수가 펙토리얼 끝의 0의 개수를 나타낸다.
            cnt += n/i;
        }
        System.out.println(cnt);
    }
}
