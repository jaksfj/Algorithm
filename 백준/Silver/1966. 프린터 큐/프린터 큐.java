

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int test_case = 0;test_case<t;test_case++){
            ArrayDeque<Value> deque = new ArrayDeque<>();
            int n = sc.nextInt(); // 문서 개수
            int index = sc.nextInt(); // 구하고자하는 값의 큐에서의 index
            for(int i = 0;i<n;i++) {
                int priority = sc.nextInt();
                deque.offer(new Value(i,priority));
            }
            // 큐에다가 다 넣은 후 우선순위 별로 뒤로 옮기기
            int cnt = 1;
            while(!deque.isEmpty()){
                Value cur = deque.poll();
                if(deque.isEmpty()){
                    System.out.println(cnt);
                    break;
                }
                boolean isExist = false;
                // 만약 하나라도 뒤에 더 큰 수가 있으면 큐의 맨뒤로 보내기
                for (Value next : deque) {
                    if (cur.priority < next.priority) {
                        isExist = true;
                        deque.addLast(cur);
                        break;
                    }
                }
                // 만약에 뒤에 하나도 없다면 cnt 증가
                if(!isExist){
                    if(cur.index==index){
                        System.out.println(cnt);
                        break;
                    }
                    cnt++;
                }
            }
        }
    }

    static class Value{
        int index;
        int priority;
        Value(int order,int priority){
            this.index = order;
            this.priority = priority;
        }
    }
}
