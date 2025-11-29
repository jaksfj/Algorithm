import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] cnts;
    static String[] animals;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList[n+1];
        for(int i = 1;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        cnts = new int[n+1];
        animals = new String[n+1];

        for(int i = 2;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            String animal = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            int toward = Integer.parseInt(st.nextToken());
            // 단방향 그래프 (부모 -> 자식)
            list[toward].add(i);
            animals[i] = animal;
            cnts[i] = cnt;
        }
        animals[1] = "S";
        cnts[1] = 0;
        long answer = dfs(1);
        System.out.println(answer);
    }

    static long dfs(int cur){
        long sum = 0;

        for(int next : list[cur]){
            sum += dfs(next);
        }

        if(animals[cur].equals("S")){ // 양이면 더해주기
            return sum + cnts[cur];
        }else{ // 늑대이면 빼주기 (뺄 때 0보다 작으면 0으로 반환하기)
            return Math.max(sum-cnts[cur],0);
        }
    }
}
