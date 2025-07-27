import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 최대 공약수 구하기
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int gcd = getGCD(num1,num2);
        System.out.println(gcd);

        // 최소 공배수 구하기
        System.out.println((num1*num2)/gcd);
    }

    public static int getGCD(int num1,int num2){
        int gcd;
        while(true){
            int remain = num1%num2; // 24 % 18 = 6
            if(remain==0){
                gcd = num2;
                break;
            }
            num1 = num2;
            num2 = remain;
        }
        return gcd;
    }
}