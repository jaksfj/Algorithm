import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int gcd = getGCD(n1, n2); // 최대 공약수
            int lcm = (n1*n2)/gcd; // 최소 공배수
            System.out.println(lcm);
        }
    }

    private static int getGCD(int n1,int n2){
        if(n1<n2){ // 앞의 수가 커야하므로
            int tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        int result = n1%n2;
        if(result==0){
            return n2;
        }else{
            return getGCD(n2,result);
        }
    }
}
