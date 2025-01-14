import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { // 유니온 파인드
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 최대 숫자
        int m = Integer.parseInt(st.nextToken()); // 연산 횟수
        int[] parents = new int[n+1];

        // 대표노드 배열 설정
        for (int i = 1; i <= n; i++) {
            parents[i] = i; // 자기 자신을 대표노드로 설정
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int uf = Integer.parseInt(st.nextToken()); // union or find
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if(uf==0){ // union 연산
                union(parents,n1,n2);
            }else{ // 서로 같은 집합인지 확인하는 연산
                isSame(parents,n1,n2);
            }
        }
    }

    private static void union(int[] parents,int n1,int n2){
        int parent1 = find(parents,n1);
        int parent2 = find(parents,n2);
        int parentNode = Math.min(parent1, parent2); // 더 작은 숫자가 더 높은 대표숫자임
        // 대표노드끼리 연결
        parents[parent1] = parentNode;
        parents[parent2] = parentNode;
    }

    private static int find(int[] parents,int n){
        if(parents[n]!=n){ // 대표 노드랑 같지 않다면
            parents[n] = find(parents,parents[n]); // 지나치는 노드들 대표노드 값으로 설정하기!
        }
        return parents[n];
    }

    private static void isSame(int[] parents,int n1,int n2){
        int first = find(parents,n1);
        int second = find(parents,n2);
        if(first==second){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}