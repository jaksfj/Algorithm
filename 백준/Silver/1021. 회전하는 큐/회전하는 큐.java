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
            int index = 0;
            for (int value : deque) { // 해당 find 의 인덱스 위치 찾기
                if(find==value){
                    break;
                }
                index++;
            }
            if(index==0){
                deque.pollFirst();
            }else if(index<(deque.size()-index)){ // 0 인덱스부터 해당 인덱스까지 거리가 더 짧으면
                int cnt = 0;
                while(deque.getFirst()!=find){
                    int val = deque.pollFirst();
                    deque.offerLast(val);
                    cnt++;
                }
                deque.poll();
                answer += cnt;
            }else{ // 끝 인덱스부터 인덱스까지의 거리가 더 짧으면
                int cnt = 0;
                while(deque.getFirst()!=find){ 
                    int val = deque.pollLast();
                    deque.offerFirst(val);
                    cnt++;
                }
                deque.poll();
                answer += cnt;
            }
        }
        System.out.println(answer);
    }
}
