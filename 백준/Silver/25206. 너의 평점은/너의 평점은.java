import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double sum = 0;
		double[] gradeNum = {4.5,4.0,3.5,3.0,2.5,2.0,1.5,1.0,0.0};
		String[] grades = {"A+","A0","B+","B0","C+","C0","D+","D0","F"};
		HashMap<String,Double> map = new HashMap<>();
		
		for(int i = 0;i<9;i++) {
			map.put(grades[i],gradeNum[i]);
		}
		int cnt = 0;
		for(int i = 0;i<20;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			double gradeN = Double.parseDouble(st.nextToken());
			String gradeS = st.nextToken();
			if(gradeS.equals("P")) {
				continue;
			}
			sum += (gradeN * map.get(gradeS));
			cnt+=gradeN;
		}
		System.out.printf("%.6f",(sum/cnt));
	}
}
