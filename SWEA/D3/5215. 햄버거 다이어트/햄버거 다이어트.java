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
import java.util.Scanner;
import java.io.FileInputStream;
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
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        StringTokenizer st;
        sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(sc.nextLine());
            cnt = Integer.parseInt(st.nextToken()); // 재료 수
            maxCal = Integer.parseInt(st.nextToken()); // 전체 칼로리 수
            answer = 0; // 정답 점수
			scores = new int[cnt];
			calories = new int[cnt];
            for(int i = 0;i<cnt;i++){
				st = new StringTokenizer(sc.nextLine());
            	scores[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0,0);
            System.out.println("#" + test_case + " " + answer);
        }
	}
    
    static void dfs(int index,int totalCal, int totalScore){ // 인덱스, 칼로리합, 점수합
    	if(totalCal>maxCal){ // 최대 칼로리보다 넘어가면 탐색 중단
        	return;
        }
        
         // 현재까지의 점수가 최대 점수보다 크면 점수 갱신
        if(answer<totalScore){
        	answer = totalScore;
        } 
        
        if(index==cnt){ // 모두 탐색했으므로 탐색 중단
            return;
        }
       
        dfs(index+1,totalCal,totalScore); // 이번 재료 미선택
        dfs(index+1,totalCal+calories[index],totalScore+scores[index]); // 이번재료 선택
    }
}