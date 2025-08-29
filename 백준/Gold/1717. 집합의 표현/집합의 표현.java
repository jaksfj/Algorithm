

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        // 자기 자신의 인덱스를 대표노드로 설정
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int select = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(select==0){ // union : 집합 합치기
                union(a,b);
            }else{ // find : 대표노드 찾아서 서로 같은 대표노드인지 확인하기
                if(find(a)==find(b)){
                    bw.write("YES" + "\n");
                }else{
                    bw.write("NO" + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int num){ // 대표 노드 찾기
        if(num==arr[num]){
            return num;
        }else{
            return arr[num] = find(arr[num]);
        }
    }

    static void union(int n1,int n2) {
        int a = find(n1);
        int b = find(n2);
        if(a<b){
            arr[b] = a;
        }else{
            arr[a] = b;
        }
    }
}
