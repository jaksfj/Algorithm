import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시들의 수
        int m = Integer.parseInt(br.readLine()); // 여행 계획 속한 도시 수
        int[] parents = new int[n+1]; // 대표 노드 저장 배열
        StringTokenizer st;

        // 대표 노드 초기화
        for (int i = 1; i < n+1; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int next = Integer.parseInt(st.nextToken());
                if(next==1) {
                    union(parents,j,i); // 해당 노드와 연결!
                }
            }
        }

        // 주어진 도시들이 연결되어있는지?
        st = new StringTokenizer(br.readLine());
        int firstCity = parents[Integer.parseInt(st.nextToken())]; // 첫번쨰 도시의 대표도시를 찾기
        boolean isConnect = false;
        for (int i = 1; i < m; i++) {
            int next = Integer.parseInt(st.nextToken());
            if(parents[next]!=firstCity){
                isConnect = false;
                break;
            }else{
                isConnect = true;
            }
        }

        if(isConnect){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    private static void union(int[] parents,int n1,int n2){
        int parent1 = find(parents,n1);
        int parent2 = find(parents,n2);
        int parent = Math.min(parent1,parent2);
        parents[parent1] = parent;
        parents[parent2] = parent;
    }

    private static int find(int[] parents,int n){
        if(parents[n]!=n){
            parents[n] = find(parents,parents[n]); // 지나가는 노드들마다 대표노드 설정
        }
        return parents[n];
    }
}
