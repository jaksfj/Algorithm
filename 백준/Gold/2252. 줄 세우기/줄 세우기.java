import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int m = Integer.parseInt(st.nextToken()); // 비교 횟수
        int[] weightArr = new int[n + 1]; // 진입차수 배열
        ArrayList<Integer>[] list = new ArrayList[n + 1]; // 인접리스트

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list[first].add(second); // 방향그래프
            weightArr[second]++; // 진입차수 증가
        }

        Queue<Integer> queue = new ArrayDeque<>();
        // 진입차수가 0인 노드들부터 탐색!
        for (int i = 1; i <= n; i++) {
            if(weightArr[i]==0){
                queue.add(i);
                bw.write(i + " ");
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : list[node]) {
                weightArr[next]--;
                if(weightArr[next]==0){
                    bw.write(next + " ");
                    queue.add(next);
                }
            }
        }

        bw.flush();
    }
}
