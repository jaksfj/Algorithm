import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int startPointer = 1;
        int endPointer = 1;
        int sum = 1; // startPointer 부터 endPointer 까지의 수의 합
        int cnt = 1; // 두 포인터가 n 자체일 때 경우 1추가 했음
        while(endPointer!=n){ // endpointer 가 n 이 되는 경우는 이미 sum 에 들어있음. ex) ep : 15 일 때 이미 끝
            if(sum>n){
                sum-=startPointer; // 앞의 포인터 값 전체 합에서 삭제하기
                startPointer++;
            }else if(sum<n){
                endPointer++;
                sum+=endPointer;
            }else { // sum 과 n 이 같을 때
                cnt++;
                endPointer++;
                sum+=endPointer;
            }
        }

        System.out.println(cnt);
    }
}
