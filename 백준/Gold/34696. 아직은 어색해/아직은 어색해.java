import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int m = Integer.parseInt(st.nextToken()); // 자리 수
        long[] x = new long[m+1];
        long[] y = new long[m+1];
        long[] dist = new long[m+1]; // 가장 가까운 학생과의 거리
        boolean[] used = new boolean[m+1];
        int[] answer = new int[n+1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        int startSeat = Integer.parseInt(br.readLine());
        used[startSeat] = true;
        answer[1] = startSeat;

        // 첫번쨰 자리와의 각 자리들과의 거리 갱신
        for (int i = 1; i <= m; i++) {
            if (!used[i]) {
                long dx = x[i] - x[startSeat];
                long dy = y[i] - y[startSeat];
                dist[i] = dx*dx + dy*dy;
            }
        }

        for (int s = 2; s <= n; s++) { // 학생수 만큼
            int bestSeat = -1; // 최적의 자리
            long bestDist = -1; // 최적의 거리

            // 가장 dist가 큰 자리 선택
            for (int i = 1; i <= m; i++) {
                if (!used[i]) { // 아직 앉지 않은 자리만 탐색
                    if (dist[i] > bestDist || (dist[i] == bestDist && i < bestSeat)) { // 가장 먼 거리 찾기
                        bestDist = dist[i];
                        bestSeat = i;
                    }
                }
            }
            used[bestSeat] = true;
            answer[s] = bestSeat;
            // dist 갱신
            for (int i = 1; i <= m; i++) {
                if (!used[i]) {
                    long dx = x[i] - x[bestSeat];
                    long dy = y[i] - y[bestSeat];
                    long d = dx*dx + dy*dy;
                    dist[i] = Math.min(dist[i], d); // 가장 최적의 거리로 갱신하게 됨 (이전의 자리와 현재의 자리 중 가까운 거리로 갱신)
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }
}
