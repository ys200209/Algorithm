import java.util.*;

class Main2022_Internship_2 { // 1, 2번 (1번 참고)
    
    public static void main(String[] args) {
        // System.out.println(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1})); // 2
        System.out.println(solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2})); // 7
        // System.out.println(solution(new int[]{7, 2, 4, 6}, new int[]{5, 1, 3, 2})); // 1
    }
    
    public static int solution(int[] queue1, int[] queue2) {
        int answer = (int)1e9; // 최소 횟수를 저장할 변수
        
        long sum1=0, sum2=0;
        long max1=0, max2=0;
        long[] list = new long[queue1.length + queue2.length];

        int i=0;
        for(long n : queue1) { // 두 개의 큐 값들을 list 배열에 담아줌 
            list[i++] = n; 
            sum1 += n; // 큐1의 합
            max1 = Math.max(max1, n); // 큐1의 최댓값
        }

        for(long n : queue2) {
            list[i++] = n;
            sum2 += n; // 큐2의 합
            max2 = Math.max(max2, n); //큐2의 최댓값
        }

        // 두 큐의 합의 홀수면 나눌 수 없음을 의미한다.
        if ((sum1 + sum2) % 2 == 1) return -1;

        // 어느 한 수라도 두 개의 큐를 더한 값의 반 이상이면 나눌 수 없음을 의미한다. (수정 : 반 초과일 때 안되는 것)
        if (max1 > (sum1+sum2)/2 || max2 > (sum1+sum2)/2) return -1;

        if (sum1 == sum2) return 0; // 이미 같다면 종료

        // 투 포인터
        int from = 0;
        int to = queue1.length; // 큐 1의 값을 모두 더한 상태부터 시작
        long sum = sum1; // 부분합의 범위가 큐 1로 설정해줌
        long mid = (sum1 + sum2) / 2;

        // 두 개의 포인터가 배열 내부에 있을 동안만 탐색
        while(from < list.length && to < list.length) {
            if (sum > mid) { // 더한 값이 평균 값보다 크다면
                sum -= list[from++]; 
            } else if (sum < mid) { // 평균 값보다 작다면
                sum += list[to++];
            } else { // 합이 일치한다면

                // from : 큐1에서 큐2로 값을 옮긴 횟수
                // to : 큐2에서 큐1로 값을 옮긴 횟수
                answer = Math.min(answer, from + (to - queue1.length)); // 지금까지의 최단 횟수인 answer과..
                /*
                (to - queue1.length) : to는 큐1 인덱스부터 시작하기 때문에
                옮긴 횟수만을 얻기 위해서 기본 값인 큐1 길이를 빼주었음
                */
                sum -= list[from++]; 
                // 최소 횟수를 갱신해주고 다시 다음 인덱스부터 탐색
            } 
        }

        // 두 개의 값이 같아진 적이 한번도 없다면 -1 리턴
        return answer == (int)1e9 ? -1 : answer;
    }

}

/*
    Q1 : Queue에 대해 설명하라 ( Stack이랑 다른점 )
    Q2 : 투 포인터가 무엇인지 설명하라 (투 포인터 알고리즘을 이용해 부분합을 구현)
    Q3 : Queue1 부터 담아준 이유 : 딱히 X
*/ 