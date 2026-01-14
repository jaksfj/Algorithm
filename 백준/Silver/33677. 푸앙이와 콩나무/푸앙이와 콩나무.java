import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static long[] days;
    static long[] waters;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        days = new long[n+1]; // length 에 따른 day 의 최소일을 저장할 배열
        waters = new long[n+1]; // 해당 day 에서의 최소 water
        Arrays.fill(days,Long.MAX_VALUE);
        Arrays.fill(waters,Long.MAX_VALUE);
        bfs(n);
        System.out.println(days[n] + " " + waters[n]);
    }

    static void bfs(long length){
        Queue<Tree> queue = new ArrayDeque<>();
        queue.offer(new Tree(0,0,0));
        days[0] = 0;
        waters[0] = 0;

        while (!queue.isEmpty()) {
            Tree cur = queue.poll();

            // 길이가 같은데 날짜가 더 적은게 있으면 넘어가기
            if (cur.day > days[(int) cur.length]) {
                continue;
            }
            // 날짜는 같은데 물양이 더 적은게 있으면 넘어가기
            if (cur.day == days[(int) cur.length] && cur.water > waters[(int) cur.length]) {
                continue;
            }

            // 길이+1
            if (cur.length + 1 <= length) {
                int nextLen = (int) cur.length + 1;
                long nextDay = cur.day + 1;
                long nextWater = cur.water + 1;

                if (nextDay < days[nextLen] || (nextDay == days[nextLen] && nextWater < waters[nextLen])) {
                    days[nextLen] = nextDay;
                    waters[nextLen] = nextWater;
                    queue.offer(new Tree(nextLen, nextDay, nextWater));
                }
            }

            // 길이*3
            if (cur.length > 0 && cur.length * 3 <= length) {
                int nextLen = (int) (cur.length * 3);
                long nextDay = cur.day + 1;
                long nextWater = cur.water + 3;

                if (nextDay < days[nextLen] || (nextDay == days[nextLen] && nextWater < waters[nextLen])) {
                    days[nextLen] = nextDay;
                    waters[nextLen] = nextWater;
                    queue.offer(new Tree(nextLen, nextDay, nextWater));
                }
            }

            // 길이 제곱
            if (cur.length > 1) {
                long nextLength = cur.length * cur.length;
                if (nextLength <= length) {
                    int nextLen = (int) nextLength;
                    long nextDay = cur.day + 1;
                    long nextWater = cur.water + 5;

                    if (nextDay < days[nextLen] || (nextDay == days[nextLen] && nextWater < waters[nextLen])) {
                        days[nextLen] = nextDay;
                        waters[nextLen] = nextWater;
                        queue.offer(new Tree(nextLen, nextDay, nextWater));
                    }
                }
            }
        }

    }

    static class Tree{
        long length;
        long day;
        long water;
        Tree(long length, long day, long water){
            this.length = length;
            this.day = day;
            this.water = water;
        }
    }
}
