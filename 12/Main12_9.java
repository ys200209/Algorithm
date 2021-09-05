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

        for(int i=1; i<s.length()/2; i++) { // i ���� ���´ٰ� ����
            result="";
            start = 0;
            end = i;
            
            str = s.substring(start, end);
            //result += s.substring(start, end);
            for(int j=i; j<s.length(); j+=i) { // ó������ i���� ����
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
