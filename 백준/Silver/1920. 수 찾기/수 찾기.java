import java.io.*;
import java.util.*;

public class Main {
    static boolean isExist;
    public static void main(String[] args) throws IOException { // 이진탐색
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 이진 탐색은 정렬된 배열에서 수행함

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()); // 찾을 숫자들
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            isExist = false;
            binarySearch(arr,0,n-1,target);
            System.out.println(isExist ? 1 : 0);
        }
    }

    private static void binarySearch(int[] arr,int start,int end,int target){
        if(start>end){
            return;
        }
        int mid = (start + end) / 2;

        if(target==arr[mid]){
            isExist = true;
        } else if(target<arr[mid]){ // 왼쪽 부분 탐색
            binarySearch(arr,start,mid-1,target);
        } else if(target>arr[mid]){ // 오른쪽 부분 탐색
            binarySearch(arr,mid+1,end,target);
        }
        return;
    }
}