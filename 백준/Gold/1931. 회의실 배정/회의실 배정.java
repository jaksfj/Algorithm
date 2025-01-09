import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 회의 개수
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.endTime==o2.endTime){ // 종료시간이 같으면 시작시간이 빠른 순으로 정렬
                    return o1.startTime-o2.startTime;
                }else{ // 종료시간이 다르면
                    return o1.endTime-o2.endTime; // 종료시간이 빠른 순으로 정렬
                    // 만약 (2,2) 와 (1,2) 가 존재한다면 종료시간이 같지만 (1,2)가 불가능할 수 있기 때문이다.
                    // (1,2) 가 먼저 나오고 (2,2) 가 나오도록 하는 것!
                }
            }
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            pq.offer(new Node(startTime,endTime));
        }

        int cnt = 0;
        int end = -1;
        while(!pq.isEmpty()){
            Node next = pq.poll();
            if(next.startTime >= end){
                cnt++;
                end = next.endTime; // 종료시간 갱신
            }
        }

        System.out.println(cnt);
    }

    static class Node{
        int startTime;
        int endTime;

        Node(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
