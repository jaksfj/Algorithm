import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quicksort(arr,0,n-1,k-1);
        System.out.println(arr[k-1]);
    }

    static void quicksort(int[] arr, int start, int end, int k){
        int pivot = partition(arr, start, end);
        if(pivot==k){
            return;
        }

        if(start<end) {
            if (pivot < k) {
                quicksort(arr, pivot+1, end, k);
            } else {
                quicksort(arr, start, pivot-1, k);
            }
        }
    }

    static int partition(int[] arr, int start, int end){
        int mid = (start + end) / 2;
        swap(arr, start, mid);
        int pivot = arr[start];
        int left = start + 1;
        int right = end;

        while(left <= right){
            while(left<=end && arr[left]<pivot){
                left++;
            }

            while(right>start && arr[right]>pivot){
                right--;
            }

            if(left<=right){
                swap(arr,left,right);
                left++;
                right--;
            }
        }
        swap(arr,start,right);
        return right;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
