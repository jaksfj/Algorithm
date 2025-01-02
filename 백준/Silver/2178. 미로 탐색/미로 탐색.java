import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;

    // 상하좌우를 탐색하기 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0,0,-1,1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j-1,j));
            }
        }

        int depth = bfs(1,1);
        System.out.println(depth);
    }

    private static int bfs(int x,int y){
        visited[x][y] = true;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x,y,1)); // 초기 깊이는 1

        while(!queue.isEmpty()){
            Node current = queue.poll();

            if(current.x == n && current.y == m){
                return current.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                // 탐색한 인덱스가 적절한 범위내인지, 값이 1인지를 확인하고 큐에 저장
                if(nextX>=1 && nextX<=n && nextY>=1 && nextY<=m && !visited[nextX][nextY] && arr[nextX][nextY]==1){
                    visited[nextX][nextY] = true;
                    queue.offer(new Node(nextX,nextY,current.depth+1));
                }
            }
        }
        return -1; // 도달하지 못하는 경우
    }

    private static class Node{
        int x;
        int y;
        int depth;
        Node(int x,int y,int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}