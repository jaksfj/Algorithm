import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        /*
        n-1 부터 시작해서 1까지 가면서 1의 개수를 모으고, 그 과정들을 sb에 저장
        마지막에 남은 정수를 출력한 후 sb 를 출력
         */
        for(int i=n-1;i>=1;i-=2){
           if(i==1){ // 뒤에 쪽에 1이 하나 남았을 때
               list.add(1);
           }else{
               sb.append(i + " " + (i-1) + "\n");
               list.add(1);
           }
        }
        /*
        남은 1들끼리 서로 빼기. 과정도 담기
         */
        int current = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            sb.append(current + " " + list.get(i) + "\n");
            current = Math.abs(current-list.get(i));
        }
        int answer = Math.abs(n-current);

        System.out.println(answer);
        sb.append(n + " " + current + "\n");
        System.out.println(sb);
    }
}
