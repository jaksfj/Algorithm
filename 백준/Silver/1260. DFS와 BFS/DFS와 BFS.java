import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	public static void main(String[] aregs) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list[n1].add(n2);
			list[n2].add(n1);
		}
		dfs(v);
		visited = new boolean[n+1]; // 방문배열 초기화
		System.out.println();
		bfs(v);
	}
	
	static void dfs(int node) {
		if(visited[node]) {
			return;
		}
		System.out.print(node + " ");
		visited[node] = true;
		Collections.sort(list[node]);
		for(int next : list[node]) {
			if(!visited[next]) {
				dfs(next);	
			}
		}
	}
	
	static void bfs(int node) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(node);
		visited[node] = true;
		System.out.print(node + " ");
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			Collections.sort(list[cur]);
			for(int next : list[cur]) {
				if(!visited[next]) {
					System.out.print(next + " ");
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
	}
}
