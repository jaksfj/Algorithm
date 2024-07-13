import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int strArrSize = scanner.nextInt(); // 두번할 것

        int[] repeatCnt = new int[strArrSize];
        String[] strArr = new String[strArrSize];
        for (int i = 0; i < strArrSize; i++) {
            repeatCnt[i] = scanner.nextInt();
            strArr[i] = scanner.next();
        }

        StringBuilder[] sb = new StringBuilder[strArrSize];

        for (int i = 0; i < strArrSize; i++) {
            sb[i] = new StringBuilder(); // StringBuilder 배열의 각 요소 초기화
        }

        for (int i = 0; i < strArrSize; i++) {
            for (int j = 0; j < strArr[i].length(); j++) {
                for (int k = 0; k < repeatCnt[i]; k++) {
                    sb[i].append(strArr[i].charAt(j));
                }
            }
        }

        for (int i = 0; i < strArrSize; i++) {
            System.out.println(sb[i]);
        }
    }
}