import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parents = new int[n+1]; // 부모 배열 (유니온파인드)
        Edge[] edges = new Edge[m]; // 에지 배열

        for(int i =0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start,end,weight);
        }

        Arrays.sort(edges);

        for(int i = 1;i<=n;i++){
            parents[i] = i; // 자기 자신을 부모로 초기화
        }

        long sum = 0;
        int cnt = 0;
        for(int j = 0;j<m;j++) {
            Edge current = edges[j];
            if (find(parents, current.start) != find(parents, current.end)) {
                union(parents, current.start, current.end);
                sum += current.weight;
                cnt++;
                if(cnt==n-1){
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    private static void union(int[] parents,int start,int end){
        int parent1 = find(parents,start);
        int parent2 = find(parents,end);
        if(parent1>parent2){ // 더 작은 수 기준으로 업데이트 (parent1 이 무조건 더 작게)
            int tmp = parent1;
            parent1 = parent2;
            parent2 = tmp;
        }
        parents[parent2] = parent1; // 연결
    }

    private static int find(int[] parents, int node){
        if(parents[node]!=node){
            return parents[node] = find(parents,parents[node]);
        }
        return parents[node];
    }

    private static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;
        Edge(int start,int end,int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){ // 가중치 기준으로 오름차순 정렬
            return Integer.compare(this.weight,o.weight);
        }
    }
}

