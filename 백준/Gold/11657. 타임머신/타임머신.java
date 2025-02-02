import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] arge) throws IOException { // 타임머신 (벨만포드 사용) : 음수사이클 탐지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시 수
        int m = Integer.parseInt(st.nextToken()); // 버스 노선 수 (에지)
        Edge[] edges = new Edge[m+1]; // 에지배열
        long[] dist = new long[n+1]; // 최단거리 배열

        // 최단거리배열 초기화
        for(int i = 1;i<=n;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        // 에지 정보 저장
        for(int i = 1;i<=m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start,end,weight);
        }

        dist[1] = 0; // 시작노드는 1

        // 최단경로 구하기
        for(int i = 1; i<n; i++){ // 최단경로는 무조건 노드 수 - 1개 밖에 나올 수 없음.
            // 매 반복마다 최소 한개의 간선의 최단경로가 결정된다.
            for(int j = 1; j<=m; j++){
                Edge current = edges[j];
                long distance = dist[current.start] + current.weight;
                if(dist[current.start]!=Integer.MAX_VALUE && dist[current.end]>distance){
                    // 무한대가 아니어야 작동하게 한 이유는 간선 사용 횟수에 따라서 최단경로를 구하기 위함이다.
                    dist[current.end] = distance;
                }
            }
        }

        boolean isCycle = false; // 음수 사이클 여부

        for(int i = 1; i<=m;i++){ // 음수 사이클 여부 확인
            Edge current = edges[i];
            long distance = dist[current.start] + current.weight;
            if(dist[current.start]!=Integer.MAX_VALUE && dist[current.end]>distance){
                isCycle = true;
                break;
            }
        }

        if(isCycle){
            bw.write("-1");
        }else{
            for(int i = 2;i<=n;i++){
                if(dist[i]==Integer.MAX_VALUE){
                    bw.write("-1\n");
                }else{
                    bw.write(dist[i] + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static class Edge{
        int start;
        int end;
        int weight;
        Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
