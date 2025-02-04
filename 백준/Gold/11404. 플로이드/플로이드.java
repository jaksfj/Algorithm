import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시 수
        int m = Integer.parseInt(br.readLine()); // 버스 수
        int[][] distArr = new int[n+1][n+1];
        StringTokenizer st;

        for(int i = 1;i<=n;i++){ // 자기 자신으로 가는 비용은 0, 나머지 비용은 무한대로 설정
            Arrays.fill(distArr[i],Integer.MAX_VALUE);
            distArr[i][i] = 0;
        }

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(distArr[start][end]!=Integer.MAX_VALUE){
                distArr[start][end] = Math.min(distArr[start][end],weight);
            }else {
                distArr[start][end] = weight; // 버스 정보 저장
            }
        }

        for(int i = 1;i<=n;i++){ // 경유지
            for(int j = 1;j<=n;j++){ // start
                for(int k=1;k<=n;k++){ // end
                    if(distArr[j][i]!=Integer.MAX_VALUE && distArr[i][k]!=Integer.MAX_VALUE) {
                        // 중간 경로에 버스정보가 없다면 최단경로 계산불가
                        distArr[j][k] = Math.min(distArr[j][k], distArr[j][i] + distArr[i][k]);
                    }
                }
            }
        }

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                if(distArr[i][j]==Integer.MAX_VALUE){
                    System.out.print(0 + " ");
                }else {
                    System.out.print(distArr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
