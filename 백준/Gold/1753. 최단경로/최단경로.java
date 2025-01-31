import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()); // 노드의 수
        int e = Integer.parseInt(st.nextToken()); // 간선의 수
        int k = Integer.parseInt(br.readLine()); // 시작 노드
        ArrayList<Edge>[] list = new ArrayList[v+1]; // 인접리스트
        int[] dist = new int[v+1]; // 각 노드까지의 최단 거리를 구하기 위한 배열

        for(int i = 1; i<= v; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i<=v; i++){
            dist[i] = Integer.MAX_VALUE; // 무한대를 표현하기 위한 것
        }

        for(int i = 0; i<e;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 시작 노드
            int end = Integer.parseInt(st.nextToken()); // 도착 노드
            int w = Integer.parseInt(st.nextToken()); // 가중치
            list[start].add(new Edge(end,w));
        }

        dist[k] = 0; // 시작노드는 0으로 설정
        // 다익스트라 : 가중치가 낮은 노드부터 탐색
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>(){
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        pq.offer(new Edge(k,0)); // 첫번째 노드는 0
        while(!pq.isEmpty()){
            Edge node = pq.poll();
            for(Edge next : list[node.index]){
                int distance = dist[node.index] + next.weight;
                if(dist[next.index] > distance) {
                    dist[next.index] = distance;
                    pq.offer(new Edge(next.index,distance));
                }
            }
        }

        for(int i=1;i<=v;i++){
            if(dist[i]==Integer.MAX_VALUE){
                bw.write("INF\n");
            }else{
                bw.write(dist[i] + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static class Edge{
        int index;
        int weight;
        Edge(int index,int weight){
            this.index = index;
            this.weight = weight;
        }
    }
}