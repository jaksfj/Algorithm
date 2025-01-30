import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시 수
        int m = Integer.parseInt(br.readLine()); // 도로 수
        int[] arriveTime = new int[n+1]; // 해당 노드까지 가는데 걸리는 임계 경로 시간 저장
        int[] degree = new int[n+1]; // 진입차수 배열
        ArrayList<Node>[] list = new ArrayList[n+1]; // 위상정렬을 위한 정방향 인접리스트
        ArrayList<Node>[] reverseList = new ArrayList[n+1]; // 돌아오면서 확인하기 위한 역방향 인접리스트

        // 인접리스트 초기화
        for(int i = 1;i<=n;i++){
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 시작 도시
            int end = Integer.parseInt(st.nextToken()); // 도착 도시
            int weight = Integer.parseInt(st.nextToken()); // 도로 지나는데 걸리는 시간
            list[start].add(new Node(end,weight)); // 정방향
            degree[end]++; // 진입차수 증가시키기
            reverseList[end].add(new Node(start,weight)); // 역방향
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int arriveCity = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(startCity); // 시작 도시 큐에 넣기

        // 정방향으로 위상정렬 수행하여 임계 경로값 저장
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(Node next : list[node]){
                arriveTime[next.end] = Math.max(arriveTime[next.end],next.weight + arriveTime[node]);
                degree[next.end]--; // 진입차수 감소시키기
                if(degree[next.end]==0){
                    queue.add(next.end);
                }
            }
        }

        // 역방향으로 해당 노드와 임계경로값이 같은 노드로만 탐색하면서 도로는 지나는데 걸리는 시간과 도로 수 구하기
        int roadCnt = 0;

        queue = new ArrayDeque<>();
        queue.offer(arriveCity);
        boolean[] visited = new boolean[n+1];

        // 역방향으로 bfs 수행
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(Node next : reverseList[node]){ // ex) node : 7, next.end : 2, next.weight : 7->2로 가는데 걸리는 시간
                if(arriveTime[node] == arriveTime[next.end] + next.weight){ // 임계경로 값과 가리키는 노드의 임계경로 값과의 비교
                    roadCnt++;
                    if(!visited[next.end]) {
                        visited[next.end] = true;
                        queue.offer(next.end);
                    }
                }
            }
        }

        System.out.println(arriveTime[arriveCity]);
        System.out.println(roadCnt);
    }

    private static class Node{
        int end;
        int weight;
        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }
}
