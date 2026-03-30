import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		for(int i = 1;i<=n;i++) {
			arr[i] = i;
		}
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int index1 = Integer.parseInt(st.nextToken());
			int index2 = Integer.parseInt(st.nextToken());
			while(index1<index2) {
				swap(index1,index2);
				index1++;
				index2--;
			}
		}
		for(int i = 1;i<=n;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	static void swap(int index1,int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
}
