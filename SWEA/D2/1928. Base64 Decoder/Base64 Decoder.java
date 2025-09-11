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
import java.util.Arrays;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        char[] base64 = new char[64];
        // A~Z
        for(int i = 0;i<26;i++){
        	base64[i] = (char)(i+65);
        }
        // a~z
        for(int i = 26;i<52;i++){
        	base64[i] = (char)(i+71);
        }
        // 0~9
        for(int i = 52;i<62;i++){
            String s = String.valueOf(i-52);
        	base64[i] = s.charAt(0);
        }
        base64[62] = '+';
        base64[63] = '/';
		sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.print("#" + test_case + " ");
            String str = sc.nextLine();
            for(int i = 0;i<str.length();i+=4){
                StringBuilder sb = new StringBuilder(); // 문자 담기
                for(int j = i;j<i+4;j++){ // 문자 4개씩 분별
                	sb.append(String.valueOf(str.charAt(j)));
                }
                int[] numbers = new int[4];
                for(int j = 0;j<4;j++){
                	for(int k= 0;k<64;k++){
                    	if(sb.charAt(j) == base64[k]){
                        	numbers[j] = k;
                            break;
                        }
                    }
                }
                // 8비트의 이진수 문자열을 순서대로 버퍼에 넣기
                sb = new StringBuilder();
                for(int q = 0;q<4;q++){
                     sb.append(String.format("%6s", Integer.toBinaryString(numbers[q])) // 6자리로
                     .replace(' ', '0'));
                }
                
                for(int q = 0;q<24;q+=8){
                	String binary = sb.substring(q,q+8);
                    int code = Integer.parseInt(binary,2);
                    System.out.print((char)code);
                }
            }
            System.out.println();
		}
	}
}