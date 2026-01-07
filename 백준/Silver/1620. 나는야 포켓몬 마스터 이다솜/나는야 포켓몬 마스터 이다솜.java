import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer,String> numberMap = new HashMap<>(); // 번호 -> 이름
        Map<String,Integer> stringMap = new HashMap<>(); // 이름 -> 번호
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            numberMap.put(i,name);
            stringMap.put(name,i);
        }
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            // 해당 입력이 숫자인지 문자열인지 파악해야함
            if(Character.isDigit(input.charAt(0))){
                System.out.println(numberMap.get(Integer.parseInt(input)));
            }else{
                System.out.println(stringMap.get(input));
            }
        }
    }
}
