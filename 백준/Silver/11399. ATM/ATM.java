import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 배열의 크기
        int[] line = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            line[i] = Integer.parseInt(st.nextToken()); // 배열에 각 사람들 소요 시간 입력
        }
        // 정렬 (삽입 정렬)
        for (int i = 0; i < n; i++) {
            int target = line[i];
            int j = i-1;
            while(j>=0 && target<line[j]){ // 앞 요소보다 작을 때
                line[j+1] = line[j]; // 배열 요소 오른쪽으로 shift
                j--;
            }
            line[j+1] = target; // 비어있는 칸에 해당 요소 삽입
        }

        // 합 배열 만들기
        int[] sumArr = new int[n];
        sumArr[0] = line[0]; // 배열 첫 요소는 대입 (범위 초과 예외 방지)
        int sum = sumArr[0];
        for (int i = 1; i < n; i++) {
            sumArr[i] = line[i] + sumArr[i-1];
            sum += sumArr[i]; // 합 배열 만들면서 요소들 더하기
        }
        System.out.println(sum);
    }
}
