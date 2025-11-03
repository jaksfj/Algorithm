import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt(); // 행 : y축
        int c = sc.nextInt(); // 열 : x축
        System.out.println(z(n, r, c));
    }

    static int z(int n, int r, int c) {
        if (n == 0) return 0;              // 1x1이면 더할 것이 없으므로
        int half = 1 << (n - 1);           // 현재 변의 절반
        int q = (r >= half ? 2 : 0) + (c >= half ? 1 : 0); // 사분면(0~3) 0:왼위 1:오위 2:왼아래 3:오아래
        int add = q * half * half;         // 이전 사분면들이 차지한 칸 수 추가해주기

        // 사분면 내부 로컬 좌표로 변환 : 해당 사분면 내부에서 z탐색
        int nr = (r >= half) ? r - half : r;
        int nc = (c >= half) ? c - half : c;
        return add + z(n - 1, nr, nc);
    }
}
