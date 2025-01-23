import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 건물의 개수
        int[] weight = new int[n+1];
        int[] time = new int[n+1]; // 각 건물이 건설되는데 걸리는 시간
        int[] answer = new int[n+1]; // 정답 배열
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            answer[i] = time[i];
            while(true){
                int next = Integer.parseInt(st.nextToken());
                if(next==-1){
                    break;
                }
                list[next].add(i); // 이전에 건설되어야 하는 건물 리스트에 저장
                weight[i]++; // 진입차수 증가
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if(weight[i]==0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int next : list[node]){
                answer[next] = Math.max(answer[next],answer[node]+time[next]);
                weight[next]--; // 진입차수 감소
                if(weight[next]==0){
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }
}