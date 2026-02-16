import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr); // 이분탐색을 위해 정렬

        for (int i = 0; i < m; i++) {
            long start = sc.nextInt();
            long end = sc.nextInt();

            int left = findFirst(start); // start 혹은 가장 가까운 오른쪽 인덱스
            int right = findLast(end); // end 혹은 가장 가까운 왼쪽 인덱스
            System.out.println(right-left);
        }
    }
    static int findFirst(long target){
        int start = 0;
        int end = arr.length;
        while(start<end){
            int mid = (start+end)/2;
            if(target<=arr[mid]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
    static int findLast(long target){
        int start = 0;
        int end = arr.length;
        while(start<end){
            int mid = (start+end)/2;
            if(arr[mid]<=target){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}
