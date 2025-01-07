import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { // 이진탐색
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 강의 수
        int m = Integer.parseInt(st.nextToken()); // 블루레이 수
        int[] lessons = new int[n]; // 레슨 시간이 담긴 배열
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0; // 블루레이 하나에 들어갈 수 있는 최소한의 시간 (레슨 시간 중 가장 긴 시간)
        int end = 0; // 블루레이 하나에 들어갈 수 있는 최대한의 시간 (모든 레슨 시간의 합)
        for (int i = 0; i < n; i++) {
            if(start<lessons[i]){
                start = lessons[i];
            }
            end += lessons[i];
        }

        // m 개의 블루레이에 들어갈 수 있는 최소한의 시간 구하기
        while(start<=end){
            int cnt = 0; // 블루레이 수
            int sum = 0; // 블루레이에 들어가는 레슨 시간의 합
            int mid = (start + end) / 2; // 한 블루레이에 들어가는 시간 기준
            for (int i = 0; i < n; i++) {
                if(sum + lessons[i] > mid){
                    sum = 0; // 블루레이 시간 초기화
                    cnt++; // 새로운 블루레이 추가
                }
                sum += lessons[i]; // 블루레이에 시간 추가
            }

            if(sum!=0){ // 아직 시간이 남아있다면
                cnt++;
            }

            if(cnt>m){ // 더 많은 블루레이가 필요하다면 더 긴 시간 범위에서 찾기
                start = mid+1;
            }else{ // 더 적은 블루레이가 사용된다면 더 작은 시간 범위에서 찾기
                end = mid-1;
            }
        }

        System.out.println(start);
    }
}