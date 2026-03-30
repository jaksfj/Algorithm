import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] words = {"c=","c-","d-","lj","nj","s=","z="};
		int cnt = 0;
		int index = 0;
		while(index<str.length()) {
			boolean isExist = false;
			if(index==str.length()-1) {
				cnt++;
				break;
			}
			String part2 = str.substring(index,index+2);
			if(part2.equals("dz") && (index+2)<(str.length()) && str.substring(index,index+3).equals("dz=")) {
				cnt++;
				index+=3;
				continue;
			}
			for(int i = 0;i<7;i++) {
				if(part2.equals(words[i])) {
					cnt++;
					isExist = true;
					index+=2;
					break;
				}
			}
			if(isExist) {
				continue;
			}
			index+=1;
			cnt++;
		}
		System.out.print(cnt);
	}
}
