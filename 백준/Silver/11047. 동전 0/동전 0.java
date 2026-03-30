import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coins = new int[n]; // 동전의 가치들
		for(int i = 0;i<n;i++) {
			coins[i] = sc.nextInt();
		}
		int coinCnt = 0;
		for(int i=n-1;i>=0;i--) {
			if(k<coins[i]) {
				continue;
			}
			coinCnt += k/coins[i];
			k %= coins[i];
		}
		System.out.println(coinCnt);
	}
}
