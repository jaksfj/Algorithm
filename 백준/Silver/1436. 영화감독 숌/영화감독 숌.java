import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException { // 영화감독 숌 : 666이 포함된 제목짓기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int num = 666;
        while(count!=n){
            if(String.valueOf(num).contains("666")){
                count++;
            }

            if(count==n){
                break;
            }
            num++;
        }
        System.out.println(num);
    }
}
