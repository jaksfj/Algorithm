

import java.io.*;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while(true){
            str = br.readLine();
            if(str.equals(".")){
                break;
            }
            bw.write(isValid(str) ? "yes\n" : "no\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isValid(String str){
        ArrayDeque<Character> stack;
        stack = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if(s=='(' || s=='['){
                stack.push(s);
            }else if(s==')'){
                if(stack.isEmpty() || stack.pop()!='('){
                    return false;
                }
            }else if(s==']'){
                if(stack.isEmpty() || stack.pop()!='['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
