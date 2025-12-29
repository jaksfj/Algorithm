import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        char[][] H = new char[n][n];
        char[][] R = new char[n][n];
        char[][] C = new char[n][n];

        // H,R,C 입력받기
        for (int j = 0; j < n; j++) {
            String s = br.readLine();
            for (int k = 0; k < n; k++) H[j][k] = s.charAt(k);
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int k = 0; k < n; k++) R[i][k] = s.charAt(k);
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) C[i][j] = s.charAt(j);
        }

        // 격자 M 완성하기 : 해당 인덱스의 격자의 위치가 1이면 1로 설정
        char[][][] M = new char[n][n][n];

        boolean[][] tmpH = new boolean[n][n]; // (j,k)
        boolean[][] tmpR = new boolean[n][n]; // (i,k)
        boolean[][] tmpC = new boolean[n][n]; // (i,j)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (H[j][k] == '1' && R[i][k] == '1' && C[i][j] == '1') {
                        M[i][j][k] = '1';
                        // 사영한 결과를 저장하기
                        tmpH[j][k] = true;
                        tmpR[i][k] = true;
                        tmpC[i][j] = true;
                    } else {
                        M[i][j][k] = '0';
                    }
                }
            }
        }

        // 사영한 결과와 입력받은 격자의 모습과 같은지 확인
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                boolean want = (H[j][k] == '1');
                if (tmpH[j][k] != want) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                boolean want = (R[i][k] == '1');
                if (tmpR[i][k] != want) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean want = (C[i][j] == '1');
                if (tmpC[i][j] != want) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        // 모두 맞다면 출력
        StringBuilder sb = new StringBuilder();
        sb.append("YES\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char[] row = new char[n];
                for (int k = 0; k < n; k++) row[k] = M[i][j][k];
                sb.append(row).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}

