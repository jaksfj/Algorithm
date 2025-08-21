

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { // 최솟값 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayDeque<Node> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        deque.offer(new Node(1,arr[1]));
        bw.write(deque.peekFirst().value + " ");
        int index = 2;
        while(!deque.isEmpty() && index <= n){
            while(!deque.isEmpty() && deque.peekLast().value>=arr[index]){ // 만약 들어갈 자리의 수보다 크면 제거
                deque.pollLast();
            }
            deque.offer(new Node(index,arr[index]));
            if(index-deque.peekFirst().index>=l){
                deque.pollFirst();
            }
            bw.write(deque.peekFirst().value + " ");
            index++;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int index;
        int value;

        Node(int index,int value){
            this.index = index;
            this.value = value;
        }
    }
}
