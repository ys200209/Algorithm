package Greedy;
import java.util.*;

class Main3 {

    public static void main(String[] args) {

        /*
            � ���ڿ��� k���� ���� �������� �� ���� �� �ִ� ���� ū ���ڸ� ���Ϸ� �մϴ�.
            ���� ���, ���� 1924���� �� �� ���� �����ϸ� [19, 12, 14, 92, 94, 24] �� ���� �� �ֽ��ϴ�. 
            �� �� ���� ū ���ڴ� 94 �Դϴ�.
            ���ڿ� �������� ���� number�� ������ ���� ���� k�� solution �Լ��� �Ű������� �־����ϴ�. 
            number���� k ���� ���� �������� �� ���� �� �ִ� �� �� ���� ū ���ڸ� ���ڿ� ���·� return �ϵ��� 
            solution �Լ��� �ϼ��ϼ���
        */

        //System.out.println(solution("1924", 2));
        //System.out.println(solution("1231234", 3)); // 7, 3 -> 4(index)
        System.out.println(solution("4177252841", 4));

    }

    public static String solution(String number, int k) {
        String answer = "";
        int max=0, start=0, end=0, index=0;
        int[] list = new int[number.length()];

        System.out.println("-----------------");

        for(int i=0; i<list.length; i++) {
            list[i] = number.charAt(i) - '0';
        }

        for(int i=0; i<number.length()-k-1; i++) {
            max=0;
            System.out.println("--i-- = " + i);
            // i�� 2, k�� 4�� ��, j�� �ִ� 6�̾�� ��. end�� 7.
            // i�� 1, k�� 4�� ��, j�� �ִ� 6�̾�� ��. end�� 7.
            end = list.length - k + i; // 2 
            System.out.println("end = " + end);
            for(int j=start; j<end; j++) {
                System.out.println("j = " + j);
                if(max < list[j]) {
                    max = list[j];
                    index = j;
                    
                }
                
            }
            System.out.println("list["+index+"] = " + list[index]);
            list[index] = 0;
            System.out.println("list = " + Arrays.toString(list));
            answer += Integer.toString(max);
            start = index+1;
            System.out.println("answer = " + answer);
        }

        return answer;
    }
    
}

    

