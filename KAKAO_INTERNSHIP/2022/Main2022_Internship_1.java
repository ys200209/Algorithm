import java.util.*;

class Main2022_Internship_1 {
    // 1, 2���� �ϰ�, ������ ������ ���� map�� ������ �߰��ϴ� �κп���
    // ������ Ű�� ���� ���� �� ���� �� ���ϼ� �Ǵ� ������ hashCode(), equals() �޼��带 ����ϸ� ����. 
    static String answer = "";
    static Map<String, Integer> map = new HashMap<>(); // <��������, ����>

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        // TCMA

    }
    
    public static String solution(String[] survey, int[] choices) {
        for(int i=0; i<survey.length; i++) {
            String[] types = survey[i].split("");
            int choice = choices[i];

            if (choice == 4) continue; // ������ ���� ����

            // addScore(int, String) : ������ ���� ���� ������ ��� �޼���
            if (choice < 4) addScore(choice, types[0]); // ���� ������ 3�� ���϶�� ���� ���������� ������ �ش�.
            else addScore(choice, types[1]); // ���� ������ 5�� �̻��̶�� ���� ���������� ������ �ش�.
        }

        // MBTI(String, String) : �� ���� ���� ���� ���Ͽ� �ϳ��� ������ �����ϴ� �޼���
        MBTI("R", "T");
        MBTI("C", "F");
        MBTI("J", "M");
        MBTI("A", "N");

        return answer;
    }

    public static void addScore(int choice, String type) {
        // Map : getOrDefault(Key, defaultValue) -> ���� Key���� �������� ���� �� defaultValue ���� ������
        // ���� Key�� �����Ѵٸ� Key�� �ش��ϴ� Value�� ������
        if (choice < 4) {
            map.put(type, map.getOrDefault(type, 0) + (4 - choice)); // 4 - choice��ŭ ������ ����
        } else {
            map.put(type, map.getOrDefault(type, 0) + (choice - 4)); // choice - 4��ŭ ������ ����
        }
    }

    // ********** .charAt() : ���� ���� �� �ش� ���ڸ� ASCII �ڵ�� ��ȯ�Ͽ� �� ��.   ***************
    public static void MBTI(String A, String B) { 
        // �� �� ������ ���� ���
        // ���� ������ ���� ������ �޾ƿ�

        if (map.get(A) == null && map.get(B) == null) answer += A.charAt(0) > B.charAt(0) ? B : A;
        else if (map.get(A) == null) answer += B; // A�� ������ ���� ��� B ������ ������
        else if (map.get(B) == null) answer += A; // B�� ������ ���� ��� A ������ ������
        else { // �� �� ���� �����Ѵٸ�

            // ������ �����ϴٸ� ���� ������ ���� ������ �޾ƿ�
            if (map.get(A) == map.get(B)) answer += A.charAt(0) > B.charAt(0) ? B : A;
            else if (map.get(A) > map.get(B)) answer += A; // ���� ���̴�� �޾ƿ�
            else answer += B;
        }
        
    }

}

/*
    Q1 : HashMap?
    Q1_2 : List, Set, Map�� ���ؼ� �ڼ��� �����϶�. (HashXxx������.)
    Q2 : Map������ ����� ���׸��̶� : ��Ÿ���� �ƴ� ������ �������� Exception Validation
    Q3 : static Ű���带 ����ؼ� ������ ����
    Q4 : Map �������̽��� .getOrDefault() �޼��� : 
*/ 