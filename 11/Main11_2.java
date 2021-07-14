import java.util.*;

class Main11_2 {
    static String s;
    static int[] list;
    static int result;

    public static void main(String[] args) {

        /*
            0-9로만 이루어진 문자열 S가 주어질 때, 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며 숫자 사이에
            'X' 혹은 '+'를 넣어 만들어질 수 있는 가장 큰 수를 구하는 프로그램을 작성
            15:48 -> 15:55 (30분)
        */
        
        Scanner sc = new Scanner(System.in);

        s = sc.next();

        list = new int[s.length()];

        for(int i=0; i<list.length; i++) {
            list[i] = s.charAt(i) - '0';
            
        } 

        result = list[0];
        for(int i=1; i<list.length; i++) {
            if(result == 0 || list[i] == 0 || result == 1 || list[i] == 1) {
                result += list[i];
            } else {
                result *= list[i];
            }
        }

        System.out.println("result = " + result);
    }

}
