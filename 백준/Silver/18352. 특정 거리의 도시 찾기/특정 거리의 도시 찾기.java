

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n+1];
        ArrayList<Integer>[] list = new ArrayList[n+1];
        boolean[] answer = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end); // 인접리스트에 추가
        }
        bfs(list,x,visited,k,answer);
    }

    static void bfs(ArrayList<Integer>[] list, int start, boolean[] visited,int distance,boolean[] answer){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        int[] distanceArr = new int[list.length]; // 각 노드까지의 거리를 담은 배열
        for (int i = 1; i < distanceArr.length; i++) {
            distanceArr[i] = -1; // 각 도시까지의 거리 -1 로 초기화
        }
        distanceArr[start] = 0; // 시작 도시는 거리가 0임
        queue.offer(start);
        visited[start] = true;
        boolean isExist = false;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : list[cur]){
                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                    distanceArr[next] = distanceArr[cur] + 1;
                }
            }
        }

        for (int i = 1; i < list.length; i++) {
            if (distanceArr[i] == distance) {
                isExist = true;
                System.out.println(i);
            }
        }
        if(!isExist){
            System.out.println(-1);
        }
    }
}
