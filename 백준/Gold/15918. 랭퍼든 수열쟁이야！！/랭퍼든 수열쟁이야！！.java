import java.util.Scanner;

public class Main {
    static int[] arr;
    static int n,answer,fix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        fix = y-x-1;
        arr = new int[2*n+1];
        // 미리 값 지정
        arr[x] = fix;
        arr[y] = fix;
        dfs(1);    
        System.out.println(answer);
    }

    static void dfs(int num){
        if(num>n){ // n 을 넘어가면 끝
            answer++;
            return;
        }

        if(num==fix){ // 이미 지정된 수는 넘어가도 됨
            dfs(num+1);
        }

        for(int i = 1; i <= 2 * n; i++){
            int j = i+num+1;
            if(j>2*n){
                break;
            }
            if(arr[i]==0 && arr[j]==0){
                arr[i] = num;
                arr[j] = num;
                dfs(num+1);
                arr[i] = 0;
                arr[j] = 0;
            }
        }
    }
}
