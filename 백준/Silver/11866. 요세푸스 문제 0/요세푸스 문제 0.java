

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 요세푸스 문제
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.offer(i+1);
        }

        sb.append("<");
        while(queue.size()>1){
            for (int i = 0; i < k-1; i++) {
                queue.offer(queue.poll()); // K번째 전까지의 앞 요소들을 뒤로 보내기
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}
