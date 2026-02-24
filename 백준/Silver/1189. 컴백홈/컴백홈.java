import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String[][] arr;
    static boolean[][] visited;
    static int r,c,k; // 행, 열, 도달해야 하는 거리
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1}; // 상하좌우로 이동
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();
        arr = new String[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = sc.next();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.substring(j,j+1);
            }
        }
        dfs(r-1,0,1);
        System.out.println(cnt);
    }

    static void dfs(int x, int y, int distance){
        if(x==0 && y==c-1){ // 도착지점에 도착하면 종료
            if(distance == k){
                cnt++;
            }
            return;
        }
        visited[x][y] = true; // 방문 처리

        for (int i = 0; i < 4; i++) {
            int ix = x + dx[i];
            int iy = y + dy[i];
            if(ix<r && iy<c && ix>=0 && iy>=0 && !(arr[ix][iy].equals("T")) && !visited[ix][iy]){
                dfs(ix,iy,distance+1);
            }
        }
        visited[x][y] = false; // 백트래킹 처리
    }
}
