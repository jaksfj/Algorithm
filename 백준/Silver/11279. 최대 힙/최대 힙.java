import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

import static java.util.Collections.reverseOrder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if(x==0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }else {
                    System.out.println(pq.peek());
                    pq.poll();
                }
            }else{
                pq.offer(x);
            }
        }
    }
}
