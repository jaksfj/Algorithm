import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 파티 수
        ArrayList<Integer>[] parties = new ArrayList[m]; // 파티
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()); // 진실을 알고있는 사람 수
        int[] parents = new int[n+1]; // 0으로 초기화
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            parties[i] = new ArrayList<>();
        }

        if(p==0){ // 진실을 아는 사람이 없을 경우
            System.out.println(m); // 파티 수 출력
        }else {
            int[] know = new int[p+1]; // 진실을 아는 사람들
            // 진실을 아는 사람들 저장
            for (int j = 0; j < p; j++) {
                know[j] = Integer.parseInt(st.nextToken());
            }

            // 파티 데이터 저장
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int peopleCnt = Integer.parseInt(st.nextToken()); // 파티에 참여하는 사람 수
                for (int j = 0; j < peopleCnt; j++) {
                    int num = Integer.parseInt(st.nextToken()); // 파티에 참여하는 사람 번호
                    parties[i].add(num);
                }
            }

            // 파티 데이터에 있는 사람들 그룹화하기
            for (int i = 0; i < m; i++) {
                int first = parties[i].get(0); // 각 파티에서 첫번째 사람
                for (int j = 1; j < parties[i].size(); j++) {
                    union(parents,first,parties[i].get(j)); // 첫번째 사람과 union 하기! (그룹화)
                }
            }

            // 파티데이터와 진실을 알고있는 사람과 비교하면서 파티가 가능한지 유무 확인
            int cnt = 0; // 파티 가능 수
            for (int i = 0; i < m; i++) {
                boolean isPossible = true;
                for (int j = 0; j < know.length; j++) {
                    if(find(parents,parties[i].get(0)) == find(parents,know[j])){
                        isPossible = false;
                        break;
                    }
                }
                if(isPossible){
                    cnt++;
                }
            }

            System.out.println(cnt);
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
            parents[n] = find(parents,parents[n]);
        }
        return parents[n];
    }
}
