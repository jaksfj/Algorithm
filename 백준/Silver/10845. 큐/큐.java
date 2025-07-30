

import java.io.*;
import java.util.StringTokenizer;

public class Main { // 큐
    static final int MAX_LEN = 10000;
    static int[] queue = new int[MAX_LEN]; // 최대크기 10000
    static int start = 0;
    static int end = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int value;
            switch(command) {
                case "push":
                    value = Integer.parseInt(st.nextToken());
                    push(queue, value);
                    break;
                case "pop":
                    bw.write(pop(queue) + "\n");
                    break;
                case "size":
                    bw.write((Math.abs(start-end)%MAX_LEN) + "\n");
                    break;
                case "empty":
                    if (isEmpty()) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;
                case "front":
                    if (isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(front() + "\n");
                    }
                    break;
                case "back":
                    if(isEmpty()){
                        bw.write(-1 + "\n");
                    }else {
                        bw.write(back() + "\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void push(int[] stack, int value) {
        stack[end] = value;
        end = (end + 1) % MAX_LEN; // end 인덱스 업데이트
    }

    private static int pop(int[] stack) {
        if(isEmpty()){
            return -1;
        }
        int value = queue[start];
        start = (start + 1) % MAX_LEN;
        return value;
    }

    private static boolean isEmpty() {
        return end == start;
    }

    private static int front() {
        return queue[start];
    }

    private static int back() {
        return queue[end-1];
    }
}
