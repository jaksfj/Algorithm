import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        // 세그먼트 트리 : 부분합을 구하면서 값을 업데이트해야 하는 경우 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 세그먼트 트리 배열의 크기 구하기
        int treeSize =1;
        while(treeSize<n){ // 배열의 크기(n)는 2의 treeSize승보다 크거나 같아야 한다.
            treeSize*=2;
        }
        treeSize *= 2; // 리프 노드의 최대 개수
        long[] tree = new long[treeSize];
        int startIndex = treeSize/2;

        // 트리 값 저장
        for(int i = startIndex;i<startIndex+n;i++){
            tree[i] = Long.parseLong(br.readLine());
        }

        // 트리 부분합 만들기
        int index = treeSize-1; // 트리의 마지막 인덱스
        while (index > 0) {
            tree[index / 2] += tree[index]; // 부모 노드에 자식 노드의 값 더하기
            index--; // 모든 노드 업데이트
        }

        // 트리
        for(int i = 0;i<m+k;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a==1){ // b 인덱스의 값을 c 값으로 업데이트, 트리 업데이트 (해당 노드 부모만)
                int updateIndex = startIndex-1+b;
                long diff = c-tree[updateIndex];
                tree[updateIndex] = c; // 해당 노드 값 업데이트

                while(updateIndex>1){
                    tree[updateIndex/2] += diff;
                    updateIndex/=2; // 해당 노드의 부모로 이동
                }
            }else if(a==2){ // b인덱스부터 c인덱스까지의 부분합 구하기
                int start = startIndex-1+b;
                int end = startIndex-1+(int)c;
                long sum = 0; // 부분합 총합
                while(start<=end){
                    if(start%2==1){ // 해당 부모노드 사용불가
                        sum += tree[start];
                        start = (start+1)/2; // 자신의 부모노드의 오른쪽 노드로 이동
                    }else{
                        start/=2;
                    }

                    if(end%2==0){
                        sum += tree[end];
                        end = (end-1)/2;
                    }else{
                        end/=2;
                    }
                }
                bw.write(sum + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
