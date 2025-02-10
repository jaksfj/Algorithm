import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // 세그먼트 트리의 배열 크기 구하기
        int treeSize = 1;
        while (treeSize < n) {
            treeSize *= 2;
        }
        treeSize *= 2;
        long[] tree = new long[treeSize];
        Arrays.fill(tree,1);
        int startIndex = treeSize / 2;
        for (int i = startIndex; i < startIndex + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        // 각 노드의 부모 노드들을 자식들의 곱으로 표현
        int index = treeSize - 1;
        for(int i = index;i>0;i-=2){
            tree[i/2] = (tree[i] * tree[i-1]% 1000000007);
        }

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) { // b 인덱스의 값을 c로 저장
                int changeIndex = startIndex - 1 + b;
                tree[changeIndex] = c;

                // 위에 부모노드들 업데이트
                while (changeIndex > 1) {
                    if (changeIndex % 2 == 0) { // 오른쪽 자식이라면 왼쪽 노드의 곱을 부모노드에 저장
                        tree[changeIndex / 2] = (tree[changeIndex] * tree[changeIndex + 1])% 1000000007;
                    } else {
                        tree[changeIndex / 2] = (tree[changeIndex] * tree[changeIndex - 1])% 1000000007;
                    }
                    changeIndex /= 2;
                }
            } else if (a == 2) {
                int start = startIndex - 1 + b;
                int end = startIndex - 1 + (int) c;
                long answer = 1; // 부분곱 값 저장
                while (start <= end) {
                    if (start % 2 == 1) {
                        answer = (answer * tree[start]) % 1000000007;
                        start = (start + 1) / 2; // 오른쪽 부모 노드로 이동
                    } else {
                        start /= 2;
                    }

                    if (end % 2 == 0) {
                        answer = (answer * tree[end]) % 1000000007;
                        end = (end - 1) / 2; // 왼쪽 부모 노드로 이동
                    } else {
                        end /= 2;
                    }
                }
                bw.write((answer % 1000000007) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
