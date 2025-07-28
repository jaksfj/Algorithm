

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 좌표 정렬하기
    static class XY implements Comparable<XY>{
        int x;
        int y;
        XY(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(XY o){
            if(this.x == o.x){
                return this.y-o.y;
            }
            return this.x-o.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        XY[] arr = new XY[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new XY(x,y);
        }
        Arrays.sort(arr);
        for(XY e : arr){
            System.out.println(e.x+" "+e.y);
        }
    }
}
