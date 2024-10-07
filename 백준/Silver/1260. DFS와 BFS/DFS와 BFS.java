import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수 4
        int m = Integer.parseInt(st.nextToken()); // 간선의 수 5
        int v = Integer.parseInt(st.nextToken()); // 탐색 시작 번호 1
        ArrayList<Integer>[] list = new ArrayList[n+1];
        boolean[] checkNode = new boolean[n+1]; // 해당 노드를 거쳤는지 확인하는 배열

        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        String line;
        for(int i = 0;i < m;i++) {
            line = br.readLine();
            String[] numArr = line.split(" ");
            int num1 = Integer.parseInt(numArr[0]); // 첫번째 수
            int num2 = Integer.parseInt(numArr[1]); // 두번째 수
            list[num1].add(num2);
            list[num2].add(num1);
        }

        dfs(list,checkNode,v);

        checkNode = new boolean[n+1]; // 노드 확인 배열 초기화

        System.out.println();

        bfs(list,checkNode,v);
    }

    static void dfs(ArrayList<Integer>[] list,boolean[] checkNode, int node){
        checkNode[node] = true; // 해당 노드 거쳤기에 true 로 선언
        Collections.sort(list[node]);
        ArrayDeque<Integer> stack = new ArrayDeque<>(list[node]);

        System.out.print(node + " ");
        while(!stack.isEmpty()){
            int num = stack.pop();
            if(!checkNode[num]) {
                dfs(list, checkNode, num);
            }
        }
    }

    static void bfs(ArrayList<Integer>[] list,boolean[] checkNode,int node){
        checkNode[node] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            int num = queue.poll();
            System.out.print(num + " ");
            for (int number : list[num]) {
                if(!checkNode[number]){
                    checkNode[number] = true;
                    queue.add(number);
                }
            }
        }
    }
}
