import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException { // 이진탐색 문제
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 한 행의 최대 수
        int k = Integer.parseInt(br.readLine()); // 찾고자 하는 k 번째 수

        long start = 1; // 배열에서 제일 작은 수
        long end = (long) n * n; // 한 행에서의 개수
        long answer = 0;

        while(start<=end){
            long mid = (start + end) / 2; // 해당 범위에서의 중간값
            long sum = 0;
            // 각 행에서 mid 보다 작은 수들의 개수를 더하기
            for (int i = 1; i <= n; i++) { // 행마다의 첫번째 수는 1,2,3,4..,N 순으로 순서대로 증가한다.
                sum += Math.min((mid/i),n); // 한 행은 최대 n 개의 수이므로
            }

            if(sum>=k){ // mid 이하의 수들의 개수가 k 보다 클 경우 (같다 표시 넣어줘야 한다!)
                end = mid-1; // 더 작은 범위의 수에서 찾기
                answer = mid; // mid 이하의 수 중에 k가 포함되기 때문에 정답 후보로 저장
            }else{ // mid 이하의 수의 개수가 k 보다 작을 경우 (k 번째 수 포함 안됨!)
                start = mid+1; // 더 큰 범위의 수에서 찾기
            }
        }

        System.out.println(answer); // start>end 가 되는 순간 종료되므로
    }
}