
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int answer;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            // 양방향 그래프
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        depth = new int[n+1];
        visited = new boolean[n+1];
        bfs(1);
        // 정점 노드까지의 거리가 홀수이면 성원이가 승
        if(answer%2!=0){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    static void bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[start] = true;
        depth[start] = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            boolean hasChild = false; // 자식 노드가 있는지 판별 -> 잎노드인지?
            for(int next : tree[cur]){
                if(!visited[next]){
                    hasChild = true;
                    queue.offer(next);
                    visited[next] = true;
                    depth[next] = depth[cur]+1; // 깊이 저장
                }
            }
            if(!hasChild){
                answer += depth[cur];
            }
        }
    }
}