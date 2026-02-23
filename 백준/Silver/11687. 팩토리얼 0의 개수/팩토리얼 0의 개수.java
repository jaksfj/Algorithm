import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextInt();
        // 0의 개수가 m개인 n! 중에서 가장 작은 n 을 구하라
        // 0~4 : 0 5~9 : 1 10 ~ 14 : 2
        // 즉 m:1 -> 5, m:2 -> 10 ... m:4 -> 20, m:5 -> -1, m:6 -> 25
        long start = 0;
        long end = 5 * m; // 최대를 설정
        while(start<end){
            long mid = (start+end)/2;
            if(getZeroCnt(mid)<m){ // 0의 개수가 m 개 보다 작은상태
                start = mid+1;
            }else{ // 0의 개수가 m보다 크거나 같으면 종료시키기
                end = mid;
            }
        }
        if(getZeroCnt(start)==m){
            System.out.println(start);
        }else{
            System.out.println(-1);
        }
    }

    static long getZeroCnt(long value){ // 5의 개수를 구하는 함수
        long cnt = 0;
        while(value>0){
            value/=5;
            cnt+=value;
        }
        return cnt;
    }
}
