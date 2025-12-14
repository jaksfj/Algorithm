import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int disconnectCnt = 0;
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i; // 먼저 자기 자신을 저장하는 대표노드 배열
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if(find(n1)!=find(n2)) {
                union(n1, n2); // 연결
            }else{
                disconnectCnt++; // 연결해제 연산
            }
        }
        HashSet<Integer> parentSet = new HashSet<>(); // 대표노드들
        for (int i = 1; i <= n; i++) {
            parentSet.add(find(i)); // 대표노드를 set 에 넣기
        }
        int answer = (parentSet.size()-1) + disconnectCnt; // 연결 연산수 + 연결해제 연산수
        System.out.println(answer);
    }

    static int find(int num){
        if(num!=parent[num]){
            return parent[num] = find(parent[num]);
        }
        return num;
    }

    static void union(int num1,int num2){
        int p1 = find(num1);
        int p2 = find(num2);
        if(p1!=p2){
            parent[p2] = p1; // 대표노드끼리 연결하기
        }
    }
}