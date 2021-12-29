import java.util.*;

public class Main2 {
    public static int answer, result;
    public static int[] name_list, front_list, back_list;

    public static void main(String[] args) {

        System.out.println(solution("JAZ")); // 11
        System.out.println(solution("JEROEN")); // 56
        System.out.println(solution("JAN")); // 23
        System.out.println(solution("ABBABAAAAAAAB")); // 13 (16 X)

    }

    public static int solution(String name) {
        answer = (int)1e9;
        result = 0;
        name_list = new int[name.length()];
        front_list = new int[name.length()];
        back_list = new int[name.length()];

        for(int i=0; i<name.length(); i++) {
            name_list[i] = name.charAt(i) - 'A';
            front_list[i] = 0;
            back_list[i] = 0;
        }

        System.out.println("name_list : " + Arrays.toString(name_list));

        search(0);

        return answer;
    }

    public static void search(int index) {
        if (index < 0 || index >= name_list.length) return;

        front(index);
        back(index);
    }

    public static void front(int index) {
        
        int j;
        for(int i=0; i<name_list.length; i++) {
            if (index + i >= name_list.length) j = (index + i) - name_list.length;
            else j = index + i;

            if (name_list[j] != front_list[j]) {
                if (name_list[j] <= 13) {
                    result += name_list[j];
                } else {
                    result += 26 - name_list[j];
                }
                front_list[j] = name_list[j];
            } 

            if (isEquals(front_list)) {
                answer = Math.min(answer, result);
                return;
            }

            result += 1; 

            index += 1;
            search(index);
            index -= 1;
        }

        
    }

    public static void back(int index) {
        
        int j;
        for(int i=0; i<name_list.length; i++) {
            if (index - i < 0) j = name_list.length + index - i;
            else j = index - i;

            if (name_list[j] != back_list[j]) {
                if (name_list[j] <= 13) {
                    result += name_list[j];
                } else {
                    result += 26 - name_list[j];
                }
                back_list[j] = name_list[j];
            } 

            if (isEquals(back_list)) {
                answer = Math.min(answer, result);
                return;
            }

            result += 1;

            index -= 1;
            search(index);
            index += 1;
        }
        
    }

    public static boolean isEquals(int[] list) { 
        for(int i=0; i<name_list.length; i++) {
            if (name_list[i] != list[i]) return false;
        }
        return true;
    }
    
}

