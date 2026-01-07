import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("all")){
                set = new HashSet<>();
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            }else if(cmd.equals("empty")){
                set = new HashSet<>();
            }else {
                int num = Integer.parseInt(st.nextToken());
                switch (cmd) {
                    case "add":
                        set.add(num);
                        break;
                    case "check":
                        bw.write((set.contains(num) ? 1 : 0) + "\n");
                        break;
                    case "remove":
                        set.remove(num);
                        break;
                    case "toggle":
                        if (set.contains(num)) {
                            set.remove(num);
                        } else {
                            set.add(num);
                        }
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
