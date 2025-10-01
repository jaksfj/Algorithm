import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException { // 저거 못타면 지각이야!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정류장에 동시에 정차가능 버스 수
        int m = Integer.parseInt(st.nextToken()); // 영우가 타려는 버스까지의 버스 수
        Queue<Bus> waitBuses = new ArrayDeque<>(); // 버스 대기열
        Queue<Bus> busStop = new ArrayDeque<>(); // 버스 정류장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int depart = Integer.parseInt(st.nextToken());
            int wait = Integer.parseInt(st.nextToken());
            waitBuses.offer(new Bus(depart, wait)); // 먼저 대기 큐에 넣기
        }
        int inBusCnt = 0; // 들어간 버스 수
        int arriveTime = 1;
        int index = 0;
        while(true) {
            while(!waitBuses.isEmpty() && waitBuses.peek().departTime <= arriveTime && index < n) {
                Bus bus = waitBuses.poll();

                busStop.offer(bus);
                inBusCnt++;
                index++;

                if (inBusCnt == m) {
                    System.out.println(index); // m번째 버스의 정류장 위치
                    return;
                }
            }

            for(Bus curr : busStop) {
                curr.waitTime--;
            }

            while(!busStop.isEmpty() && busStop.peek().waitTime <= 0) {
                busStop.poll();
            }

            if(busStop.isEmpty()) {
                index = 0;
            }
            arriveTime++;
        }
    }

    static class Bus{
        int departTime;
        int waitTime;

        Bus(int departTime,int waitTime){
            this.departTime = departTime;
            this.waitTime = waitTime;
        }
    }
}
