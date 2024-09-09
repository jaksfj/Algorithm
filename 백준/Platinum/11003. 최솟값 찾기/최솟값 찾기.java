import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 숫자의 개수
        int l = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우의 크기
        st = new StringTokenizer(br.readLine());
        Deque<Node> slidingWindow = new ArrayDeque<>(); // 슬라이딩 윈도우
        for (int i = 0; i < n; i++) {
            // 넣는 요소가 바로 위의 요소보다 크면 last 에서 poll
            int value = Integer.parseInt(st.nextToken());
            while(!slidingWindow.isEmpty() && slidingWindow.peekLast().value > value){
                slidingWindow.pollLast();
            }

            // 요소 넣기
            slidingWindow.add(new Node(i,value));

            // 만약 슬라이딩 윈도우의 범위를 벗어나면 first 에서 poll
            if(slidingWindow.peekFirst().index <= i-l){
                slidingWindow.pollFirst();
            }

            bw.write(slidingWindow.peekFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node{
        int index;
        int value;
        Node(int index,int value){
            this.index = index;
            this.value = value;
        }
    }
}
