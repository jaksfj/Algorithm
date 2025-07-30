

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            boolean check = isValid(s);
            if(check){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    static boolean isValid(String s){
        int result = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.substring(j, j + 1).equals("(")) {
                result++;
            } else {
                result--;
            }

            if (result < 0) { // 오른쪽 가로가 더 먼저 나온 상황
                return false;
            }
        }
        if(result==0){
            return true;
        }
        return false;
    }
}
