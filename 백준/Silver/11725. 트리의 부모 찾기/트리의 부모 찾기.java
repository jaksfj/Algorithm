import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            list[n1].add(n2);
            list[n2].add(n1);
        }
        bfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    static void bfs(int startNode){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(startNode);
        visited[startNode] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            visited[cur]=true;
            for(int next : list[cur]){
                if(!visited[next]){
                    queue.offer(next);
                    parent[next] = cur;
                }
            }
        }
    }
}
