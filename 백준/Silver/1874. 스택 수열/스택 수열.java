import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수의 개수
        int[] arr = new int[n];
        ArrayList<String> list = new ArrayList<>(); // +,- 넣는 리스트
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // 만들기 위한 수열
        }

        Stack<Integer> stack = new Stack<>();
        int p = 0; // 만들기 위한 수열의 인덱스를 가리키는 포인터
        int i = 1; // 1~n 까지 순서대로 넣을 수, push 넣는 수 지표로도 사용
        boolean isValid = true;
        while (p < n) {
            if (stack.isEmpty()) { // 스택이 비었을 때 push
                stack.push(i);
                list.add("+");
                i++;
            } else {
                if (stack.peek() == arr[p]) { // top 이 기리키는 수열 포인터의 값과 같을 때
                    stack.pop();
                    list.add("-");
                    p++;
                } else if(i==n+1 && stack.peek()!=arr[p]){
                    // 만약 push 를 다했을 때 pop 하는 과정에서 top 이 가리키는 수열 포인터 값과 다를때
                    isValid = false;
                    break;
                } else { // 수열 포인터의 값과 같지 않을 때
                    stack.push(i);
                    list.add("+");
                    i++;
                }
            }
        }

        if(isValid){
            for (String c : list) {
                System.out.println(c);
            }
        }else{
            System.out.println("NO");
        }
    }
}