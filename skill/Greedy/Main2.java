

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

        front(0); // 앞으로 조이스틱을 이동시킴
        A_list = new int[name.length()];
        back(0); // 뒤로 조이스틱을 이동시킴

        

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
                result += 26 - name_list[j]; // Z는 25이지만 A에서 Z로 한 번 이동하기 위해 +1해주어 26이 됨
            }
            A_list[j] = name_list[j];

            if (checkList()) {
                answer = Math.min(answer, result);
                return;
            }

            result += 1; // 조이스틱을 다음 스펠링인 오른쪽으로 옮기는 작업. 마지막 스펠링은 제외.

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

            result += 1; // 조이스틱을 다음 스펠링인 왼쪽으로 옮기는 작업. 마지막 스펠링은 제외.

        }

    }

    public static boolean checkList() { // 조작한 알파벳이 일치하는지 확인
        for(int i=0; i<name_list.length; i++) {
            if (A_list[i] != name_list[i]) return false; // 불일치시 False
        }
        return true;
    }

}