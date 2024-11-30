import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        // 탐색 배열 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 배열 정렬하기 (퀵정렬)

        // 이진탐색
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()); // 찾을 수 입력받기
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(arr,target,0,n-1));
        }
    }

    static int binarySearch(int[] arr,int target,int start, int end){
        while(start<=end){
            int mid = (start + end) / 2; // 중간 인덱스
            int midValue = arr[mid]; // 중간 값
            if(midValue<target){ // 타깃 수보다 중간값이 더 작을 때
                start = mid+1;
            }else if(target<midValue){ // 타깃 수보다 중간값이 더 클 때
                end = mid-1;
            }else{ // 해당 수를 찾았을 때
                return 1;
            }
        }
        return 0;
    }
}
