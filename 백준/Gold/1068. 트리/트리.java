import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer>[] tree = new ArrayList[n];
        boolean[] visited = new boolean[n];

        for(int i = 0;i<n;i++){
            tree[i] = new ArrayList<>();
        }

        int rootNode = 0;
        for(int i = 0;i<n;i++){
            int parentNode = Integer.parseInt(st.nextToken());
            if(parentNode==-1){
                rootNode = i; // 부모노드가 없는 노드가 루트노드가 된다.
            }else {
                tree[parentNode].add(i);
            }
        }

        int deleteNode = Integer.parseInt(br.readLine());
        dfs(tree,visited,deleteNode,rootNode);
        System.out.println(cnt);
    }

    private static void dfs(ArrayList<Integer>[] tree,boolean[] visited,int deleteNode,int node){
        if(visited[node] || node==deleteNode){
            return;
        }

        visited[node] = true;
        boolean isLeaf = true;

        for (int next : tree[node]) {
            if (next != deleteNode) {
                isLeaf = false;
                dfs(tree, visited, deleteNode, next);
            }
        }

        if(isLeaf){
            cnt++;
        }
    }
}