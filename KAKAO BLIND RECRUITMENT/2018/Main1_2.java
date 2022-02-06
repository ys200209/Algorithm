import java.util.*;

public class Main1_2 {
    
    public static void main(String[] args) {

        System.out.println("answer : " + solution("1S2D*3T")); // 37
        System.out.println("answer : " + solution("1D2S#10S")); // 9
        System.out.println("answer : " + solution("1D2S0T")); // 3
        System.out.println("answer : " + solution("1S*2T*3S")); // 23
    
    }

    public static int solution(String dartResult) {
        int answer = 0;
        String number = "";
        int[] score = new int[4];
        String[] dart = dartResult.split("");

        int index = 0;
        for(int i=0; i<dart.length; i++) {

            if (dart[i].charAt(0) - '0' < 0) { // 옵션
                if (dart[i].equals("*")) {
                    score[index-1] *= 2;
                    score[index] *= 2; 
                } else {
                    score[index] *= -1;
                }
            } else if (dart[i].charAt(0) - '0' <= 10) { // 다트 점수
                number += dart[i];
            } else if (dart[i].equals("S") || dart[i].equals("D") || dart[i].equals("T")) { // 보너스
                index++;
                score[index] = Integer.parseInt(number);
                number = "";
                if (dart[i].equals("D")) score[index] = score[index] * score[index];
                else if (dart[i].equals("T")) score[index] = score[index] * score[index] * score[index];
                
            }
        }
        
        // System.out.println(Arrays.toString(score));

        for(int num : score) answer += num;

        return answer;
    }

}
