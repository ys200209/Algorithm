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
        
        //System.out.println(solution("aabbaccc")); // 8(aabbaccc) -> 7(2a2ba3c)
        System.out.println(solution("ababcdcdababcdcd")); // 16(ababcbcbababcbcb) -> 9(2ababcbcb)
        //System.out.println(solution("abcabcdede")); //  10(abcabcdede) -> 8(2abcdede)
        //System.out.println(solution("abcabcabcabcdededededede")); // 24 -> 14
        //System.out.println(solution("xababcdcdababcdcd")); // 17 -> 17
        //System.out.println(solution("a"));

    }

    public static int solution(String s) {
        int min = 1000, count=1, start=0, end;
        String str, result="";

        for(int i=1; i<s.length()/2; i++) { // i 개씩 묶는다고 가정
            result="";
            start = 0;
            end = i;
            
            str = s.substring(start, end);
            //result += s.substring(start, end);
            for(int j=i; j<s.length(); j+=i) { // 처음부터 i개씩 묶기
                start = start + i;
                end = start + i;
                System.out.println("1. start = " + start + ", end = " + end);
                if (end < s.length()) {
                    System.out.println("str = " + str + ", s.substring = " + s.substring(start, end));
                    if (str.equals(s.substring(start, end))) {
                        count += 1;
                        System.out.println("count = " + count);
                    } else {
                        if (count != 1) {
                            result += count + str;
                            count = 1;
                        } else {
                            result += str;
                        }
                        str = s.substring(start, end);
                    }
                } else {
                    result += s.substring(start-i, s.length());
                    break;
                }
                
            }
            System.out.println("-----------------result = " + result);
            if (min > result.length()) {
                min = result.length();
            }
        }

        
        System.out.println("min = " + min);

        return min;
    }
    
}
