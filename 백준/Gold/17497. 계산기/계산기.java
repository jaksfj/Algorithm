import java.io.*;
import java.util.ArrayDeque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        int cnt = 0;
        ArrayDeque<String> stack = new ArrayDeque<>();
        while(n>0){
            if(n%4==2){ // 끝이 10일 때
                stack.push("[+] ");
                n-=2;
            }else if(n%2!=0){ // 끝이 01일 때 (홀수일 때)
                stack.push("[/] ");
                n*=2;
            }else if(n%4==0){ // 끝이 00 일 때
                stack.push("[*] ");
                n/=2;
            }
            cnt++;
        }
        bw.write(cnt + "\n");
        while(!stack.isEmpty()){
            bw.write(stack.pop());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
