
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int n;
    static int blueCnt = 0;
    static int whiteCnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        getCnt(1,1,n);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }
    static void getCnt(int x,int y, int size){
        int cnt = 0;

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                cnt += arr[i][j];
            }
        }

        if(cnt==0){
            whiteCnt++;
            return;
        }else if(cnt==(size*size)){
            blueCnt++;
            return;
        }

        int half = (size/2);

        // 사분면 분할
        getCnt(x,y,half); // 좌상
        getCnt(x,y+half,half); // 우상
        getCnt(x+half,y,half); // 좌하
        getCnt(x+half,y+half,half); // 우하
    }
}
