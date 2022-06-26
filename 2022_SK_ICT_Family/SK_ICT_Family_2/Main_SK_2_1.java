import java.util.*;
import java.io.*;

public class Main_SK_2_1 {

    
    public static void main(String[] args) throws IOException {

        // System.out.println(Arrays.toString(solution(new String[]{"pencil","cilicon","contrabase","picturelist"}))); // 
        System.out.println(Arrays.toString(solution(new String[]{"abcdeabcd","cdabe","abce","bcdeab"}))); // 
     
    }

    public static String[] solution(String[] goods) { // 본래 주석이 없었음 참고.
        ArrayList<ArrayList<String>> answer = new ArrayList<>();
        String[] result = new String[goods.length];

        for(int i=0; i<goods.length; i++) answer.add(new ArrayList<>()); // 2중 배열 초기화

        for(int i=0; i<goods.length; i++) { // 각 문자열을
            for(int k=1; k<=goods[i].length(); k++) { // 문자열의 갯수만큼 반복
                String good = goods[i];

                if (!answer.get(i).isEmpty()) {
                    if (answer.get(i).get(0).length() < k) break; // 무슨 조건
                }

                for(int j=0; j<=goods[i].length()-k; j++) { 
                    
                    // 이미 포함된 문자구간이라면 continue;
                    if (answer.get(i).contains(good.substring(j, j+k))) continue;
                    
                    if (checkString(i, good.substring(j, j+k), goods)) { // 해당 문자구간이 '유일'하다면
                        answer.get(i).add(good.substring(j, j+k)); // add
                    }
                }

            }
        }

        for(int i=0; i<goods.length; i++) {
            String str = "";

            if (!answer.get(i).isEmpty()) {
                Collections.sort(answer.get(i));
                str += answer.get(i).get(0);
            }

            if (str.equals("")) { // i번째 문자열의 모든 문자구간은 '유일'하지 않다
                result[i] = "None";
                continue;
            }

            for(int j=1; j<answer.get(i).size(); j++) {
                str += (" " + answer.get(i).get(j));
            }
            result[i] = str;
        }

        return result;
    }

    // 해당 문자구간이 '유일'한지 판단
    public static boolean checkString(int index, String str, String[] goods) { 
        for(int i=0; i<goods.length; i++) { 
            if (i != index && goods[i].contains(str)) return false;
        }
        return true;
    }
    
}