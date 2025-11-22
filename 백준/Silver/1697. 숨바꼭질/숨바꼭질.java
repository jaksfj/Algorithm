
import java.util.Scanner;
import java.util.ArrayDeque;

public class Main {
	static int s,e,answer;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();
		e = sc.nextInt();
		boolean[] visited = new boolean[100001];
		bfs(visited,s);
		System.out.print(answer);
	}
	
	static void bfs(boolean[] visited,int start) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		visited[start] = true;
		queue.add(start);
		int[] time = new int[100001];
		time[start] = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur==e) {
				answer = time[cur];
				return;
			}
			int n1 = cur+1;
			int n2 = cur-1;
			int n3 = cur*2;
			if(n1<100001 && !visited[n1]) {
				queue.add(n1);
				visited[n1] = true;
				time[n1] = time[cur] + 1;
			}
			if(n2>=0 && !visited[n2]) {
				queue.add(n2);
				visited[n2] = true;
				time[n2] = time[cur] + 1;
			}
			if(n3<100001 && !visited[n3]) {
				queue.add(n3);
				visited[n3] = true;
				time[n3] = time[cur] + 1;
			}
		}
	}
}
