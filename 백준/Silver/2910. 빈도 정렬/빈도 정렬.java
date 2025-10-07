import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빈도 정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        HashMap<Long,Integer> map = new HashMap<>(); // num, cnt 로 key value 설정
        Queue<Long> queue = new ArrayDeque<>();
        List<Number> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long num = Integer.parseInt(st.nextToken());
            if(!map.containsKey(num)){
                queue.offer(num);
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        int order = 0;
        while(!queue.isEmpty()){
            Long num = queue.poll();
            list.add(new Number(num,map.get(num),order));
            order++;
        }
        Collections.sort(list);
        for(Number num : list){
            for (int i = 0; i < num.cnt; i++) {
                System.out.print(num.num + " ");
            }
        }
    }

    static class Number implements Comparable<Number>{
        long num;
        int cnt;
        int order;

        Number(long num, int cnt, int order){
            this.num = num;
            this.cnt = cnt;
            this.order = order;
        }

        @Override
        public int compareTo(Number o) {
            if(this.cnt == o.cnt){
                return this.order - o.order;
            }
            return o.cnt - this.cnt;
        }
    }
}
