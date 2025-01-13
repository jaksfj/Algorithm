import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { // 효율적인 해킹 (BFS)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 컴퓨터의 수
        int m = Integer.parseInt(st.nextToken()); // 연결 간선 수
        ArrayList<Integer>[] list = new ArrayList[n+1];
        int[] depth = new int[n+1]; // 각 노드의 깊이를 저장하는 배열
        boolean[] visited;

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2); // 방향그래프
        }

        for (int i = 1; i <= n; i++) {
            // 방문 배열 계속 초기화 해주기
            visited = new boolean[n+1];
            dfs(list,depth,i,visited);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max,depth[i]);
        }

        for (int i = 1; i <= n; i++) {
            if(max==depth[i]){
                bw.write(i + " ");
            }
        }
        bw.flush();
    }

    private static void dfs(ArrayList<Integer>[] list,int[] depth,int node,boolean[] visited){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            int next = queue.poll();
            for(int n : list[next]){
                if(!visited[n]) {
                    visited[n] = true;
                    depth[n]++;
                    queue.offer(n);
                }
            }
        }
    }
}