import java.util.*;

public class Main2_1 {
    
    public static void main(String[] args) {

        // System.out.println(solution("FRANCE", "french")); // 16384
        System.out.println(solution("aa1+aa2", "AAAA12")); // 43690 
        // System.out.println(solution("E=M*C^2", "e=m*c^2")); // 65536 
        // System.out.println(solution("Ee=", "eea")); // 0 
    
    }

    public static int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        int hap = 0; // �������� ��
        int equals = 0; // �������� ��

        for(int i=1; i<str1.length(); i++) { // str1 �κ�����
            int num1 = str1.charAt(i-1) - 'A';
            int num2 = str1.charAt(i) - 'A';
            if (num1  >= 0 && num1 <= 25 && num2 >= 0 && num2 <= 25) {
                String str = str1.substring(i-1, i+1);
                if (map1.get(str) == null) map1.put(str, 1);
                else map1.put(str, map1.get(str) + 1);
            }
        }

        for(int i=1; i<str2.length(); i++) { // str2 �κ�����
            int num1 = str2.charAt(i-1) - 'A';
            int num2 = str2.charAt(i) - 'A';
            if (num1  >= 0 && num1 <= 25 && num2 >= 0 && num2 <= 25) {
                String str = str2.substring(i-1, i+1);
                if (map2.get(str) == null) map2.put(str, 1);
                else map2.put(str, map2.get(str) + 1);
            }
        }

        if (map1.size() == 0 && map2.size() == 0) return 65536; // A�� B ��� �������� ���

        System.out.println("----------[map1]----------");
        for(String s : map1.keySet()) {
            System.out.println(s + " : " + map1.get(s));
        }
        System.out.println("----------[map2]----------");
        for(String s : map2.keySet()) {
            System.out.println(s + " : " + map2.get(s));
        }

        for(String s : map1.keySet()) { // ������ ����
            if (map2.keySet().contains(s)) {
                hap += Math.max(map1.get(s), map2.get(s));
                equals += Math.min(map1.get(s), map2.get(s));
                map2.remove(s);
            } else {
                hap += map1.get(s);
            }
        }

        for(String s : map2.keySet()) { // ������ ����
            hap += map2.get(s);
        }


        return (int)((double)equals / hap * 65536);
    }

}