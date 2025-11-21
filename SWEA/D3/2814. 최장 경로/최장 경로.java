import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;

class Solution
{
	static int max;
	static ArrayList<Integer>[] list;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			max = 0;
			int n = sc.nextInt(); // 노드 개수
			list = new ArrayList[n+1];
			for(int i = 1;i<=n;i++) {
				list[i] = new ArrayList<>();
			}
			int m = sc.nextInt(); // 간선 개수
			for(int i = 0;i<m;i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				// 인접 리스트에 저장
				list[start].add(end); 
				list[end].add(start);
			}
			for(int i = 1;i<=n;i++) {
				boolean[] visited = new boolean[n+1];
				dfs(i,visited,1);
			}
			System.out.println("#" + test_case + " " + max);
		}
	}
	
	static void dfs(int node,boolean[] visited,int depth) {
		if(visited[node]) { // 방문했던 노드면 종료
			return;
		}
		max = Math.max(max,depth);
		visited[node] = true; // 방문처리
		
		for(int n : list[node]) {
			if(!visited[n]){
				dfs(n,visited,depth+1);
			}
		}
		visited[node] = false; // 백트래킹
	}
}