import java.util.*;

class Main11_3 {
    static String s;
    static int[] list;
    static int count0, count1 = 0;
    
    public static void main(String[] args) {

        /*
            0과 1로만 이루어진 문자열 S가 있다. 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 할 때,
            연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다. 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.
            ex) s = 0001100에서 0을 1로 뒤집으려면 1111100 으로 한번, 1111111로 두번 뒤집으면 된다.
            그러나 처음부터 0000000으로 한번만에 뒤집을 수도 있다.
            최소 횟수를 출력하시오.

            16:05 -> 16:15
        */

        Scanner sc = new Scanner(System.in);

        s = sc.next();
        list = new int[s.length()];

        for(int i=0; i<list.length; i++) {
            list[i] = s.charAt(i) - '0';
        }
        
        if(list[0] == 0) {
            count1++;
        } else {
            count0++;
        }

        for(int i=0; i<list.length-1; i++) {
            if(list[i]==0 && list[i+1]==1) {
                count0++;
            } else if(list[i]==1 && list[i+1]==0) {
                count1++;
            }
        }
        System.out.println("count0 = " + count0 + ", count1 = " + count1);
        System.out.println("result = " + Math.min(count0, count1));

    }

}
