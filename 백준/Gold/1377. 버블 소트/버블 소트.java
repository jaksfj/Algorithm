import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Data[] datas = new Data[n];
        for (int i = 0; i < n; i++) {
            datas[i] = new Data(arr[i],i);
        }

        Arrays.sort(datas); // 정렬 (value 오름차순 기준으로)

        int maxMove = 0; // 최대 거리
        for (int i = 0; i < n; i++) { // i 는 정렬 전 인덱스를 의미
            int originalIndex = datas[i].index;
            maxMove = Math.max(maxMove,originalIndex-i);
        }
        /*
        문제의 핵심 : 뒤 요소가 앞 요소로 1칸 이동하기까지는 무조건 한번의 반복을 거쳐야함
        그래서 뒤로 이동하는 것들은 한번의 반복으로 가능하기 때문에 무시되고, 앞으로 이동하는 것들을
        반복문의 횟수, 즉 이동 거리의 최댓값으로 간주해야한다.
        원래 인덱스 - 정렬된 인덱스 했을 때 양수가 나오는 것들의 최댓값 + 1 이 답이 되는 것이다.
         */

        System.out.println(maxMove+1);
    }

    static class Data implements Comparable<Data>{
        int value;
        int index;

        public Data(int value, int index){
            this.value = value;
            this.index = index;
        }


        @Override
        public int compareTo(Data o) { // value 기준으로 오름차순 정렬하기
            return this.value-o.value;
        }
    }
}
