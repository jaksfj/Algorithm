import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        minute -= 45; // 계산후 분
        if(minute < 0){
            minute = 60 + minute;
            hour -= 1;
        }
        if(hour < 0){
            hour = 23;
        }
        System.out.printf("%d %d",hour,minute);
    }
}
