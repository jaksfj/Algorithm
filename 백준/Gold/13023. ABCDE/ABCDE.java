import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean isExist = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 친구 관계의 수
        ArrayList<Integer>[] list = new ArrayList[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list[node1].add(node2);
            list[node2].add(node1); // 양방향 그래프이므로
        }

        for (int i = 0; i < n; i++) {
            dfs(list,visited,i,1); // 초기 깊이 1
            if(isExist){
                break;
            }
        }

        System.out.println(isExist ? 1 : 0);
    }

    static void dfs(ArrayList<Integer>[] list,boolean[] visited, int node, int depth){
        if(visited[node]){
            return;
        }

        if(isExist || depth==5){
            isExist = true;
            return;
        }

        visited[node] = true;

        for(int next : list[node]){
            if(!visited[next]){
                dfs(list,visited,next,depth+1);
            }
        }

        visited[node] = false; // 백트래킹으로 방문했던 노드 초기화
    }
}