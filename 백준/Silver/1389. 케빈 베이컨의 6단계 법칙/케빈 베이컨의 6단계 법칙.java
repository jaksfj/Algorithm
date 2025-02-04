import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 유저 수
        int m = Integer.parseInt(st.nextToken()); // 친구관계 수
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }

        int[] answer = new int[n+1];

        for(int i = 1;i<=n;i++) {
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[n+1];
            int[] depth = new int[n+1]; // 각 노드 깊이 저장 배열
            int sum = 0;

            queue.offer(i);
            visited[i] = true;

            while(!queue.isEmpty()){
                int node = queue.poll();
                for(int next : list[node]){
                    if(!visited[next]){
                        queue.offer(next);
                        visited[next] = true; // 한번 방문한 노드는 다시 큐에 넣을 수 없도록
                        depth[next] = depth[node] + 1;
                        sum += depth[next];
                    }
                }
            }
            answer[i] = sum;
        }

        int min = answer[1];
        int minIndex = 1;
        for(int i = 2;i<=n;i++){
            if(min>answer[i]){
                min = answer[i];
                minIndex = i;
            }
        }
        System.out.println(minIndex);
    }
}
