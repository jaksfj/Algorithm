import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int n,m,k;
	static int[][] arr;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	static int cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		for(int t = 0;t<test_case;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cnt = 0;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n][m];
			visited = new boolean[n][m];
			for(int i = 0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x][y] = 1;
			}
			
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<m;j++) {
					if(!visited[i][j] && arr[i][j]==1) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static void bfs(int startX,int startY){
		ArrayDeque<Site> queue = new ArrayDeque<>();
		queue.offer(new Site(startX,startY));
		visited[startX][startY] = true;
		arr[startX][startY] = 0;
		while(!queue.isEmpty()) {
			Site cur = queue.poll();
			int x = cur.x;
			int y = cur.y;
			for(int i = 0;i<4;i++) {
				int lx = dx[i] + x;
				int ly = dy[i] + y;
				if(lx>=0 && lx<n && ly>=0 && ly<m && !visited[lx][ly] && arr[lx][ly]==1) {
					queue.add(new Site(lx,ly));
					visited[lx][ly] = true;
					arr[lx][ly] = 0;
				}
			}
		}
	}
	
	static class Site{
		int x;
		int y;
		Site(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
