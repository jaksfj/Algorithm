import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        int[][] apartment = new int[15][15]; // 아파트
        for (int i = 0; i < testCase; i++) { // 테스트 케이스 수만큼 반복
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호수

            // 아파트 사람인원 채우기 (0층이랑, 1호부터 채우기)
            for (int j = 0; j < 15; j++) {
                apartment[j][1] = 1; // j층 1호는 무조건 1이니까
                apartment[0][j] = j; // 0층 j호는 j호
            }

            // 1층 1호부터 나머지 채우기
            for (int j = 1; j < 15; j++) { // 1층부터 14층까지
                for (int l = 2; l < 15; l++) { // 2호부터 14호까지
                    apartment[j][l] = apartment[j][l-1] + apartment[j-1][l]; // 같은 층에서 이전 호 값 + 아래층에서 해당 호 값
                }
            }

            System.out.println(apartment[k][n]);
        }
    }
}      