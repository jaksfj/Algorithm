import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> deck = new ArrayDeque<>();
        int deckSize = sc.nextInt();
        // 덱 초기화
        for (int i = 0; i < deckSize; i++) {
            deck.add(i+1);
        }

        while(deck.size()>1){
            deck.poll(); // 가장 위에 있는 카드 버리기
            if(deck.size()==1){
                break;
            }
            deck.add(deck.peek()); // 덱 맨 아래로 넣기
            deck.poll();
        }
        System.out.println(deck.peek());
    }
}
