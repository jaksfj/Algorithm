import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in );
        int n = scanner.nextInt();
        int []numArr = new int[n];
        int max=0;
        for (int i = 0; i < n; i++) {
            numArr[i] = scanner.nextInt();
            if(max<numArr[i]){
                max = numArr[i];
            }
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ((double)numArr[i]/(double)max)*100;
        }
        double result = sum/n;
        System.out.println(result);
    }
}
