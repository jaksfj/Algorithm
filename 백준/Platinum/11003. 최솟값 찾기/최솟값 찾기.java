import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int l = Integer.parseInt(st.nextToken()); // 윈도우 크기
        ArrayDeque<Node> window = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int nextNode = Integer.parseInt(st.nextToken());
            while(!window.isEmpty() && window.getLast().value >= nextNode) { // 윈도우의 last 쪽 요소가 들어가는 노드의 값보다 작아야 한다.
                // 윈도우가 비어있지 않은 상태일 때 진행해야한다.
                window.removeLast();
            }

            window.offer(new Node(i,nextNode));

            if (window.getLast().index - window.getFirst().index >= l) { // 윈도우의 크기를 초과하면 안되므로 앞 요소 삭제
                window.removeFirst();
            }

            bw.write(window.getFirst().value + " ");
        }
        bw.flush();
    }

    private static class Node{
        int index;
        int value;
        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}
