import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            HashMap<String, Integer> map = new HashMap<>();
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String s1 = sc.next();
                String s2 = sc.next();
                map.put(s2,map.getOrDefault(s2,0)+1);
                if(!list.contains(s2)){
                    list.add(s2);
                }
            }
            int answer = 1;
            for (String key : list) {
                answer *= (map.get(key)+1); // 각 옷을 입는 경우 + 안 입는 경우까지 더해주기
            }
            System.out.println(answer-1) ; // 모두 안입는 경우 빼주기
        }
    }
}
