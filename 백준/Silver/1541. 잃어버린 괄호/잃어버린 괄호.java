

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String formula = br.readLine();
        char[] charArr = formula.toCharArray();
        StringTokenizer st;
        int sum = 0;
        if(charArr[0]=='-'){ // -로 시작한다면
            // -로 먼저 나누고 각 식을 더한 후 전부 뺀게 답
            st = new StringTokenizer(formula,"-");
            while(st.hasMoreTokens()){
                sum -= sum(st.nextToken());
            }
        }else{ // +로 시작한다면
            // sum에 먼저 첫 요소를 더하고 나머지를 전부 빼기
            st = new StringTokenizer(formula,"-");
            sum += sum(st.nextToken());
            while(st.hasMoreTokens()){
                sum -= sum(st.nextToken());
            }
        }
        System.out.println(sum);
    }

    static int sum(String str){
        StringTokenizer st = new StringTokenizer(str,"+");
        int result = 0;
        while(st.hasMoreTokens()){
            result += Integer.parseInt(st.nextToken());
        }
        return result;
    }
}
