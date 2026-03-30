
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	static int n,m;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] maze;
	static int minMove = Integer.MAX_VALUE;
	// static boolean[][] visited;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		maze = new int[n][m];
		// visited = new boolean[n][m];
		sc.nextLine();
		for(int i=0;i<n;i++) {
			String line = sc.nextLine();
			for(int j = 0;j<m;j++) {
				maze[i][j] = Integer.parseInt(line.substring(j,j+1));
			}
		}
		bfs(0,0);
		System.out.print(minMove);
	}
	
	static void bfs(int startX,int startY) {
		ArrayDeque<Site> queue = new ArrayDeque<>();
		queue.offer(new Site(startX,startY,1));
		maze[startX][startY] = 0; // 방문 처리
		// visited[startX][startY] = true;
		while(!queue.isEmpty()) {
			Site cur = queue.poll();
			int x = cur.x;
			int y = cur.y;
			int move = cur.move;
			if(x==(n-1) && y==(m-1)) {
				minMove = Math.min(minMove,move);
			}
			for(int i = 0;i<4;i++) {
				int lx = x+dx[i];
				int ly = y+dy[i];
				if(lx>=0 && ly>=0 && lx<n && ly<m && maze[lx][ly]==1) {
					// visited[lx][ly] = true;
					maze[lx][ly] = 0; // 방문 처리
					queue.offer(new Site(lx,ly,move+1));
				}
			}
		}
		return;
	}
	
	static class Site{
		int x;
		int y;
		int move;
		Site(int x,int y,int move){
			this.x = x;
			this.y = y;
			this.move = move;
		}
	}
}
