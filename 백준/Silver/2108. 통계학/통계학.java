
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        // 최빈빈도 찾기
        int maxFreq = 0;
        for(int freq : map.values()){
            maxFreq = Math.max(freq,maxFreq);
        }

        // 최빈값 찾기
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> mapKey: map.entrySet()){
            // 이미 존재하는 key값이 리스트에 있다면 또 추가하면 안됨
            if(mapKey.getValue()==maxFreq){
                list.add(mapKey.getKey());
            }
        }

        // 최빈값 중 두번째로 작은 값 가져오기
        Collections.sort(list);

        int answer = 0;
        // 만약 최빈값이 하나밖에 없으면 두번쨰 값이 없으니 출력
        if(list.size()<2){
            answer = list.get(0);
        }else{
            answer = list.get(1);
        }

        double avg = Math.round((float)sum/n); // 자리올림
        Arrays.sort(arr);

        System.out.println((int)avg);
        System.out.println(arr[n/2]);
        System.out.println(answer);
        System.out.println(arr[n-1]-arr[0]);
    }
}
