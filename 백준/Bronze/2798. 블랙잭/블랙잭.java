import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 카드의 수
        int m = sc.nextInt(); // 카드 3장의 숫자 최대 합
        int[] cards = new int[n];
        // 카드 숫자 입력
        for (int i = 0; i < cards.length; i++) {
            cards[i] = sc.nextInt();
        }
        int result = isBlackJack(n,m,cards);
        System.out.println(result);
    }

    public static int isBlackJack(int n,int m,int[] cards){
        int sum = 0; // 카드의 합을 담아 놓을 곳
        int temp = 0; // m-sum 을 담아 놓을 곳
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    sum = cards[i] + cards[j] + cards[k];
                    if(sum==m){
                        return sum;
                    }

                    if(temp<sum && sum<m){
                        temp = sum;
                    }
                }
            }
        }
        return temp;
    }
}