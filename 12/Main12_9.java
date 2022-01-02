import java.util.*;

class Main12_9 {

    public static void main(String[] args) {

        /*
        
            2020 īī�� ���� ��ä.

            ������ ó�� �������� �ǰ� ���� '����ġ'�� ���ڿ��� �����ϴ� ����� ���� ���θ� �ϰ� �ֽ��ϴ�.
            �ֱٿ� �뷮�� ������ ó���� ���� ������ ��ս� ���� ����� ���� ���θ� �ϰ� �ִµ�, 
            ���ڿ����� ���� ���� �����ؼ� ��Ÿ���� ���� �� ������ ������ �ݺ��Ǵ� ������ ǥ���Ͽ� �� ª�� ���ڿ���
            �ٿ��� ǥ���ϴ� �˰����� �����ϰ� �ֽ��ϴ�. (ex. "aabbaccc"�� ��� "2a2ba3c"�� ���� ����)
        
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