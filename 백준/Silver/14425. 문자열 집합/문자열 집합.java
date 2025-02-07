import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 문자열의 수
        int m = Integer.parseInt(st.nextToken()); // 비교할 문자열 수
        Node node = new Node();
        for(int i =0;i<n;i++){
            Node now = node; // 현재 문자
            char[] charArr = (br.readLine()).toCharArray();
            for(int j = 0;j<charArr.length;j++){
                char c = charArr[j];
                if (now.alphabets[c - 'a'] == null) { // 없는 알파벳 나오면
                    now.alphabets[c-'a'] = new Node(); // 새로운 경로 생성
                }
                now = now.alphabets[c-'a'];
                if(j==charArr.length-1){ // 마지막 단어라면
                    now.isEnd = true;
                }
            }
        }

        int cnt = 0; // 집합 s에 포함되어있는 문자열의 수
        for(int i = 0;i<m;i++){
            Node now = node;
            char[] charArr = (br.readLine()).toCharArray();
            for(int j = 0;j<charArr.length;j++){
                char c = charArr[j];
                if(now.alphabets[c-'a']==null){
                    break; // 모르는 단어 나오면 찾기 중단
                }
                now = now.alphabets[c-'a'];
                if(j==charArr.length-1 && now.isEnd){ // 마지막 단어라면 완벽하게 다 맞는 것으로 확인됨
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    private static class Node{
        Node[] alphabets = new Node[26]; // 알파벳의 크기
        boolean isEnd = false; // 해당 문자열의 마지막인지?
    }
}
