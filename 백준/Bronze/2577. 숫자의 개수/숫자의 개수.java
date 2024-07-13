import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int multi = a * b * c;
        String strResult = String.valueOf(multi);

        int[] num = new int[10];
        for (int i = 0; i < 10; i++) {
            num[i] = 0; // 숫자를 저장할 배열 0으로 채우기
        }

        for (int i = 0; i < strResult.length(); i++) {
            num[Character.getNumericValue(strResult.charAt(i))]++;
        }

        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
}