import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args){ 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[] number = new boolean[n+1]; // 바닥에 존재하는 논문
		ArrayList<Integer> contLen = new ArrayList<>(); // 없는 논문들의 연속되는 길이
		ArrayList<Integer> gap = new ArrayList<>(); // 없는 논문들 사이의 간격
		for(int i = 0;i<m;i++) {
			int num = sc.nextInt();
			number[num]	= true;
		}
		int cnt = 0;
		for(int i = 1;i<=n;i++) {
			if(!number[i]) {
				cnt++;
				continue;
			}else if(number[i] && cnt>0){
				contLen.add(cnt);
			}
			cnt = 0;
		}
		if(cnt > 0) { // 끝나남은 수 채워주기
			contLen.add(cnt);
		}
		if (contLen.isEmpty()) {
            System.out.println(0);
            return;
        }
		
		boolean prevExist = true;
		for(int i = 1;i<=n;i++) {
			if(number[i]) { // 수가 존재한다면
				if(!prevExist) { // 이전에 수가 존재하지 않았다면
					gap.add(1);
					prevExist = true;
				} else if(!gap.isEmpty()) { // 이전에 수가 존재했다면
					int last = gap.size()-1;
					if(i==n && gap.get(last)>1) {
						gap.remove(last);
						break;
					}
					gap.set(last, gap.get(last)+1); // 이미 보고있는 간격에 1 더해주기
				}
			}else {
				prevExist = false;
			}
		}
		
		int[] dp = new int[contLen.size()];
		for(int i = 0;i<contLen.size();i++) {
			dp[i] = Integer.MAX_VALUE; // 최소를 구해야 하므로 최대로 설정해놓기
			int lenSum = 0;
			int gapSum = 0;
			for(int j=i;j>=0;j--) {
				lenSum += contLen.get(j); // 없는 페이지의 연속 길이 더해주기
				if(j<i) {
					gapSum += gap.get(j); // 간격도 더해주기
				}
				if(j==0) {
					dp[i] = Math.min(dp[i], 5 + 2*(lenSum + gapSum)); // 전체 다 묶어서 계산
				}else {
					dp[i] = Math.min(dp[i], dp[j-1]+(5 + 2*(lenSum + gapSum))); // 부분으로 묶어서 계산
				}
			}
		}
		System.out.println(dp[contLen.size()-1]);
	}
}
