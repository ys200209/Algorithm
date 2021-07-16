package Greedy;
import java.util.*;

class Main3 {

    public static void main(String[] args) {

        /*
            어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
            예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 
            이 중 가장 큰 숫자는 94 입니다.
            문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
            number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 
            solution 함수를 완성하세요
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
            // i가 2, k가 4일 때, j는 최대 6이어야 함. end는 7.
            // i가 1, k가 4일 때, j는 최대 6이어야 함. end는 7.
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

    

