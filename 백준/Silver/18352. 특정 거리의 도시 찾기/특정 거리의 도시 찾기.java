import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { // 특정 거리의 도시 찾기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드의 개수
        int m = Integer.parseInt(st.nextToken()); // 에지 개수
        int k = Integer.parseInt(st.nextToken()); // 이동 거리
        int x = Integer.parseInt(st.nextToken()); // 출발 노드
        int[] visited = new  int[n+1];
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            visited[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list[node1].add(node2); // 방향 그래프
        }

        bfs(list,visited,x);

        boolean isExist = false;
        for (int i = 1; i <= n; i++) {
            if(visited[i]==k){
                System.out.println(i);
                isExist = true;
            }
        }
        if(!isExist){
            System.out.println(-1);
        }
    }

    private static void bfs(ArrayList<Integer>[] list, int[] visited, int x){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(x);
        visited[x] = 0; // 시작 노드의 거리

        while(!queue.isEmpty()){
            int next = queue.poll();
            for(int node : list[next]){
                if(visited[node] == -1) {
                    queue.offer(node);
                    visited[node] = visited[next] + 1;
                }
            }
        }
    }
}
