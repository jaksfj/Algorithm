import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer> preOrder;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String node;
        preOrder = new ArrayList<>();
        while(true){
            node = br.readLine();
            if(node==null || node.equals("")) {
                break;
            }
            preOrder.add(Integer.parseInt(node));
        }
        postOrder(0,preOrder.size()-1);
    }

    static void postOrder(int start, int end){
        if(start>end){
            return;
        }

        int root = preOrder.get(start); // 루트 노드
        int mid = start+1;

        while(mid<=end && preOrder.get(mid)<root){ // 루트노드보다 큰 노드찾기 (오른쪽 트리부분을 찾기)
            mid++;
        }

        postOrder(start+1,mid-1); // 왼쪽 트리부분 탐색
        postOrder(mid,end); // 오른쪽 트리부분 탐색
        System.out.println(root); // 루트 출력
    }
}
