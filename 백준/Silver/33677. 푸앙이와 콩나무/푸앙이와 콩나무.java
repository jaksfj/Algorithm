import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static long[] days;
    static long[] waters;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        days = new long[n+1];
        waters = new long[n+1];

        Arrays.fill(days,Long.MAX_VALUE);
        Arrays.fill(waters,Long.MAX_VALUE);

        days[0] = 0;
        waters[0] = 0;

        for (int i = 0; i <= n; i++) {
            if (days[i] == Long.MAX_VALUE) {
                continue; // 도달 불가 상태 skip
            }

            move(i,i+1,1);

            if(i>0){
                move(i,i*3,3);
            }

            if(i>1){
                long sq = (long)i*i;
                if(sq<=n) {
                    move(i, i * i, 5);
                }
            }
        }
        System.out.println(days[n] + " " + waters[n]);
    }

    static void move(int curLength, int nextLength, int water){
        if(nextLength>n){
            return;
        }

        long nextDay = days[curLength] + 1;
        long nextWater = waters[curLength] + water;

        if(nextDay<days[nextLength] || (nextDay==days[nextLength] && nextWater<waters[nextLength])){
            days[nextLength] = nextDay;
            waters[nextLength] = nextWater;
        }
    }
}
