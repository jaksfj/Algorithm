import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i<n;i++) {
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num];

            for (int j = 2; j < num; j++) {
                arr[j] = j;
            }

            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (arr[j] != 0) {
                    for (int k = j * j; k < num; k += j) {
                        arr[k] = 0;
                    }
                }
            }

            ArrayList<Integer> list = new ArrayList<>();
            // 소수끼리의 합들을 리스트에 다 저장
            for(int j=2;j<num;j++){
                for(int k=2;k<num;k++){
                    if(arr[j]!=0 && arr[k]!=0) {
                        list.add(arr[j] + arr[k]);
                    }
                }
            }

            // 리스트에서 두 소수의 합 값이 있는지 확인==
            boolean isExist = false;
            for(int sum : list) {
                if (sum==num) {
                    isExist = true;
                    break;
                }
            }

            System.out.println(isExist ? "Yes" : "No");
        }
    }
}