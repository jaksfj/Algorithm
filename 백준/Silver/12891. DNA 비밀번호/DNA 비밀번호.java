import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        int p = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        char[] arr = (br.readLine()).toCharArray(); // 문자형 배열로 변환
        int[] dnaCnt = new int[4]; // 최소 ACGT 개수
        int[] cntArr = new int[4]; // 문자형 배열의 ACGT 수를 새는 배열
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            dnaCnt[i] = Integer.parseInt(st.nextToken()); // 수 입력
        }

        // 받은 DNA 문자열의 ACGT 수 새기
        for (int i = 0; i < s; i++) {
            if(arr[i]=='A'){
                cntArr[0]++;
            }else if(arr[i]=='C'){
                cntArr[1]++;
            }else if(arr[i]=='G'){
                cntArr[2]++;
            }else{
                cntArr[3]++;
            }
        }

        boolean isValid = true; // 최소한의 ACGT 수를 충족하는지 확인
        int cnt = 0; // 만들 수 있는 비밀번호의 종류 수

        for (int i = 0; i < 4; i++) {
            if(dnaCnt[i]>cntArr[i]){
                isValid = false;
                break;
            }
        }

        if(isValid){
            Queue<Character> window = new ArrayDeque<>();
            int[] currentCnt = new int[4];
            for (int i = 0; i < s; i++) {
                window.offer(arr[i]); // 윈도우에 문자 넣기
                if(arr[i]=='A'){
                    currentCnt[0]++;
                }else if(arr[i]=='C'){
                    currentCnt[1]++;
                }else if(arr[i]=='G'){
                    currentCnt[2]++;
                }else{
                    currentCnt[3]++;
                }
                if(window.size()==p){ // 윈도우의 최대 크기와 같아졌다면, 최소 ACGT 수 만족여부 확인
                    boolean isDNA = true;
                    for (int j = 0; j < 4; j++) {
                        if(dnaCnt[j]>currentCnt[j]){
                            isDNA = false;
                            break;
                        }
                    }
                    if(!isDNA){ // 만약 충족하지 않는다면
                        char c = window.poll();
                        if(c=='A'){
                            currentCnt[0]--;
                        }else if(c=='C'){
                            currentCnt[1]--;
                        }else if(c=='G'){
                            currentCnt[2]--;
                        }else{
                            currentCnt[3]--;
                        }
                    }else{ // 충족한다면
                        cnt++;
                        char c = window.poll();
                        if(c=='A'){
                            currentCnt[0]--;
                        }else if(c=='C'){
                            currentCnt[1]--;
                        }else if(c=='G'){
                            currentCnt[2]--;
                        }else{
                            currentCnt[3]--;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
