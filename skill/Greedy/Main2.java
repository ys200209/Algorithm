

public class Main2 {
    public static int result=0, now=0, answer=(int)1e9;
    public static int[] name_list, A_list;
    
    public static void main(String[] args) {

        for(int i=0; i<10; i++) {
            i += 50;
            System.out.println("i = " + i);
        }
        
        // System.out.println(solution("JAZ")); // 11
        // System.out.println(solution("JEROEN")); // 56
        // System.out.println(solution("JAN")); // 23
        // System.out.println(solution("ABAAAAAAAAABB")); // 7

    }
    
    public static int solution(String name) {

        name_list = new int[name.length()];
        A_list = new int[name.length()];

        for(int i=0; i<name.length(); i++) {
            name_list[i] = name.charAt(i) - 'A';
        }

        front(0); // ������ ���̽�ƽ�� �̵���Ŵ
        A_list = new int[name.length()];
        back(0); // �ڷ� ���̽�ƽ�� �̵���Ŵ

        

        return answer;
    }

    public static void search() {
        
    }

    public static void front(int index) {
        // answer = (int)1e9;
        result = 0;

        int j;
        for(int i=index; i<name_list.length; i++) {
            if (i >= name_list.length) j = i - name_list.length;
            else j = i;
            if (name_list[j] <= 13) {
                result += name_list[j];
            } else {
                result += 26 - name_list[j]; // Z�� 25������ A���� Z�� �� �� �̵��ϱ� ���� +1���־� 26�� ��
            }
            A_list[j] = name_list[j];

            if (checkList()) {
                answer = Math.min(answer, result);
                return;
            }

            result += 1; // ���̽�ƽ�� ���� ���縵�� ���������� �ű�� �۾�. ������ ���縵�� ����.

        }

        
    }

    public static void back(int index) {
        result = 0;

        for(int i=name_list.length; i>0; i--) {
            if (i == name_list.length) {
                if (name_list[0] <= 13) {
                    result += name_list[0];
                } else {
                    result += 26 - name_list[0];
                }
                A_list[0] = name_list[0];
            } else {
                if (name_list[i] <= 13) {
                    result += name_list[i];
                } else {
                    result += 26 - name_list[i];
                }
                A_list[i] = name_list[i];
            }

            if (checkList()) {
                answer = Math.min(answer, result);
                return;
            }

            result += 1; // ���̽�ƽ�� ���� ���縵�� �������� �ű�� �۾�. ������ ���縵�� ����.

        }

    }

    public static boolean checkList() { // ������ ���ĺ��� ��ġ�ϴ��� Ȯ��
        for(int i=0; i<name_list.length; i++) {
            if (A_list[i] != name_list[i]) return false; // ����ġ�� False
        }
        return true;
    }

}