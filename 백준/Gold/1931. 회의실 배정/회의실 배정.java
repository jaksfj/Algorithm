import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Time> list = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Time(start,end));
		}
		int answer = 1; // 회의 하나 있을 경우
		Collections.sort(list);
		int curIndex = 0;
		for(int i = 1;i<list.size();i++) {
			if(list.get(curIndex).endTime<=list.get(i).startTime) {
				answer++;
				curIndex = i;
			}
		}
		System.out.print(answer);
	}
	
	static class Time implements Comparable<Time>{
		int startTime;
		int endTime;
		Time(int startTime, int endTime){
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		@Override
		public int compareTo(Time o) {
			if(this.endTime==o.endTime) {
				return this.startTime-o.startTime;
			}
			return this.endTime-o.endTime;
		}
	}
}
