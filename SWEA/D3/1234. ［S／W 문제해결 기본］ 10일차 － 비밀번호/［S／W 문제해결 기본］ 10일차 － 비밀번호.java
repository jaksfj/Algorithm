import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            st = new StringTokenizer(sc.nextLine());
            int n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str.substring(i,i+1));
            }

            int prev = -1;
            int cur;
            for (int i = 0; i < n; i++) {
                cur = arr[i];
                if(prev==cur){
                    // 투포인터로 넓혀가기
                    int start = i-1;
                    int end = i;
                    while(start>=0 && end<n){
                        while(arr[start]==-1 && start>0){
                            start--;
                        }
                        while(arr[end]==-1 && end<n-1){
                            end++;
                        }
                        if(arr[start]==arr[end]){ // 둘이 같으면 -1로 설정
                            arr[start] = -1;
                            arr[end] = -1;
                        }else{
                            break;
                        }
                        start--;
                        end++;
                    }
                }
                prev = cur;
            }

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < n; i++) {
                if(arr[i]!=-1){
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
        }
    }
}