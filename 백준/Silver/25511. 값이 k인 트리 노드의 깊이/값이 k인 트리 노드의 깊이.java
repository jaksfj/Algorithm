import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n,k;
    static int[] nodeValue;
    static boolean[] visited;
    static int[] depth;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        nodeValue = new int[n];
        visited = new boolean[n];
        depth = new int[n];
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            list[n1].add(n2);
            list[n2].add(n1);
        }
        for (int i = 0; i < n; i++) {
            nodeValue[i] = sc.nextInt();
        }
        bfs(0);
        for (int i = 0; i < n; i++) {
            if(nodeValue[i]==k){
                System.out.println(depth[i]);
                break;
            }
        }
    }

    static void bfs(int startNode){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(startNode);
        visited[startNode] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : list[cur]){
                if(!visited[next]){
                    queue.offer(next);
                    depth[next] = depth[cur]+1;
                    visited[next] = true;
                }
            }
        }
    }
}
