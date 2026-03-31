
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		bfs(n,k);
		System.out.print(answer);
	}
	
	static void bfs(int startNode, int endNode) {
		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(startNode,0));
		visited[startNode] = true;
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int pos = cur.pos;
			int cnt = cur.cnt;
			if(pos==endNode) {
				answer = cnt;
				return;
			}
			if((pos*2)<=100000 && !visited[pos*2]) {
				visited[pos*2] = true;
				queue.offer(new Node(pos*2,cnt+1));
			}  
			if((pos+1)<=100000 && !visited[pos+1]) {
				visited[pos+1] = true;
				queue.offer(new Node(pos+1,cnt+1));
			}
			if(pos-1>=0 && !visited[pos-1]) {
				visited[pos-1] = true;
				queue.offer(new Node(pos-1,cnt+1));
			}
		}
	}
	
	static class Node{
		int pos;
		int cnt;
		
		Node(int pos, int cnt){
			this.pos = pos;
			this.cnt = cnt;
		}
	}
}
