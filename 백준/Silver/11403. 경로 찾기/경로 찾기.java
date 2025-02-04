import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException { // 플로이드 워셜 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 정점개수
        StringTokenizer st;
        int[][] arr = new int[n+1][n+1];

        for(int i = 1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j<=n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1;i<=n;i++){ // 중간 경로
            for(int j=1;j<=n;j++){ // 시작 점
                for(int k = 1;k<=n;k++){ // 끝 점
                    if(arr[j][i]==1 && arr[i][k]==1) { // 중간에 양수인 경로가 존재한다면
                        arr[j][k] = 1;
                    }
                }
            }
        }

        for(int i = 1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }
}