import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long cnt = 0;

    public static void main(String[] args) throws IOException { // 병합 정렬 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(arr,0,n-1);
        System.out.println(cnt);
    }

    static void mergeSort(int[] arr,int start, int end){
        if(start<end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, end, mid);
        }
    }

    static void merge(int[] arr,int start,int end,int mid){
        int[] tmpArr = new int[end-start+1];
        int index = 0;
        int left = start;
        int right = mid+1;
        while(left<=mid && right<=end){
            if(arr[left]>arr[right]){
                tmpArr[index] = arr[right];
                index++;
                right++;
                /*
                arr[left] 와 arr[right] 는 두 부분의 정렬된 배열 부분 중 맨 앞의 값을 비교하는 것이기 때문에
                만약 arr[left] 보다 arr[right] 가 더 작다면 왼쪽 값들은 오른쪽 값들 보다 클 수 밖에 없다.
                 */
                cnt += (mid - left + 1); // left ~ mid 까지의 요소들의 개수를 구한다.
            }else{
                tmpArr[index] = arr[left];
                index++;
                left++;
            }
        }

        while(left<=mid){
            tmpArr[index] = arr[left];
            index++;
            left++;
        }

        while(right<=end){
            tmpArr[index] = arr[right];
            index++;
            right++;
        }

        for (int i = 0; i < tmpArr.length; i++) {
            arr[i+start]= tmpArr[i];
        }
    }
}