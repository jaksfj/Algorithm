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
        getCnt(1,n,0);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }
    static void getCnt(int start,int end, int yAdd){
        if(start==end){
            if(arr[start][start+yAdd]==1){
                blueCnt++;
            }else{
                whiteCnt++;
            }
            return;
        }
        int mid = (start+end)/2;
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            for (int j = start+yAdd; j <= end+yAdd; j++) {
                cnt+=arr[i][j];
            }
        }
        if(cnt==0) {
            // 만약 0이면 whiteCnt 증가
            whiteCnt++;
            return;
        }else if(cnt==(int)Math.pow(end-start+1,2)){
            // 만약 n*n 이면 blueCnt 증가
            blueCnt++;
            return;
        }
        int half = mid-start+1;
        // 아니면 쪼개기
        getCnt(start, mid, yAdd); // 좌상
        getCnt(start, mid, yAdd + half); // 우상
        getCnt(mid+1, end, yAdd - half); // 좌하
        getCnt(mid+1, end, yAdd); // 우하
    }
}
