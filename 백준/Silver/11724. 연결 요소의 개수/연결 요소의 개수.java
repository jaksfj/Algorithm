import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list[node1].add(node2);
            list[node2].add(node1);
        }

        int cnt = 0; // 연결 요소의 개수
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                cnt++;
                dfs(list,visited,i);
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(ArrayList<Integer>[] list, boolean[] visited, int node) {
        if(visited[node]){
            return;
        }

        visited[node] = true;

        for(int num : list[node]){
            if(!visited[num]){
                dfs(list,visited,num);
            }
        }
    }
}