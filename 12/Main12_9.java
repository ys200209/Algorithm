import java.util.*;

class Main12_9 {
    static String str, substr, result2 = "";
    static int start, end, step, count=1, result1 = 1000;

    public static void main(String[] args) {

        /*
        
            2020 카카오 신입 공채.

            데이터 처리 전문가가 되고 싶은 '어피치'는 문자열을 압출하는 방법에 대해 공부를 하고 있습니다.
            최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데, 
            문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로
            줄여서 표현하는 알고리즘을 공부하고 있습니다. (ex. "aabbaccc"의 경우 "2a2ba3c"로 압축 가능)
        
        */
        
        /*System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd")); */ 
        System.out.println(solution("a"));

    }

    public static int solution(String s) {
        String substr, result2 = "";
        int start, end, step, count=1, answer = 1000;
        
        start = 0;
        end = s.length();

        for(step=s.length()/2; step>=1; step--) {
            start = 0;
            result2 = "";
            substr = s.substring(start, step);
            result2 += substr;
            start += step;
            for(int i=start; i<=end; i+=step) {
                if (i+step <= end) {
                    if(substr.equals(s.substring(i, i+step))) {
                        count++;
                    } else {
                        result2 += count > 1 ? Integer.toString(count) + substr : substr;
                        substr = s.substring(i, i+step);
                        count=1;
                    }
                } else {
                    substr = s.substring(i, end);
                    result2 += count > 1 ? Integer.toString(count) + substr : substr;
                    count=1;
                }
            }
            
            if(answer > result2.length()) {
                answer = result2.length();
            }
        }

        if(result2.length() == 0) { // 아무런 압축이 일어나지 않은 문자열의 경우, 문자열 개수 자체를 리턴한다.
            answer = s.length();
        }
        
        return answer;
    }
    
}
