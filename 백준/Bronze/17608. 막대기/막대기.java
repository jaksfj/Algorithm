import java.util.ArrayDeque;
import java.util.Scanner;

public class Main { // 막대기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            stack.push(sc.nextInt());
        }
        int max = stack.pop();
        int answer = 1; // 처음에 보이는 막대 수 추가해주기
        while(!stack.isEmpty()){
            int topValue = stack.peek();
            if(max<topValue) {
                max = topValue;
                answer++;
            }
            stack.pop();
        }
        System.out.println(answer);
    }
}
