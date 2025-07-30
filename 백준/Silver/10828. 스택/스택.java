

import java.io.*;
import java.util.StringTokenizer;

public class Main { // 스택
    static final int MAX_LEN = 10000;
    static int top = -1;
    static int[] stack = new int[10000]; // 최대크기 10000
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < MAX_LEN; i++) {
            stack[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int value;
            switch(command){
                case "push":
                    value = Integer.parseInt(st.nextToken());
                    push(stack,value);
                    break;
                case "pop":
                    bw.write(pop(stack)+"\n");
                    break;
                case "size":
                    bw.write((top+1)+"\n");
                    break;
                case "empty":
                    if(isEmpty()){
                        bw.write(1 + "\n");
                    }else{
                        bw.write(0 + "\n");
                    }
                    break;
                case "top":
                    bw.write(getTop(stack)+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void push(int[] stack, int value) {
        if(MAX_LEN<=top+1){ // 배열 크기 벗어낫으므로 push 불가
            return;
        }
        top++; // 최상단 포인터 증가
        stack[top] = value;
    }

    private static int pop(int[] stack) {
        if(isEmpty()){
            return -1;
        }
        return stack[top--];
    }

    private static int getTop(int[] stack) {
        if(isEmpty()){
            return -1;
        }
        return stack[top];
    }

    private static boolean isEmpty() {
        return top==-1;
    }
}
