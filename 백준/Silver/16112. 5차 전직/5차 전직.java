import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += arr[i]*Math.min(i,k); // 중복으로 더해지는 곳을 곱으로
        }
        System.out.println(answer);
//        PriorityQueue<Long> pq = new PriorityQueue<>();
//        for (int i = 0; i < n; i++) {
//            pq.offer(Long.parseLong(st.nextToken()));
//        }
//        long answer = 0;
//        long cnt = 0;
//        while(cnt<=k) {
//            long sum = 0;
//            pq.poll();
//            for(long val : pq){
//                sum += val;
//            }
//            answer += sum;
//            cnt++;
//        }
//        System.out.println(answer);
        // 이 방식으로 풀어버리면 O(n^2) 로 시간초과!
    }
}
