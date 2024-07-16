import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        // 1. StringTokenizer 로 풀기
//        StringTokenizer st = new StringTokenizer(str," ");
//        System.out.println(st.countTokens());

        // 2. 조건 넣어서 풀기
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==' '){
                cnt++;
            }
        }

        // str 의 첫번째 단어 또는 마지막 단어가 공백인 경우
        if(str.charAt(0)==' ' && str.charAt(str.length()-1) == ' '){
            cnt--;
        }else if(str.charAt(0)!=' ' && str.charAt(str.length()-1) != ' '){
            cnt++; // str 의 첫번째 단어와 마지막 단어가 공백이 아닌경우
        }

        System.out.println(cnt);
    }
}
