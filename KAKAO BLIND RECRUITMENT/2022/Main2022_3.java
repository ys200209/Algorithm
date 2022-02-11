import java.util.*;

public class Main2022_3 {
    static int[] f;
    static Map<String, Parking> map = new HashMap<>(); // <차 번호, 주차 정보>
    static Map<String, Integer> price = new HashMap<>(); // <차 번호, 주차비>

    public static void main(String[] args) {

        // 주차 요금 계산 (Level : 2)
        System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600},
        new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
        // [14600, 34400, 5000]
    }

    public static int[] solution(int[] fees, String[] records) {
        f = new int[4];
        for(int i=0; i<4; i++) {
            f[i] = fees[i];
        }

        ArrayList<String> carNumbers = new ArrayList<>(); // 차량번호대로 오름차순 출력을 위해.

        for(int k=0; k<records.length; k++) {
            String time = records[k].split(" ")[0];
            String number = records[k].split(" ")[1];
            String state = records[k].split(" ")[2];

            int HH = Integer.parseInt(time.split(":")[0]) * 60;
            int MM = Integer.parseInt(time.split(":")[1]);

            if (state.equals("IN")) { // 입차
                int IN = HH + MM;
                if (map.get(number) == null) map.put(number, new Parking(IN, (23 * 60) + 59, 0, "IN")); // 첫 주차
                else { // 재 주차
                    int parkingTime = map.get(number).getParkingTime(); // 누적 주차시간을 더하기 위해.
                    map.put(number, new Parking(IN, (23 * 60) + 59, parkingTime, "IN"));
                } 

                if (!carNumbers.contains(number)) carNumbers.add(number); 
            } else { // 출차
                int IN = map.get(number).getIn();
                int OUT = HH + MM;
                int parkingTime = map.get(number).getParkingTime(); // 누적 주차시간을 더하기 위해.
                map.put(number, new Parking(IN, OUT, parkingTime + (OUT - IN), "OUT")); // 출차된 정보로 새로 갱신
                
                price.put(number, map.get(number).getFees());
            }
        }

        for(String carNum : map.keySet()) {
            if (map.get(carNum).getState().equals("IN")) { // IN은 했지만 OUT으로 갱신되지 않은 차라면
                int IN = map.get(carNum).getIn();
                int OUT = map.get(carNum).getOut();
                int parkingTime = map.get(carNum).getParkingTime();
                map.put(carNum, new Parking(IN, OUT, parkingTime + (OUT - IN), "OUT")); // 누적 주차시간 갱신

                price.put(carNum, map.get(carNum).getFees());
            }
        }
        
        Collections.sort(carNumbers);

        int[] answer = new int[carNumbers.size()];

        int i=0;
        for(String carNum : carNumbers) {
            answer[i] = price.get(carNum);
            i++;
        }

        return answer;
    }

    static class Parking {

        private int IN; // 입차 시간(분)
        private int OUT; // 출차 시간(분)
        private int parkingTime; // 누적 주차시간(분)
        private String state; // 주차 상태(IN, OUT)
    
        public Parking(int IN, int OUT, int parkingTime, String state) {
            this.IN = IN;
            this.OUT = OUT;
            this.parkingTime = parkingTime;
            this.state = state;
        }

        public int getIn() {
            return IN;
        }

        public int getOut() {
            return OUT;
        }

        public String getState() {
            return state;
        }

        public int getParkingTime() {
            return parkingTime;
        }

        public int getFees() {
            return parkingTime <= f[0] ? f[1] : f[1] + ((parkingTime-f[0])%f[2] == 0 ? 
            (parkingTime-f[0])/f[2] : (parkingTime-f[0])/f[2] + 1) * f[3];
        }
    
    }

}