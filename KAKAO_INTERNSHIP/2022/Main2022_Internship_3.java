import java.util.*;

class Main2022_Internship_3 { // 1, 2�� (1�� ���� & 3���� Ȥ�ó� ���� ���� �غ��� ��)
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

            if (checkPower(power, problems)) { // ��� �����ȴٸ� ����
                answer = power.time;
                return; 
            }

            // �̰� �ȵǸ� ���⼭ �ְ� ���߿� ���� checkPower�� ������ ���� ������ �ٷ� if������ checkPower �ҷ��� false������ ť�� ���� (ȿ����)
            
            for(int i=0; i<problems.length; i++) { // ���� Ǯ��
                int[] problem = problems[i];

                int alp_diff = problem[0] - power.alp; // �˰�°� �ش� �������� ���̸� ����
                int cop_diff = problem[1] - power.cop; // �ڵ����� ���̸� ����

                if (power.alp >= problem[0] && power.cop >= problem[1]) { // ������ Ǯ �� �ִٸ�
                    int countAlp = (problem[0] - power.alp); // �˰������ ������ �� � Ǯ���ִ���
                    int countCop = problem[1] / power.cop; // �ڵ������� ������ �� � Ǯ���ִ���
                    int countMin = Math.min(countAlp, countCop); // �� �� �ѹ��� �� ������ Ǯ �� �ִ���

                    System.out.println(Arrays.toString(problem));
                    System.out.println("problem[2] : " + problem[2] + ", problem[3] : " + problem[3] + ", problem[4] : " + problem[4]);
                    
                    if (countMin > 1) {
                        pq.offer(new Power(power.alp + problem[2]*countMin, power.cop + problem[3]*countMin, power.time + problem[4]*countMin));
                    }
                    
                }
                
                alp_diff = problem[0] - power.alp; // �˰�°� �ش� �������� ���̸� ����
                cop_diff = problem[1] - power.cop; // �ڵ����� ���̸� ����
                // ���̰� ���� ��ŭ �ѹ��� ������ (+ �̷��� ���� ������ ȿ���� ����)
                if (alp_diff > 0) pq.offer(new Power(power.alp + alp_diff, power.cop, power.time + alp_diff));
                if (cop_diff > 0) pq.offer(new Power(power.alp, power.cop + cop_diff, power.time + cop_diff));
            }
        }
    }

    public static boolean checkPower(Power power, int[][] probloms) {
        for(int i=0; i<probloms.length; i++) {
            // �ϳ��� �����ϸ� false ����
            if (power.alp < probloms[i][0] || power.cop < probloms[i][1]) return false;
        }
        return true; // ��� �����Ǹ� true ����
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
    Q1 : BFS�� �����ΰ� (DFS�� �ٸ����� �����ΰ�)
    Q2 : Comparable �̶� �����ΰ� : �� time�� �������� �����Ϸ��� �ߴ���??
    Q3 : �켱���� ť�� �����ΰ�(����, ����, ���� ��� - �� ����)
    Q4 : static Ű���忡 ���� ���غ���
*/ 