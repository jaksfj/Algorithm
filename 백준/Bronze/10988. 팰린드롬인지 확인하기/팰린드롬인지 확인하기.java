import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		boolean isPelin = true;
		int start = 0;
		int end = str.length()-1;
		while(start<end) {
			if(str.charAt(start)!=str.charAt(end)) {
				isPelin = false;
				break;
			}
			start++;
			end--;
		}
		if(isPelin) {
			System.out.print(1);
		}else {
			System.out.print(0);
		}
	}
}
