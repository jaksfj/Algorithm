
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static long[] dist;
    static long max;
    public static void main(String[] args) throws IOException {
        // 너구리 구구
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        dist = new long[n+1];
        for(int i = 1;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken()); // 가중치
            // 양방향
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        bfs(1);
        System.out.println(max);
    }

    static void bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(Node node : list[cur]){
                if(!visited[node.next]){
                    queue.add(node.next);
                    visited[node.next] = true;
                    dist[node.next] = dist[cur] + node.weight;
                    max = Math.max(dist[node.next],max);
                }
            }
        }
    }

    static class Node{
        int next;
        long weight;
        Node(int next,long weight){
            this.next = next;
            this.weight = weight;
        }
    }
}
