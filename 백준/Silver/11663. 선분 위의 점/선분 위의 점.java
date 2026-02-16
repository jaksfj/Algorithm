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
            int left = findFirst(start); // start 이상 첫 위치
            int right = findLast(end); // end 초과 첫 위치
            System.out.println(right-left);
        }
    }
    static int findFirst(long target){
        int start = 0;
        int end = arr.length;
        while(start<end){
            int mid = (start+end)/2;
            // start 이상값을 찾아야 되므로 
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
            // end 초과값을 찾아야 하므로
            if(arr[mid]<=target){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}
