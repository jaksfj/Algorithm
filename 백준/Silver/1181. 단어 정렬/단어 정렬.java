import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> wordSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            wordSet.add(br.readLine());
        }

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() != o2.length()) { // 문자열 길이가 다르면 짧은 것 우선
                return o1.length() - o2.length();
            } else { // 길이가 같으면 사전순 정렬
                return o1.compareTo(o2);
            }
        });

        pq.addAll(wordSet);

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}

