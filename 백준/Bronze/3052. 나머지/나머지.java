import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = new ArrayList<>();
        int[] numArr = new int[10];
        for (int i = 0; i < 10; i++) {
            numArr[i] = scanner.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            int sameNum = numArr[i] % 42;
            if(!(numList.contains(sameNum))){
                numList.add(sameNum);
            }
        }

        System.out.println(numList.size());
    }
}
