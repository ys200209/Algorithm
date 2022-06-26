import java.util.*;

class Main2022_Internship_2 { // 1, 2�� (1�� ����)
    
    public static void main(String[] args) {
        // System.out.println(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1})); // 2
        System.out.println(solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2})); // 7
        // System.out.println(solution(new int[]{7, 2, 4, 6}, new int[]{5, 1, 3, 2})); // 1
    }
    
    public static int solution(int[] queue1, int[] queue2) {
        int answer = (int)1e9; // �ּ� Ƚ���� ������ ����
        
        long sum1=0, sum2=0;
        long max1=0, max2=0;
        long[] list = new long[queue1.length + queue2.length];

        int i=0;
        for(long n : queue1) { // �� ���� ť ������ list �迭�� ����� 
            list[i++] = n; 
            sum1 += n; // ť1�� ��
            max1 = Math.max(max1, n); // ť1�� �ִ�
        }

        for(long n : queue2) {
            list[i++] = n;
            sum2 += n; // ť2�� ��
            max2 = Math.max(max2, n); //ť2�� �ִ�
        }

        // �� ť�� ���� Ȧ���� ���� �� ������ �ǹ��Ѵ�.
        if ((sum1 + sum2) % 2 == 1) return -1;

        // ��� �� ���� �� ���� ť�� ���� ���� �� �̻��̸� ���� �� ������ �ǹ��Ѵ�. (���� : �� �ʰ��� �� �ȵǴ� ��)
        if (max1 > (sum1+sum2)/2 || max2 > (sum1+sum2)/2) return -1;

        if (sum1 == sum2) return 0; // �̹� ���ٸ� ����

        // �� ������
        int from = 0;
        int to = queue1.length; // ť 1�� ���� ��� ���� ���º��� ����
        long sum = sum1; // �κ����� ������ ť 1�� ��������
        long mid = (sum1 + sum2) / 2;

        // �� ���� �����Ͱ� �迭 ���ο� ���� ���ȸ� Ž��
        while(from < list.length && to < list.length) {
            if (sum > mid) { // ���� ���� ��� ������ ũ�ٸ�
                sum -= list[from++]; 
            } else if (sum < mid) { // ��� ������ �۴ٸ�
                sum += list[to++];
            } else { // ���� ��ġ�Ѵٸ�

                // from : ť1���� ť2�� ���� �ű� Ƚ��
                // to : ť2���� ť1�� ���� �ű� Ƚ��
                answer = Math.min(answer, from + (to - queue1.length)); // ���ݱ����� �ִ� Ƚ���� answer��..
                /*
                (to - queue1.length) : to�� ť1 �ε������� �����ϱ� ������
                �ű� Ƚ������ ��� ���ؼ� �⺻ ���� ť1 ���̸� ���־���
                */
                sum -= list[from++]; 
                // �ּ� Ƚ���� �������ְ� �ٽ� ���� �ε������� Ž��
            } 
        }

        // �� ���� ���� ������ ���� �ѹ��� ���ٸ� -1 ����
        return answer == (int)1e9 ? -1 : answer;
    }

}

/*
    Q1 : Queue�� ���� �����϶� ( Stack�̶� �ٸ��� )
    Q2 : �� �����Ͱ� �������� �����϶� (�� ������ �˰����� �̿��� �κ����� ����)
    Q3 : Queue1 ���� ����� ���� : ���� X
*/ 