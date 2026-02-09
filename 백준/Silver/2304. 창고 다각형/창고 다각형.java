import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Pillar> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int h = sc.nextInt();
            list.add(new Pillar(l,h));
        }
        Collections.sort(list); // 인덱스 기준으로 오름차순 정렬
        // 가장 높은 높이 구하기
        int max = 0;
        int maxIndex = 0;
        for(int i = 0;i<list.size();i++){
            Pillar p = list.get(i);
            if(max<p.value){
                max = p.value;
                maxIndex = i;
            }
        }
        int answer = max; // 탐색 전에 max 넓이 더해주기 (한칸 x max 높이)
        // maxIndex 를 기준으로 왼쪽 오른쪽 탐색
        // 왼쪽끝(0) -> maxIndex
        max = 0;
        for (int i = 0; i < maxIndex; i++) {
            Pillar p = list.get(i);
            if(max<p.value){
                max = p.value;
            }
            answer += (list.get(i+1).index-list.get(i).index) * max;
        }

        // 오른쪽끝(list.size()) -> maxIndex
        max = 0;
        for (int i = list.size()-1; i>maxIndex; i--) {
            Pillar p = list.get(i);
            if(max<p.value){
                max = p.value;
            }
            answer += (list.get(i).index-list.get(i-1).index) * max;
        }
        System.out.println(answer);
    }

    static class Pillar implements Comparable<Pillar>{
        int index;
        int value;
        Pillar(int index, int value){
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pillar o){
            return Integer.compare(this.index, o.index);
        }
    }
}
