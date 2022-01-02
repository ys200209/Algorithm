import java.util.*;

class Main12_9 {

    public static void main(String[] args) {

        /*
        
            2020 카카오 신입 공채.

            데이터 처리 전문가가 되고 싶은 '어피치'는 문자열을 압출하는 방법에 대해 공부를 하고 있습니다.
            최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데, 
            문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로
            줄여서 표현하는 알고리즘을 공부하고 있습니다. (ex. "aabbaccc"의 경우 "2a2ba3c"로 압축 가능)
        
        */
        
        System.out.println(solution("aabbaccc")); // 8(aabbaccc) -> 7(2a2ba3c)
        System.out.println(solution("ababcdcdababcdcd")); // 16(ababcbcbababcbcb) -> 9(2ababcbcb)
        System.out.println(solution("abcabcdede")); //  10(abcabcdede) -> 8(2abcdede)
        System.out.println(solution("abcabcabcabcdededededede")); // 24 -> 14
        System.out.println(solution("xababcdcdababcdcd")); // 17 -> 17
        System.out.println(solution("aaabbbabcde")); // 
        System.out.println(solution("aaaaaaaaaaaabcd")); // 6

    }

    public static int solution(String s) {
        int answer = (int)1e9;
        String word=null;
        int count, result=0;

        if (s.length() == 1) return 1;

        for(int i=s.length()/2; i>=1; i--) {
            result = 0;
            count = 1;
            for(int j=i; j<=s.length(); j+=i) {
                word = s.substring(j-i, j);
                
                if (j+i > s.length()) {
                    result += s.length() - j;
                    result += count == 1 ? word.length() : word.length() + Integer.toString(count).length();
                    break;
                }

                if (word.equals(s.substring(j, j+i))) {
                    count+=1;
                    continue;
                } else {
                    result += count == 1 ? word.length() : word.length() + Integer.toString(count).length();
                    count=1;
                }
            }
            answer = Math.min(answer, result);
        }
        return answer;
    }
}