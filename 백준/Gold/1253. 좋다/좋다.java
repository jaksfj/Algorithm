import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numArr = new int[numCnt];

        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);  // 숫자 배열 정렬

        int cnt = 0;
        for (int i = 0; i < numCnt; i++) {
            int startPointer = 0;
            int endPointer = numCnt-1;
            int target = numArr[i];
            while(startPointer<endPointer){
                int sum = numArr[startPointer] + numArr[endPointer];
                if(sum > target){
                    endPointer--;
                }else if(sum < target) {
                    startPointer++;
                }else { // sum == target
                    if(startPointer!=i && endPointer!=i){ // 포인터들은 target 이 되면 안됨!! (서로 다른 target 이 아닌 수)
                        cnt++;
                        break;
                    }else if(startPointer==i){ // 포인터가 target 자체면 안되기 때문에
                        startPointer++; // 더 큰 수 범위에서 찾아야 함
                    }else if(endPointer==i){
                        endPointer--; // 더 작은 수 범위에서 찾아야 함
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}