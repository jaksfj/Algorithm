import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] bannedNums = new boolean[1002];
        if (m != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) { // 방문한 수 제거
                int num = Integer.parseInt(st.nextToken());
                bannedNums[num] = true;
            }
        }
        //for문 돌려가면서 1~1000 확인
        long min = Long.MAX_VALUE;
        for (int i = 1; i <= 1001; i++) {
            for (int j = 1; j <= 1001; j++) {
                for (int k = 1; k <= 1001; k++) {
                    if (!bannedNums[i] && !bannedNums[j] && !bannedNums[k]) {
                        long mux = n - (i * j * k);
                        if (min > Math.abs(mux)) {
                            min = Math.abs(mux);
                        }
                    }
                }
            }
        }
        System.out.println(min);                     // // 최종 답 출력
    }
}
