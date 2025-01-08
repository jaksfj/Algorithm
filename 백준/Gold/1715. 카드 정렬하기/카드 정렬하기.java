import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 숫자 카드 묶음의 수
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐 사용 : 오름차순으로 빼서 더해주면 된다.
        // 우선순위 큐 입력 값 저장 (오름차순으로 정렬 후 poll() 목적 사용)
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int cnt = 0; // 비교 수
        while(pq.size()>1){ // 큐에 요소가 한개밖에 안남을 때 까지
            // 2개 요소 빼서 서로 더한 것 += 비교횟수, 더한 것을 큐에 넣는 것을 반복한다.
            int num1 = pq.poll();
            int num2 = pq.poll();
            int sum = num1 + num2; // 묶음 간 비교 횟수
            cnt += sum; // 비교횟수 전체 cnt 에 더하기
            pq.add(sum); // 비교 횟수를 다시 넣는다.
        }

        System.out.println(cnt);
    }
}
