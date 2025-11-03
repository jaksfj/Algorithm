import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayDeque;

class Solution
{
	public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        String[] code = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt(); // 세로
            int m = sc.nextInt(); // 가로
            sc.nextLine();
            System.out.print("#" + test_case + " ");
            String[] arr = new String[n];
            boolean isExist = false;
            // 입력
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLine();
            }

            // 배열 이동하면서 시작 인덱스 찾기
            for (int i = 0; i < n; i++) { // 세로
                int endIndex = -1;
                boolean isValid = false;
                for (int j = m; j >= 7; j--) { // 가로
                    for (int k = 0; k < 10; k++) { // 코드 배열 돌면서 확인하기
                        if(arr[i].substring(j-7,j).equals(code[k])){
                            endIndex = j;
                            isValid = true;
                            break;
                        }
                    }
                    if(isValid){
                        break;
                    }
                }
                if(endIndex==-1){ // 코드배열에 해당하는 코드가 없으면 다음줄로 이동
                    continue;
                }

                // 시작 인덱스부터 7씩 옮겨가면서 올바른 암호코드인지 확인 : 홀수자리의합 x 3 + 짝수자리의합
                int index = 1; // 짝수, 홀수 인덱스 분별용
                int oddSum = 0; // 홀수자리 합
                int evenSum = 0; // 짝수자리 합
                int j = endIndex; // 코드가 나타나는 끝 인덱스의 위치
                ArrayDeque<Integer> stack = new ArrayDeque<>();
                while(j-7>=0){
                    for (int k = 0; k < 10; k++) {
                        if(arr[i].substring(j-7,j).equals(code[k])){
                            stack.push(k);
                            break;
                        }
                    }
                    j-=7;
                }
                while(!stack.isEmpty()){
                    if(index%2==0){
                        evenSum += stack.pop();
                    }else{
                        oddSum += stack.pop();
                    }
                    index++;
                }
                if((oddSum*3+evenSum)%10==0){
                    System.out.println(oddSum + evenSum);
                    isExist = true;
                    break;
                }
            }
            if(!isExist){
                System.out.println(0);
            }
        }
    }
}