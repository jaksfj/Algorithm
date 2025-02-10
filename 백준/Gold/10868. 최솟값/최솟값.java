import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 트리 배열의 크기 구하기
        int treeSize = 1;
        while(treeSize<n){
            treeSize*=2;
        }
        treeSize*=2;
        long[] tree = new long[treeSize];
        int startIndex = treeSize/2; // 시작 노드
        // 트리 배열에 값 넣고, 최솟값 부모노드에 채우기
        for(int i = startIndex;i<startIndex+n;i++){
            tree[i] = Long.parseLong(br.readLine());
        }
        tree = setTree(tree);
        // 범위내에서 최솟값 찾기
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = startIndex - 1 + Integer.parseInt(st.nextToken());
            int end = startIndex - 1 + Integer.parseInt(st.nextToken());
            bw.write(getMin(start,end,tree) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static long[] setTree(long[] tree){
        int index = tree.length-1;
        while(index>0){
            if(tree[index/2]==0){ // 반약 부모노드가 비어있다면 저장
                tree[index/2] = tree[index];
            }else {
                tree[index / 2] = Math.min(tree[index / 2], tree[index]); // 최솟값을 부모 노드에 저장하기
            }
            index--;
        }
        return tree;
    }

    private static long getMin(int start,int end,long[] tree){
        long min = Long.MAX_VALUE;
        while(start<=end) {
            if (min > tree[start]) {
                min = tree[start];
            }
            if (start % 2 == 1) { // 오른쪽 자식일 때
                start = (start + 1) / 2; // 오른쪽 부모 노드로 이동
            } else {
                start /= 2;
            }

            if (min > tree[end]) {
                min = tree[end];
            }
            if (end % 2 == 0) { // 왼쪽 자식일 때
                end = (end - 1) / 2; // 왼쪽 부모 노드로 이동
            } else {
                end /= 2;
            }
        }
        return min;
    }
}
