import java.util.*;

class Main12_9 {
    static String str, substr, result2 = "";
    static int start, end, step, count=1, result1 = 1000;

    public static void main(String[] args) {

        /*
        
            2020 īī�� ���� ��ä.

            ������ ó�� �������� �ǰ� ���� '����ġ'�� ���ڿ��� �����ϴ� ����� ���� ���θ� �ϰ� �ֽ��ϴ�.
            �ֱٿ� �뷮�� ������ ó���� ���� ������ ��ս� ���� ����� ���� ���θ� �ϰ� �ִµ�, 
            ���ڿ����� ���� ���� �����ؼ� ��Ÿ���� ���� �� ������ ������ �ݺ��Ǵ� ������ ǥ���Ͽ� �� ª�� ���ڿ���
            �ٿ��� ǥ���ϴ� �˰����� �����ϰ� �ֽ��ϴ�. (ex. "aabbaccc"�� ��� "2a2ba3c"�� ���� ����)
        
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

        if(result2.length() == 0) { // �ƹ��� ������ �Ͼ�� ���� ���ڿ��� ���, ���ڿ� ���� ��ü�� �����Ѵ�.
            answer = s.length();
        }
        
        return answer;
    }
    
}
