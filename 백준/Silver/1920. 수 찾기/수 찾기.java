

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 수 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        int[] result = new int[m];

        // a 배열 탐색 전 정렬 : 이분탐색 위해서
        Arrays.sort(a);

        // 제한시간 1초이고 입력 10만이므로 복잡도 nlogn -> 이분탐색
        for (int i = 0; i < m; i++) {
            if(divideSearch(a,b[i],0,n-1)){
                result[i] = 1;
            }else{
                result[i] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            if(result[i]==1) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    static boolean divideSearch(int[] arr,int num,int start,int end){
        if(start>end){
            return false;
        }
        int mid = (start+end)/2;
        int midValue = arr[mid];
        if(midValue == num){
            return true;
        }else if(midValue<num){
            return divideSearch(arr,num,mid+1,end);
        }else{
            return divideSearch(arr,num,start,mid-1);
        }
    }
}
