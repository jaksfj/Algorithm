import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        ArrayList<Node>[] list = new ArrayList[v+1];
        int[] distance = new int[v+1]; // 거리 배열
        boolean[] visited = new boolean[v+1];

        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while(true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) {
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());
                list[node].add(new Node(next, weight));
            }
        }

        bfs(list,visited,1,distance);

        // 거리 배열에서 가장 거리가 먼 인덱스부터 bfs 시작
        int maxIndex = 0;
        int max = 0;
        for (int i = 1; i <= v; i++) {
            if(max<distance[i]){
                max = distance[i];
                maxIndex = i;
            }
        }

        visited = new boolean[v+1]; // 방문 배열 초기화
        distance = new int[v+1]; // 거리 배열 초기화

        bfs(list,visited,maxIndex,distance);
        // 트리의 끝점부터 시작해서 끝점까지의 거리(트리의 지름)를 구하기 위해 bfs 를 한번 더한다.

        // 거리배열에서 가장 거리가 먼 거리 찾기
        max = 0;
        for (int i = 1; i <= v; i++) {
            if(max<distance[i]){
                max = distance[i];
            }
        }

        System.out.println(max);
    }

    private static void bfs(ArrayList<Node>[] list, boolean[] visited, int node, int[] distance){
        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(Node next : list[current]){
                if(!visited[next.index]) {
                    visited[next.index] = true;
                    queue.offer(next.index);
                    distance[next.index] += distance[current] + next.weight; // 현재 노드랑 다음 노드의 거리의 합을 다음 노드의 인덱스의 거리배열에 저장
                }
            }
        }
    }

    private static class Node{
        int index;
        int weight;

        Node(int num, int weight){
            this.index = num;
            this.weight = weight;
        }
    }
}