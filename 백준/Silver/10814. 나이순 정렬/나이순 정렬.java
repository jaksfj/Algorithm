

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 나이순 정렬
    static class User implements Comparable<User>{
        int age;
        String name;
        int rNum;
        User(int age,String name,int rNum){
            this.age = age;
            this.name = name;
            this.rNum = rNum;
        }

        @Override
        public int compareTo(User o){
            if(this.age==o.age){
                return this.rNum-o.rNum;
            }
            return this.age - o.age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        User[] users = new User[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            users[i] = new User(age,name,i);
        }
        Arrays.sort(users);
        for(User user : users){
            System.out.println(user.age+" "+user.name);
        }
    }
}
