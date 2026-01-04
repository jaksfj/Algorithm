import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        long[] dp = new long[101];
        dp[1] = 1; // 노드 한개는 트리 높이가 1이므로
        // 해당 트리의 맨 왼쪽 첫번째 노드값은 이전과 전전 트리의 맨왼쪽 느드 값을 각각 더하고 1을 더한 값과 같다는 규칙성이 있음.
        // N(h) = 1 + N(h+1) + N(h+2)
        for (int i = 2; i <= 100; i++) {
            dp[i] = 1 + dp[i-1] + dp[i-2];
        }
        // 미리 트리의 왼쪽 끝 값에 따른 트리의 높이 저장
        for (int i = 0; i < test_case; i++) {
            long v = sc.nextLong();
            for (int j = 0; j <= 100; j++) {
                if(dp[j]<=v && v<dp[j+1]){ // 트리의 왼쪽 끝값의 위치와 오른쪽 끝값의 위치 사이의 노드일 때
                    System.out.println(j); // 트리의 높이 반환
                    break;
                }
            }
        }
    }
}
