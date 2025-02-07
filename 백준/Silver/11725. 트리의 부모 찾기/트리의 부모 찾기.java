import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n+1];
        StringTokenizer st;
        boolean[] visited = new boolean[n+1];
        int[] parents = new int[n+1]; // 부모노드를 찾기위한 배열
        for(int i = 1;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }

        dfs(list,parents,1, visited);

        for(int i = 2;i<=n;i++){
            System.out.println(parents[i]);
        }
    }

    private static void dfs(ArrayList<Integer>[] list,int[] parents,int node,boolean[] visited){
        if(visited[node]){
            return;
        }

        visited[node] = true;

        for(int next : list[node]){
            if(!visited[next]){
                parents[next] = node;
                dfs(list,parents,next,visited);
            }
        }
    }
}
