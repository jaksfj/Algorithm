import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        // 양수큐와 음수큐를 나누어 받을 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int zero = 0; // 0의 개수
        int one = 0; // 1의 개수
        PriorityQueue<Integer> pluspq = new PriorityQueue<>(Collections.reverseOrder()); // 양수 큐는 큰수부터 나와야함
        PriorityQueue<Integer> minuspq = new PriorityQueue<>(); // 음수 큐는 작은 수부터 나와야함

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                zero++;
            }else if(num==1){
                one++;
            }else if(num>0){ // 양수면
                pluspq.add(num);
            }else{ // 음수면
                minuspq.add(num);
            }
        }

        int answer = 0;
        while(pluspq.size()>1){
            int num1 = pluspq.poll();
            int num2 = pluspq.poll();
            answer += num1 * num2;
        }

        if(!pluspq.isEmpty()){
            int last = pluspq.poll();
            answer += last; // 나머지 수 더해주기
        }

        while(minuspq.size()>1){
            int num1 = minuspq.poll();
            int num2 = minuspq.poll();
            answer += num1 * num2;
        }

        if(!minuspq.isEmpty()){
            int last = minuspq.poll();
            if(zero==0){ // 0이 하나도 없다면 그냥 더하기
                answer += last;
            }
        }

        // 1의 개수 더하기
        answer += one;

        System.out.println(answer);
    }
}