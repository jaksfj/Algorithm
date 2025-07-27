

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) { // 배열의 인덱스
            boolean isPrime = true; // true : 소수, false : 소수 x
            if(arr[i]>1) {
                for (int k = 2; k <= Math.sqrt(arr[i]); k++) {
                    if (arr[i] % k == 0) { // 소수가 아니다
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
