import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // 낮에 올라가는 미터
        int b = sc.nextInt(); // 밤에 내려가는 미터
        int v = sc.nextInt(); // 총 올라가야 하는 막대의 길이

        // 가야하는 날 수
        int day = ((v-b)/(a-b)); // 날 수 구하기
        if((v-b)%(a-b)==0){
            System.out.println(day);
        }else{
            System.out.println(day+1);
        }
    }
}