import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = br.readLine();
            if (str == null || str.isEmpty()) {
                break;
            }
            int n = Integer.parseInt(str);
            char[] arr = new char[(int)Math.pow(3,n)];
            Arrays.fill(arr, '-');
            divide(arr,0,arr.length);
            System.out.println(arr);
        }
    }

    static void divide(char[] arr, int start, int end){
        if(end-start==1){
            return;
        }
        int third = (end-start)/3;
        int s = start+third;
        int e = start+2*third;
        for (int i = s; i < e; i++) {
            arr[i] = ' ';
        }
        divide(arr,start,s);
        divide(arr,e,end);
    }
}