import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] cnt0 = new int[41];
        int[] cnt1 = new int[41];
        cnt0[0] = 1;
        cnt1[0] = 0;
        cnt0[1] = 0;
        cnt1[1] = 1;
        for (int i = 2; i <= 40; i++) {
            cnt0[i] = cnt0[i-1] + cnt0[i-2];
            cnt1[i] = cnt1[i-1] + cnt1[i-2];
        }
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(cnt0[n] + " " + cnt1[n] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
