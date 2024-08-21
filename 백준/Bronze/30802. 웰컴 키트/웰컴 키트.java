import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int peopleNum = scanner.nextInt(); // 참가자 수
        int[] tArr = new int[6]; // 티셔츠 수 배열
        for (int i = 0; i < 6; i++) {
            tArr[i] = scanner.nextInt();
        }
        int T = scanner.nextInt(); // 티 묶음 단위
        int P = scanner.nextInt(); // 펜 묶음 단위

        int Tcnt = 0; // 티셔츠 묶음수
        for (int i = 0; i < tArr.length; i++) {
            Tcnt += tArr[i]/T; // 몫 더하기
            if(tArr[i]%T!=0){ // 나머지가 0이 아니면
                Tcnt++;
            }
        }
        System.out.println(Tcnt);
        int Pcnt = peopleNum/P; // 펜 묶음수
        System.out.printf("%d %d",Pcnt,peopleNum%P);
    }
}