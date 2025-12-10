import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] colors;
    static ArrayList<Integer>[] tree;
    static int cnt;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드의 수
        StringTokenizer st = new StringTokenizer(br.readLine()); // 노드들의 색깔
        colors = new int[n+1];
        visited = new boolean[n+1];
        for (int i = 1;i<=n; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
        }
        if(colors[1]!=0){ // 시작노드의 색이 0이 아니라면 카운트해주기
            cnt++;
        }
        tree = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            tree[i] = new ArrayList<>();
        }
        // 간선정보 저장하기
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        dfs(1);
        System.out.println(cnt);
    }

    static void dfs(int node){
        if(visited[node]){
            return;
        }
        visited[node] = true;
        for(int n : tree[node]){
            if(!visited[n]) {
                if(colors[node]!=colors[n]){
                    cnt++;
                }
                dfs(n);
            }
        }
    }
}
