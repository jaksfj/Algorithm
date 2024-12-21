import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 수열의 길이
        int[] arr = new int[n]; // 각 인덱스에 해당하는 값
        int[] answerArr = new int[n]; // 정답 배열
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0); // 먼저 0번째 인덱스를 넣어준다.

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[i]>arr[stack.peek()]){ // 오큰수를 만나면 (인덱스를 앞으로 이동하면서 저장하는 방식)
                answerArr[stack.pop()] = arr[i]; // 정답배열에 저장
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){ // 모든 인덱스 다 돌았는데도 남아있다면 -1 처리
            answerArr[stack.pop()] = -1;
        }

        for (int i = 0; i < n; i++) {
            bw.write(answerArr[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}