import java.util.*;

public class Main6_2 {
    public static ArrayList<Integer> list = new ArrayList<>();
    public static int result;
    public static String[] str;

    public static void main(String[] args) {

        for(int i=1; i<=20; i++) {
            str = Integer.toString(i).split("");
            result = i;
            for(int j=0; j<str.length; j++) {
                result += Integer.parseInt(str[j]);
            }

            if (!list.contains(result)) {
                list.add(result);
            }

            if(!list.contains(i)) {
                System.out.println(i);
            }
        }

    }
}
