import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long x = Long.parseLong(br.readLine());

        if (x == 0) {
            System.out.print("GBSISTHEBEST");
            return;
        }

        long a = 0;
        while (a * a <= x) {
            a++;
        }
        a--;

        long b = a;
        while (a * b <= x) {
            b++;
        }
        b--;

        // A^a
        for (int i = 0; i < a; i++) sb.append('A');

        // B..Y
        sb.append("BCDEFGHIJKLMNOPQRSTUVWXY");

        // Z^b
        for (int i = 0; i < b; i++) sb.append('Z');

        long c = x - a * b;

        // A^c
        for (int i = 0; i < c; i++) sb.append('A');

        if(c>0) {
            // A..Z
            sb.append("BCDEFGHIJKLMNOPQRSTUVWXYZ");
        }

        System.out.print(sb.toString());
    }
}
