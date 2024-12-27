import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{ // 합병정렬 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(arr,0,n-1);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    static void mergeSort(int[] arr,int start,int end){
        if(start<end) {
            int mid = (start + end) / 2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,end);
        }
    }

    static void merge(int[] arr, int start, int end){
        int mid = (start + end)/2;
        int[] tmpArr = new int[end-start+1];
        int index = 0;
        int left = start;
        int right = mid+1;
        // 왼쪽 부분과 오른쪽 부분 비교하면서 임시배열 채우기
        while(left<=mid && right<=end){
            if(arr[left]<arr[right]){
                tmpArr[index] = arr[left];
                index++;
                left++;
            }else{
                tmpArr[index] = arr[right];
                index++;
                right++;
            }
        }

        // 나머지 부분 처리
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

        // 임시배열 값들을 정답 배열값에 저장하기
        for (int i = 0; i < tmpArr.length; i++) {
            arr[i+start] = tmpArr[i];
        }
    }
}
