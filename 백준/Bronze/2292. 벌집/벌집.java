import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int cnt = 1;
        int range=2;
        if(num==cnt){
            System.out.println(cnt);
        }
        else{
            while(range<=num){
                range = range + (6*cnt); // 8,20,38
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}