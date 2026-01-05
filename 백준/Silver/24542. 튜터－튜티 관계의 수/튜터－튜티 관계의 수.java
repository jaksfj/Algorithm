import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u,v);
        }

        long[] arr = new long[n+1]; // 대표노드의 수를 저장하는 배열
        for (int i = 1; i <= n; i++) {
            arr[find(i)]++;
        }

        long answer = 1;
        for (int i = 1; i <= n; i++) {
            if(arr[i]!=0){
                answer = (answer * arr[i])%1000000007;
            }
        }
        System.out.println(answer);
    }
    static int find(int n){
        if(parent[n]!=n){
            return parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    static void union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1>p2){ // p1 이 작은 수가 되도록
            int tmp = p2;
            p2 = p1;
            p1 = tmp;
        }

        if(p1!=p2){
            parent[p2] = p1;
        }
    }
}
