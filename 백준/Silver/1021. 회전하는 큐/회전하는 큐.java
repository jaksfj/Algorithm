import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static Deque<Integer> deque;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }
        int answer = 0;
        for (int i = 0; i < m; i++) {
            int find = sc.nextInt();
            Deque<Integer> tmp1 = new ArrayDeque<>(deque);
            Deque<Integer> tmp2 = new ArrayDeque<>(deque);
            int cnt2 = 0;
            int cnt3 = 0;
            if(!deque.isEmpty() && deque.getFirst()==find){
                deque.poll();
                continue;
            }
            while(tmp1.getFirst()!=find){
                int val = tmp1.pollFirst();
                tmp1.offerLast(val);
                cnt2++;
            }
            tmp1.poll();
            while(tmp2.getFirst()!=find){
                int val = tmp2.pollLast();
                tmp2.offerFirst(val);
                cnt3++;
            }
            tmp2.poll();
            if(cnt2>cnt3){
                deque = tmp2;
                answer += cnt3;
            }else{
                deque = tmp1;
                answer += cnt2;
            }
        }
        System.out.println(answer);
    }
}
