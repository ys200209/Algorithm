import java.util.*;

class Main12_8 {
    static String s, result="";
    static int num;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        s = scanner.next();
        num = 0;

        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) >= 'A') {
                list.add(s.substring(i, i+1));
            } else {
                num += Integer.parseInt(s.substring(i, i+1));
            }
        }

        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));

        for(int i=0; i<list.size(); i++) {
            result += list.get(i);
        }

        System.out.println(result + num);
        
    }

}
