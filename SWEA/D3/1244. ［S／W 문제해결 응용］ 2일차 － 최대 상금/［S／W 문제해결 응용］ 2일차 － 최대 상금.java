import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Set;
import java.util.HashSet;

class Solution
{
    static Set<String>[] visited;
    static int max;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            max = 0;
            int depth = 0;
			String num = sc.next();
            char[] numArr = num.toCharArray();
            int c = sc.nextInt();
            visited = new HashSet[c+1]; // 방문 숫자들 저장
            for(int i = 0;i<=c;i++){
            	visited[i] = new HashSet<>();
            }
            dfs(numArr,c,0);
            System.out.println("#" + test_case + " " + max);
		}
	}
    
    static void dfs(char[] numArr,int c,int depth){
        String num = new String(numArr);
        if(visited[depth].contains(num)){ // 이미 방문 배열에 있으면 넘어가기
        	return;
        }
        visited[depth].add(num);
        if(c==depth){ // 횟수를 다 채우면!
            if(max<Integer.parseInt(num)){ // max보다 더 큰 값이면 갱신
                max = Integer.parseInt(num);
            }
            return;
        }
    	for(int i = 0;i<numArr.length-1;i++){
        	for(int j = i+1;j<numArr.length;j++){
            	char tmp = numArr[i];
                numArr[i] = numArr[j];
                numArr[j] = tmp;
                dfs(numArr,c,depth+1); // 바뀐 배열을 다시 넣고 돌리기
                
                // 다시 배열 원상 복구 해야함. : 백트래킹
                tmp = numArr[i];
                numArr[i] = numArr[j];
                numArr[j] = tmp;
            }
        }
    }
}