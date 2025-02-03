import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int startCity = Integer.parseInt(st.nextToken());
        int arriveCity = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] dist = new long[n]; // 최적의 경로를 찾기위한 각 도시마다의 최종 계산값 저장
        Edge[] edges = new Edge[m];
        int[] earns = new int[n]; // 각 도시마다의 수익

        Arrays.fill(dist,Integer.MIN_VALUE); // - 무한대로 채우기 : 우리가 찾아야 하는 것은 최댓값이므로

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start,end,cost); // 에지 정보 저장
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            earns[i] = Integer.parseInt(st.nextToken()); // 버는 돈 저장
        }

        dist[startCity] = earns[startCity]; // 시작도시의 비용 설정

        for(int i = 0;i<n+100;i++){ // n-1 번 하면 최적의 경로를 모두 구할 수 있음. 
            // n의 범위가 50까지이기 때문에 충분한 반복을 통해서 양수 사이클 모두 찾기
            for(int j=0;j<m;j++){
                Edge current = edges[j];
                if(dist[current.start]==Integer.MIN_VALUE){
                    continue;
                }

                if(dist[current.end]<dist[current.start]+(earns[current.end]-current.cost)){
                    dist[current.end] = dist[current.start] + (earns[current.end] - current.cost);
                    if(i>=n-1){
                        dist[current.end] = Integer.MAX_VALUE; // 양수 사이클 저장
                    }
                }else if(dist[current.start]==Integer.MAX_VALUE){
                    dist[current.end] = Integer.MAX_VALUE; // 양수 사이클은 전파된다.
                }
            }
        }

        if(dist[arriveCity]==Integer.MAX_VALUE){
            System.out.println("Gee");
        }else if(dist[arriveCity]==Integer.MIN_VALUE){
            System.out.println("gg");
        }else{
            System.out.println(dist[arriveCity]);
        }
    }

    private static class Edge{
        int start;
        int end;
        int cost;
        Edge(int start,int end,int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
