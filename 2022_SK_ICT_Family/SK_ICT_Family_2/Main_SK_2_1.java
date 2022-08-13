import java.util.*;
import java.io.*;

public class Main_SK_2_1 {

    
    public static void main(String[] args) throws IOException {

        System.out.println(Arrays.toString(solution(new String[]{"pencil","cilicon","contrabase","picturelist"}))); // 
        // System.out.println(solution(new String[]{"abcdeabcd","cdabe","abce","bcdeab"})); // 
     
    }

    public static String[] solution(String[] goods) {
        ArrayList<ArrayList<String>> answer = new ArrayList<>();
        String[] result = new String[goods.length];

        for(int i=0; i<goods.length; i++) answer.add(new ArrayList<>());

        for(int i=0; i<goods.length; i++) {
            for(int k=1; k<=goods[i].length(); k++) {
                String good = goods[i];

                if (!answer.get(i).isEmpty()) {
                    if (answer.get(i).get(0).length() < k) break;
                }

                for(int j=0; j<=goods[i].length()-k; j++) {
                    if (answer.get(i).contains(good.substring(j, j+k))) continue;
                    if (checkString(i, good.substring(j, j+k), goods)) {
                        answer.get(i).add(good.substring(j, j+k));
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

            if (str.equals("")) {
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

    public static boolean checkString(int index, String str, String[] goods) {
        for(int i=0; i<goods.length; i++) {
            if (i != index && goods[i].contains(str)) return false;
        }
        return true;
    }
            
}