import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 순열의 수 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int select = Integer.parseInt(st.nextToken());
        ArrayList<Integer> group = new ArrayList<>(); // 맨 첫번째 순열
        for(int i = 1;i<=n;i++) {
            group.add(i);
        }
        if(select==1){
            long k = Long.parseLong(st.nextToken()); // k번째 순열찾기
            k--; // 순열의 k 는 0 based index 이므로
            for(int i=0;i<n;i++) {
                int selectIndex = (int)(k / factorial(n -i -1)); // 해당 위치에 어떤 수를 선택해야 할지 결정
                bw.write(group.get(selectIndex) + " ");
                k %= factorial(n-i-1); // 순열의 그룹화
                group.remove(selectIndex);
            }
            bw.flush();
        }else if(select==2){
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long answer = 1; // zero based index 의 순열이지만, 나중에 더해주는 것 생략하기 위해서 1로 설정
            for(int i = 0;i<n;i++){
                int cnt = 0;
                for (Integer integer : group) {
                    if (arr[i] > integer) {
                        cnt++;
                    }
                }
                answer += cnt * factorial(n-1-i);
                group.remove(Integer.valueOf(arr[i]));
            }
            bw.write(answer+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static long factorial(int n){
        if(n>0){
            return n*factorial(n-1);
        }else{
            return 1;
        }
    }
}
