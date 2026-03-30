import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] dp = new int[x+1];
		for(int i = 1;i<=x;i++) {
			// 2로 나눠지면 2로 나누고, 3으로 나눠지면 3으로 나누고, 아니면 1을 뺴라
			// 그렇게 해서 1을 만들 수 있는 연산 횟수의 최솟값
			if(i%2==0 && i%3==0) {
				dp[i] = Math.min(dp[i/3],dp[i/2])+1;
			}else if(i%2==0) {
				dp[i] = Math.min(dp[i-1], dp[i/2])+1;
			}else if(i%3==0) {
				dp[i] = Math.min(dp[i-1],dp[i/3])+1;
			}else if(i>1){
				dp[i] = dp[i-1]+1;
			}
		}
		System.out.print(dp[x]);
	}
}
