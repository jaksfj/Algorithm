import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 이진트리의 노드 개수
        StringTokenizer st;
        Map<String, Node> node = new HashMap<>();
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            node.put(parent,new Node(left,right)); // map 에 노드 정보 put 하기
        }

        preorder(node,"A");
        System.out.println();
        inorder(node,"A");
        System.out.println();
        postorder(node,"A");
    }

    private static class Node{
        String left;
        String right;
        Node(String left,String right){
            this.left = left;
            this.right = right;
        }
    }

    private static void preorder(Map<String, Node> node, String next){ // 전위 순회
        if(next.equals(".")){
            return;
        }
        System.out.print(next);
        preorder(node,node.get(next).left);
        preorder(node,node.get(next).right);
    }

    private static void inorder(Map<String, Node> node, String next){ // 중위 순회
        if(next.equals(".")){
            return;
        }
        inorder(node,node.get(next).left);
        System.out.print(next);
        inorder(node,node.get(next).right);
    }

    private static void postorder(Map<String, Node> node, String next){ // 후위 순회
        if(next.equals(".")){
            return;
        }
        postorder(node,node.get(next).left);
        postorder(node,node.get(next).right);
        System.out.print(next);
    }
}
