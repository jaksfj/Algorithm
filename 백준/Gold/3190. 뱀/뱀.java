import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n+1][n+1];
        // 방향 전환 배열 (위 오 아래 왼)
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        ArrayDeque<Snake> snakeQueue = new ArrayDeque<>(); // 뱀 몸통
        boolean[][] snakeBody = new boolean[n+1][n+1];

        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x][y] = 1; // 보드에 사과 배치
        }

        int l = sc.nextInt(); // 뱀의 방향 전환 횟수
        ArrayDeque<Turn> turnQueue = new ArrayDeque<>(); // 방향 전환 큐
        for (int i = 0; i < l; i++) {
            int x = sc.nextInt(); // 해당 초
            String turn = sc.next(); // 방향 전환
            turnQueue.offer(new Turn(x,turn));
        }
        int second = 0;
        int dirIndex = 0; // 방향전환 배열 인덱스
        int x = 1;
        int y = 1; // 뱀의 현재위치 인덱스
        snakeQueue.offer(new Snake(1,1));
        snakeBody[1][1] = true; // 머리 위치 세팅
        while(true){
            second++;
            x += dx[dirIndex]; // x의 위치 옮기기
            y += dy[dirIndex]; // y의 위치 옮기기
            if((x>n || x<1 || y>n || y<1) || (snakeBody[x][y])){ // 벽에 부딪히거나 자기 몸에 부딪히면 게임 종료
                break;
            }

            if(board[x][y]==0){ // 만약에 사과가 없으면
                // 꼬리 위치 옮기면서 앞머리 옮기기
                Snake tail = snakeQueue.poll();
                snakeBody[tail.x][tail.y] = false; // 없애주기
                snakeQueue.offer(new Snake(x,y));
            }else{ // 만약에 사과가 있다면
                // 꼬리 위치 그대로 두고(poll 하지않기) 앞머리만 옮기기, 사과먹기
                board[x][y]=0; // 사과먹기
                snakeQueue.offer(new Snake(x,y));
            }
            snakeBody[x][y] = true; // 위치시키기

            if (!turnQueue.isEmpty() && turnQueue.peek().second == second) { // 방향 전환이 필요할 때!
                Turn turn = turnQueue.poll();
                if(turn.direction.equals("D")){
                    dirIndex++;
                }else{
                    dirIndex--;
                }
                dirIndex = (dirIndex+4) % 4;
            }
        }
        System.out.println(second);
    }

    static class Snake{
        int x;
        int y;
        Snake(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Turn{
        int second;
        String direction;
        Turn(int second, String direction){
            this.second = second;
            this.direction = direction;
        }
    }
}
