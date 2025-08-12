import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 배열 정렬

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n-1;
            while(start<end) {
                int sum = arr[start] + arr[end];
                if (sum == arr[i]){
                    if(start != i && end != i) { // 세 수는 서로 다른 수여야 함 : 좋은 수 조건
                        cnt++;
                        break;
                    }else if(start == i){ // start 포인터가 i 라면 더 큰 범위에서 찾기
                        start++;
                    }else { // end 포인터가 i 라면 더 작은 범위에서 찾기
                        end--;
                    }
                }else if(sum > arr[i]){
                    end--;
                }else{
                    start++;
                }
            }
        }
        System.out.println(cnt);
    }
}
