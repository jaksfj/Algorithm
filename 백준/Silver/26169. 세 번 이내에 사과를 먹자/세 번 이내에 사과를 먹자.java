import java.util.Scanner;

public class Main {
    static int[][] board = new int[5][5];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1}; // 상 하 좌 우
    static boolean isPossible = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int r = sc.nextInt();
        int c = sc.nextInt();
        dfs(r,c,0,0);
        if(isPossible){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    static void dfs(int x,int y,int appleCnt, int stepCnt){
        int value = board[x][y];
        if(board[x][y]==1){
            appleCnt++; // 사과의 개수 증가
        }
        board[x][y] = -1; // 밟은 땅은 장애물로 설정
        if(appleCnt>=2){
            isPossible = true;
            board[x][y]= value; // 원래 값으로 복원 (백트래킹)
            return;
        }
        if(stepCnt>=3){ // 걸음이 3번 이상이면 종료
            board[x][y]= value; // 원래 값으로 복원 (백트래킹)
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ix = x + dx[i];
            int iy = y + dy[i];
            if(ix<5 && iy<5 && ix>=0 && iy>=0 && board[ix][iy]!=-1) { // 장애물이 아니고 범위에 벗어나지 않으면 이동
                dfs(ix, iy, appleCnt, stepCnt + 1);
            }
        }
        board[x][y]= value; // 원래 값으로 복원 (백트래킹)
    }
}
