

import java.util.Scanner;

public class Main { // 설탕 배달
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = n/5; i >= 0; i--) { // i가 0일때는 3으로만 나눠지는지 확인하려는 것
            int remaining = n-(i*5);
            if(remaining == 0){
                System.out.println(i);
                return;
            }else{
                int j = remaining/3;
                if(remaining%3==0){
                    System.out.println(i+j);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
