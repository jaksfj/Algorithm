import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 도시 수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수
        ArrayList<Edge>[] list = new ArrayList[n+1]; // 인접리스트
        int[] dist = new int[n+1]; // 최단 거리 저장 배열
        boolean[] visited = new boolean[n+1];

        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Edge(end,cost));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken()); // 출발 도시
        int arriveCity = Integer.parseInt(st.nextToken()); // 도착 도시

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        dist[startCity] = 0; // 시작 도시는 0으로 설정
        pq.offer(new Edge(startCity,0)); // 시작 도시의 가중치는 0

        while(!pq.isEmpty()){
            Edge node = pq.poll();
            if(visited[node.index]){ // 우선순위 큐를 사용하고 있기 때문에 한번에 최단 경로를 찾으므로 방문처리해도 된다.
                continue;
            }

            visited[node.index] = true;
            for(Edge next : list[node.index]){
                int distance = dist[node.index] + next.weight;
                if(distance<dist[next.index]){
                    dist[next.index] = distance;
                    pq.offer(new Edge(next.index,distance));
                }
            }
        }

        bw.write(dist[arriveCity] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Edge implements Comparable<Edge>{
        int index;
        int weight;
        Edge(int index,int weight){
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){
            return this.weight - o.weight;
        }
    }
}
