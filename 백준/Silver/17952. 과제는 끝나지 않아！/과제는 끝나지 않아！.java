import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { // 과제는 끝나지 않아!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        ArrayDeque<Assignment> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if(x==1){
                int score = Integer.parseInt(st.nextToken());
                int minute = Integer.parseInt(st.nextToken());
                stack.push(new Assignment(score,minute));
            }

            if(!stack.isEmpty()){
                Assignment cur = stack.peek(); // 가장 최근 과제 확인
                cur.minute--; // 이 분에 1분 작업 수행
                if (cur.minute == 0) { // 남은 시간이 0이 되면
                    answer += cur.score;
                    stack.pop(); // 스택에서 제거
                }
            }
        }
        System.out.println(answer);
    }

    static class Assignment{
        int score;
        int minute;

        Assignment(int score, int minute) {
            this.score = score;
            this.minute = minute;
        }
    }
}

