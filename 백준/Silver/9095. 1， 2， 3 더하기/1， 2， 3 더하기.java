import java.util.Scanner;

public class Main {
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            cnt=0;
            int n = sc.nextInt();
            dfs(n);
            System.out.println(cnt);
        }
    }
    static void dfs(int num){
        if(num==0){
            cnt++;
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if(num-i>=0){
                dfs(num-i);
            }
        }
    }
}
