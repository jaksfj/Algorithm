 
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int starIndex = 0;
        int sum = 0;
        for(int i = 0;i<s.length();i++){
            String num = s.substring(i,i+1);
            if(num.equals("*")){
                starIndex=i;
                continue;
            }
            int number = Integer.parseInt(num);
            if(i%2==0){
                sum += number;
            }else{
                sum += 3*number;
            }
        }
        // 짝수 인덱스 값들은 그냥 더하고, 홀수인덱스 값들은 전부 더하고 3곱하기
        // 둘을 합한 값을 10으로 나눈 값이 0이여야 함.
        // starIndex 가 홀수이면 1부터 시작해서 2씩 더해가면서 나눠서 구해지면 출력
        // starIndex 가 짝수이면 2부터 시작해서 2씩 더해가면서 나눠서 구해지면 출력
        // 별이 위치한 인덱스가 짝수인지 홀수인지
        for (int i = 0; i < 10; i++) {
            int tmp = sum;
            if(starIndex%2==0){
                tmp+= i;
            }else{
                tmp += i*3;
            }
            if(tmp%10==0){
                bw.write(i+ "");
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
