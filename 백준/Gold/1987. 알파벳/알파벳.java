import java.time.Year;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int r,c;
    static int max = 0;
    static char[][] board;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[] alphabets = new boolean[26];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            board[i] = sc.next().toCharArray();
        }
        dfs(0,0,1);
        System.out.println(max);
    }
    static void dfs(int x,int y,int distance){
        max = Math.max(distance,max);
        alphabets[board[x][y]-'A'] = true;
        for (int i = 0; i < 4; i++) {
            int ix = x + dx[i];
            int iy = y + dy[i];
            if(ix>=0 && iy>=0 && ix<r && iy<c && (!alphabets[board[ix][iy]-'A'])){
                dfs(ix,iy,distance+1);
            }
        }
        alphabets[board[x][y]-'A'] = false;
    }
}
