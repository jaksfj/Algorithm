import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) {
        // 바이러스
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] list = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            list[first].add(second);
            list[second].add(first);
        }
        dfs(list,1);
        System.out.println(cnt);
    }

    static void dfs(ArrayList<Integer>[] list, int num){
        if(visited[num]){
           return;
        }
        visited[num] = true;
        for(int next : list[num]){
            if(!visited[next]) {
                cnt++;
                dfs(list, next);
            }
        }
    }
}
