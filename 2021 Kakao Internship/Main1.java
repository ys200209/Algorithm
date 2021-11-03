import java.util.*;

class Main1 {

    public static void main(String[] args) {

        // 숫자 문자열과 영단어 (1)
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"	));
        System.out.println(solution("123"));
        

    }

    public static int solution(String s) {
        String answer = "";
        String word = null;
        ArrayList<String> str_list = new ArrayList<>();
        ArrayList<String> num_list = new ArrayList<>();

        str_list.add("zero"); num_list.add("0");
        str_list.add("one"); num_list.add("1");
        str_list.add("two"); num_list.add("2");
        str_list.add("three"); num_list.add("3");
        str_list.add("four"); num_list.add("4");
        str_list.add("five"); num_list.add("5");
        str_list.add("six"); num_list.add("6");
        str_list.add("seven"); num_list.add("7");
        str_list.add("eight"); num_list.add("8");
        str_list.add("nine"); num_list.add("9");

        while(!s.isEmpty()) { // one4seveneight
            for(int i=1; i<=s.length(); i++) {
                if (i==2) continue;
                
                word = s.substring(0, i);
                
                if (i==1 && num_list.contains(word)) {
                    answer += word;
                    s = s.substring(i, s.length());
                    break;
                }

                if (str_list.contains(word)) {
                    answer += str_list.indexOf(word);
                    s = s.substring(i, s.length());
                    break;
                }
            }
        }

        return Integer.parseInt(answer);
    }
    
}
