import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] depths;
    static boolean[] visited;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 노드의 수
        visited = new boolean[n+1]; // 방문 배열
        depths = new int[n+1]; // 깊이 저장배열
        parents = new int[n+1]; // 부모 저장배열
        StringTokenizer st;
        tree = new ArrayList[n+1]; // 트리
        for(int i = 1;i<=n;i++){
            tree[i] = new ArrayList<>();
        }

        // 트리 데이터 저장
        for(int i = 0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree[start].add(end);
            tree[end].add(start);
        }

        // 각 노드의 깊이와 부모를 저장하기
        bfs(1);

        int m = Integer.parseInt(br.readLine()); // 쌍의 수
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            bw.write(getLCA(first,second) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int startNode){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(startNode); // 시작 노드
        int cnt = 0; // 같은 깊이의 노드들의 탐색 수 저장
        int queueSize = 1; // 처음 시작노드만 담겨있으므로
        int depth = 1;
        while(!queue.isEmpty()){
            int node = queue.poll();
            visited[node] = true;
            for(int next : tree[node]){
                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                    parents[next] = node; // 부모 저장
                    depths[next] = depth; // 깊이 저장
                }
            }
            cnt++;
            if (cnt == queueSize) { // 같은 깊이의 노드들이 모두 탐색을 끝냈을 경우
                depth++;
                cnt = 0;
                queueSize = queue.size(); // 현재 큐의 사이즈로 초기화
            }
        }
    }

    private static int getLCA(int first,int second){
        if(depths[first]>depths[second]){ // 만약 첫번째 노드의 깊이가 두번째 노드의 깊이보다 클 때
            int tmp = first;
            first = second;
            second = tmp;
        }
        // second 가 first 의 깊이에 맞추기
        while(depths[first]!=depths[second]){
            second = parents[second];
        }
        // 한 부모씩 올라가면서 비교하기
        while(first != second){
            first = parents[first];
            second = parents[second];
        }

        return first;
    }
}
