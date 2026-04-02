import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static int[][] arr;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int maxDepth = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m+1][n+1];
		int zeroCnt = 0;
		for(int i = 1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 1;j<=n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) {
					zeroCnt++;
				}
			}
		}
		if(zeroCnt==0) {
			System.out.print(0);
		}else {
			// 저장 되기 전에 모두 익은 상태이면 0, 모두 익지 못하는 상황이면 -1
			bfs();
			zeroCnt = 0;
			for(int i = 1;i<=m;i++) {
				for(int j= 1;j<=n;j++) {
					if(arr[i][j]==0) {
						zeroCnt++;
					}
				}
			}
			if(zeroCnt>0) {
				System.out.print(-1);
			}else {
				System.out.print(maxDepth);
			}
		}
	}
	
	static void bfs() {
		ArrayDeque<Loc> queue = new ArrayDeque<>();
		// 익은 토마토의 위치를 넣기
		for(int i = 1;i<=m;i++) {
			for(int j= 1;j<=n;j++) {
				if(arr[i][j]==1) {
					queue.offer(new Loc(i,j,0));
				}
			}
		}
		while(!queue.isEmpty()) {
			Loc cur = queue.poll();
			int x = cur.x;
			int y = cur.y;
			int depth = cur.depth;
			maxDepth = Math.max(depth, maxDepth);
			for(int i = 0;i<4;i++) {
				int lx = x + dx[i];
				int ly = y + dy[i];
				if(lx>0 && lx<=m && ly>0 && ly<=n && arr[lx][ly]==0) {
					arr[lx][ly] = 1;
					queue.offer(new Loc(lx,ly,depth+1));
				}
			}
		}
	}
	
	static class Loc{
		int x;
		int y;
		int depth;
		Loc(int x,int y,int depth){
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
}
