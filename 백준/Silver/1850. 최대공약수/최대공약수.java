import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long gcd = getGCD(a,b); // a 와 b의 최대공약수를 찾기
        // 해당 수만큼 1 반복하면 끝
        for (int i = 0; i < gcd; i++) {
            bw.write('1');
        }
        bw.flush();
    }

    private static long getGCD(long n1,long n2){
        if(n1<n2){
            long tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        long result = n1%n2;
        if(result==0){
            return n2;
        }else{
            return getGCD(n2,result);
        }
    }
}
