import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        선택 정렬 : 내림차순으로 정렬하기
        해당 범위에서 최댓값을 찾고 배열의 맨앞으로 이동, startindex 이동하기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strArr = br.readLine(); // 하나의 문자열로 입력받기
        int[] numArr = new int[strArr.length()];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr.substring(i,i+1)); // 2143
        }

        int startIndex = 0;
        while(startIndex<numArr.length) {
            int max = numArr[startIndex];
            int maxIndex = startIndex;
            for (int i = startIndex; i < numArr.length; i++) {
                if(max<numArr[i]){
                    max = numArr[i];
                    maxIndex = i; // 가장 큰 수의 인덱스를 가짐.
                }
            }

            // 가장 큰 수의 요소와 배열의 맨 앞 요소와 자리 교환 swap
            int tmp = numArr[maxIndex];
            numArr[maxIndex] = numArr[startIndex];
            numArr[startIndex] = tmp; // 배열의 가장 앞 요소에 최대값을 넣는다.

            startIndex++; // 배열 맨 앞 요소 정렬에서 제외시키기

        }

        for (int i = 0; i < numArr.length; i++) {
            System.out.print(numArr[i]);
        }
    }
}
