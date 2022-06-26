import java.util.*;

class Main2022_Internship_3 { // 1, 2번 (1번 참고 & 3번은 혹시나 몰라서 질문 준비할 것)
    static int answer = 0;
    static Queue<Power> pq = new PriorityQueue<>();

    public static void main(String[] args) {

        System.out.println(solution(10, 10, new int[][]{{10,15,2,1,2},{20,20,3,3,4}})); // 15

    }
    
    public static int solution(int alp, int cop, int[][] problems) {
        pq.offer(new Power(alp, cop, 0));

        BFS(problems);

        return answer;
    }

    public static void BFS(int[][] problems) { 
        while(!pq.isEmpty()) {
            Power power = pq.poll();

            if (checkPower(power, problems)) { // 모두 충족된다면 종료
                answer = power.time;
                return; 
            }

            // 이게 안되면 여기서 넣고 나중에 빼서 checkPower로 비교하지 말고 넣을때 바로 if값으로 checkPower 불러서 false나오면 큐에 넣자 (효율성)
            
            for(int i=0; i<problems.length; i++) { // 문제 풀기
                int[] problem = problems[i];

                int alp_diff = problem[0] - power.alp; // 알고력과 해당 문제와의 차이를 구함
                int cop_diff = problem[1] - power.cop; // 코딩력의 차이를 구함

                if (power.alp >= problem[0] && power.cop >= problem[1]) { // 문제를 풀 수 있다면
                    int countAlp = (problem[0] - power.alp); // 알고력으로 문제를 총 몇개 풀수있는지
                    int countCop = problem[1] / power.cop; // 코딩력으로 문제를 총 몇개 풀수있는지
                    int countMin = Math.min(countAlp, countCop); // 둘 중 한번에 몇 문제를 풀 수 있는지

                    System.out.println(Arrays.toString(problem));
                    System.out.println("problem[2] : " + problem[2] + ", problem[3] : " + problem[3] + ", problem[4] : " + problem[4]);
                    
                    if (countMin > 1) {
                        pq.offer(new Power(power.alp + problem[2]*countMin, power.cop + problem[3]*countMin, power.time + problem[4]*countMin));
                    }
                    
                }
                
                alp_diff = problem[0] - power.alp; // 알고력과 해당 문제와의 차이를 구함
                cop_diff = problem[1] - power.cop; // 코딩력의 차이를 구함
                // 차이가 나는 만큼 한번에 공부함 (+ 이렇게 하지 않으면 효율성 실패)
                if (alp_diff > 0) pq.offer(new Power(power.alp + alp_diff, power.cop, power.time + alp_diff));
                if (cop_diff > 0) pq.offer(new Power(power.alp, power.cop + cop_diff, power.time + cop_diff));
            }
        }
    }

    public static boolean checkPower(Power power, int[][] probloms) {
        for(int i=0; i<probloms.length; i++) {
            // 하나라도 부족하면 false 리턴
            if (power.alp < probloms[i][0] || power.cop < probloms[i][1]) return false;
        }
        return true; // 모두 충족되면 true 리턴
    }
}

class Power implements Comparable<Power> {

    int alp;
    int cop;
    int time;

    public Power(int alp, int cop, int time) {
        this.alp = alp;
        this.cop = cop;
        this.time = time;
    }

    @Override
    public int compareTo(Power power) {
        return this.time - power.time;
    }
}

/*
    Q1 : BFS가 무엇인가 (DFS랑 다른점은 무엇인가)
    Q2 : Comparable 이란 무엇인가 : 왜 time을 기준으로 정렬하려고 했는지??
    Q3 : 우선순위 큐란 무엇인가(개념, 구조, 정렬 방식 - 힙 정렬)
    Q4 : static 키워드에 대해 말해보라
*/ 