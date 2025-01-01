import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 최대 자릿수

        // 2,3,5,7 은 일의 자리에서의 소수이다.
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);
    }

    static void dfs(int num,int jalitsu){
        if(jalitsu == N){ // 자릿수랑 N이랑 같아지면
            if(isPrime(num)){
                System.out.println(num);
            }
        }

        for (int i = 1; i <= 9; i+=2) { // 홀수만 뒤에 붙일 수 있다.
            if(isPrime(10*num+i)){
                dfs(10*num+i,jalitsu+1);
            }
        }
    }

    static boolean isPrime(int num){
        for (int i = 2; i <= num/2; i++) {
            if(num%i==0){ // 소수가 아니면
                return false;
            }
        }
        return true;
    }
}