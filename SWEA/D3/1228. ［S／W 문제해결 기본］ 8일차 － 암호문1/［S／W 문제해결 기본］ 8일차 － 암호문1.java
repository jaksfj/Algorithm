import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        StringTokenizer st;

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int[] arr = new int[1000];
            int n = sc.nextInt(); // 암호문의 길이
            for(int i = 0;i<n;i++){
            	arr[i] = sc.nextInt(); // 배열에 순서대로 값 담기
            }
            int cmdCnt = sc.nextInt(); // 명령어 개수
            sc.nextLine(); // 버퍼 비우기
            String str = sc.nextLine();
            st = new StringTokenizer(str,"I"); // 명령어를 토큰으로 나눠 담는 것
            for(int i = 0;i<cmdCnt;i++){
                String cmd = st.nextToken();
                StringTokenizer s = new StringTokenizer(cmd); // 명령어 자체를 하나의 토큰형태로 나누기
                int startIndex = Integer.parseInt(s.nextToken()); // 삽입할 시작 인덱스 위치
                int codeCnt = Integer.parseInt(s.nextToken()); // 삽입할 암호 개수
                // 먼저 해당 인덱스로부터 codeCnt만큼 뒤로 한칸씩 다 옮기기.
                // 옮기려면 맨 뒤에있는 요소부터 뒤로 옮겨야함.
                // n-1 번 인덱스부터 하나씩 옮겨가면서 codeCnt 만큼 뒤에서부터 옮기기
                int curIndex = n-1; // 마지막 코드가 있는 인덱스 부분
                while(startIndex<=curIndex){
                    arr[curIndex+codeCnt] = arr[curIndex]; // 마지막 코드 부분에서부터 strCnt 만큼 뒤로 값 밀기
                  	arr[curIndex] = 0; // 뒤로 밀고 해당 자리는 0으로 초기화
                   	curIndex--; // 배열 끝에서부터 한칸씩 앞 인덱스를 가리키며 뒤로 옮기기
                }
                // 0으로 설정해놓은 자리 순서대로 값 채우기
                for(int j = startIndex;j<startIndex+codeCnt;j++){
                	arr[j] = Integer.parseInt(s.nextToken());
                }
                n += codeCnt; // 배열의 끝인덱스를 갱신해주기.
            }
            System.out.print("#" + test_case + " ");
            for(int i = 0;i<10;i++){
            	System.out.print(arr[i] + " ");
            }
            System.out.println();
		}
	}
}