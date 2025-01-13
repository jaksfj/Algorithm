import java.io.*;
import java.util.*;

public class Main {
    static boolean isCorrect = true; // 이분그래프 유무
    public static void main(String[] args) throws IOException { // 이분 그래프
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 노드 개수
            int e = Integer.parseInt(st.nextToken()); // 에지 개수
            ArrayList<Integer>[] list = new ArrayList[n+1];
            boolean[] visited = new boolean[n+1];
            int[] group = new int[n+1];
            // 인접 리스트 초기화
            for (int j = 1; j <= n; j++) {
                list[j] = new ArrayList<>();
                group[j] = -1; // 그룹 배열 초기화
            }
            // 그래프 저장
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                list[n1].add(n2);
                list[n2].add(n1);
            }

            isCorrect = true; // 다시 초기화
            // DFS 로 이분그래프 판별 (dfs 중 이미 방문했던 노드를 다시 방문하려는 경우에 이분그래프 충족 X)
            for (int j = 1; j <= n; j++) {
                if(isCorrect) {
                    dfs(list, visited, j, group);
                }else{
                    break;
                }
            }

            if(isCorrect){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static void dfs(ArrayList<Integer>[] list,boolean[] visited,int node,int[] group){
        if(visited[node]){
            return;
        }

        visited[node] = true;
        for(int next : list[node]){
            if(!visited[next]) {
                group[next] = group[node] * -1;
                dfs(list,visited,next,group);
            }else if(group[node] == group[next]){
                isCorrect = false; // 이분그래프 x 다.
                return;
            }
        }
    }
}
