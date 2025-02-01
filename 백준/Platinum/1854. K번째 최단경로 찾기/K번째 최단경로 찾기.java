import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시 수
        int m = Integer.parseInt(st.nextToken()); // 도로 수
        int k = Integer.parseInt(st.nextToken()); // k 번째 최단경로
        ArrayList<Edge>[] list = new ArrayList[n+1]; // 도로 정보 저장 인접리스트
        PriorityQueue<Integer>[] distQueue = new PriorityQueue[n+1]; // 최단거리 큐 배열

        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
            distQueue[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int arrive = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Edge(arrive,weight));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(); // 도시 탐색위한 큐
        pq.offer(new Edge(1,0));
        distQueue[1].offer(0); // 시작 도시 넣기

        while(!pq.isEmpty()){
            Edge current = pq.poll();
            for(Edge next : list[current.index]){
                int distance = current.weight + next.weight;
                if(distQueue[next.index].size()<k){ // 최단거리 큐에 요소가 k개 미만일 때
                    distQueue[next.index].offer(distance);
                    pq.offer(new Edge(next.index,distance));
                }else if(distQueue[next.index].peek()>distance){
                    distQueue[next.index].poll(); // 해당 큐에서 가장 큰 요소 삭제
                    distQueue[next.index].offer(distance); // 최단거리 저장
                    pq.offer(new Edge(next.index,distance));
                }
            }
        }

        for(int i = 1;i<=n;i++){
            if(distQueue[i].size()==k){
                bw.write(distQueue[i].peek() + "\n");
            }else{
                bw.write(-1 + "\n");
            }
        }

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
        public int compareTo(Edge o){ // 가중치 오름차순 기준으로 정렬
            return this.weight - o.weight;
        }
    }
}
