import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        int treeSize = 1;
        boolean[] visited = new boolean[n+1];
        int[] depths = new int[n+1];
        // 트리 높이(k)의 최대값 설정 : n(노드의 개수) >= 2^k
        int k = 0; // 트리의 깊이
        for(int i = 1;i<=n;i*=2){
            k++;
        }
        int[][] parent = new int[k][n+1]; // 부모노드 배열

        ArrayList<Integer>[] tree = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            tree[i] = new ArrayList<>();
        }

        // 트리 저장
        for(int i = 0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree[start].add(end);
            tree[end].add(start);
        }

        // 트리 배열 완성하기
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1); // 시작 노드 삽입
        int cnt = 0; // 같은 깊이의 노드 수
        int queueSize = 1; // 처음엔 시작 노드만 존재
        int depth = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            for(int next : tree[node]){
                if(!visited[next]){
                    visited[next] = true;
                    parent[0][next] = node; // 부모노드값 저장
                    queue.offer(next);
                    depths[next] = depth;
                }
            }
            cnt++;
            if(cnt==queueSize){ // 큐에 있는 모든 노드 (같은 깊이의 노드들 수행완료 시) 다 끝났을 때
                cnt = 0;
                queueSize = queue.size();
                depth++;
            }
        }
        // 각 노드의 2의 k승 번째 부모를 저장하기
        for(int i = 1;i<k;i++){
            for(int j=1;j<=n;j++){
                parent[i][j] = parent[i-1][parent[i-1][j]]; // 점화식 사용
            }
        }

        int m = Integer.parseInt(br.readLine()); // 쌍의 개수
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if(depths[first]>depths[second]){ // 앞의 노드의 깊이가 더 클 경우
                int tmp = first;
                first = second;
                second = tmp;
            }

            // 두 노드간의 깊이 맞추기
            for(int j = k-1;j>=0;j--){
                if(Math.pow(2,j)<=depths[second] - depths[first]){ // 점프가능한 깊이 차이가 있는지 확인
                    if(depths[first]<=depths[parent[j][second]]){ // second 의 부모가 더 깊은경우 이동
                        // (first 보다 위로 안가기 위해서)
                        second = parent[j][second];
                    }
                }
            }

            for(int j=k-1;j>=0;j--){
                if(parent[j][first]!=parent[j][second]){
                    first = parent[j][first];
                    second = parent[j][second];
                }
            }

            if(first!=second){
                bw.write(parent[0][first] + "\n");
            }else{
                bw.write(first + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
