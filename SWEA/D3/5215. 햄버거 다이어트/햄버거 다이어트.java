/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int[] scores;
	static int[] calories;
	static int maxCal, cnt, answer;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 1;i<=t;i++) {
			int maxCalorie = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 재료 수 
			int L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			int[] scores = new int[N];
			int[] calories = new int[N];
			for(int j = 0; j<N;j++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken()); // 맛 점수
				int calorie = Integer.parseInt(st.nextToken()); // 칼로리
				scores[j] = score;
				calories[j] = calorie;
			}
			int[] dp = new int[L+1]; // 최대 칼로리를 담는 dp 배열
			for(int j = 0;j<N;j++) {
				int score = scores[j]; // 맛 점수
				int calorie = calories[j]; // 칼로리
				for(int k = L;k>=calorie;k--) {
					dp[k] = Math.max(dp[k], dp[k-calorie]+score);
				}
			}
			System.out.println("#" + i + " " + dp[L]);
		}
	}
}