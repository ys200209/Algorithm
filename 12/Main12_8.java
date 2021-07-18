import java.util.*;

class Main12_8 {
    static String str, result_str = "";
    static int[] list;
    static int result_num;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        str = sc.nextLine();
        list = new int[str.length()];
        Comparator<String> comp = (o1, o2) -> o1.compareTo(o2);

        for(int i=0; i<list.length; i++) {
            list[i] = str.charAt(i) - '0';
        }

        System.out.println("list = " + Arrays.toString(list));

        Arrays.sort(list);

        for(int i=0; i<list.length; i++) {
            if(list[i] <= 9) {
                result_num += list[i]; 
            } else {
                result_str += (char)(list[i] + '0');
                System.out.println("result_str = " + result_str);
            }
        }

        System.out.println("result = " + result_str + Integer.toString(result_num));
    }

}
