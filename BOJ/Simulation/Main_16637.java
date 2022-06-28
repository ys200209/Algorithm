import java.util.*;


import java.io.*;
import java.net.SocketTimeoutException;

public class Main_16637 {
    static int N, result=-(int)1e9;
    static ArrayList<Integer> numbers = new ArrayList<>();
    static ArrayList<String> cal = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String[] calculate = br.readLine().split("");

        for(int i=0; i<calculate.length; i++) {
            int c = calculate[i].charAt(0) - '0';
            if (c >= 0 && c <= 9) numbers.add(Integer.parseInt(calculate[i]));
            else cal.add(calculate[i]);
        }

        DFS();

        System.out.println(result);
    }

    public static void DFS() {
        // System.out.println("DFS");
        if (cal.size() == 0) {
            result = Math.max(result, numbers.get(0));
            if (result == 302400) System.out.println("result : 302400!! " + numbers);
            
            return;
        }
        
        /*int one = numbers.get(0);
        int two = numbers.get(1);
        int three = numbers.size() >= 3 ? numbers.get(2) : -1;

        String c1 = cal.get(0);
        String c2 = three != -1 ? cal.get(1) : null;*/

        for(int i=0; i<cal.size() && i < 2; i++) {
            // System.out.println("i : " + i + ", : " + numbers);
            int one = numbers.get(i);
            int two = numbers.get(i+1);
            String c = cal.get(i);
            int result = 0;

            

            if (c.equals("+")) result = one + two;
            else if (c.equals("-")) result = one - two;
            else result = one * two;

            if (two == 0) {
                System.out.println(numbers + ", result : " + result + ", c : " + c);
            }

            if (i == 1) {
                System.out.println("i : 1");
                int one2 = numbers.get(0);
                String c2 = cal.get(0);
                int result2 = 0;

                if (c2.equals("+")) result2 = result + one2;
                else if (c2.equals("-")) result2 = one2 - result;
                else result2 = one2 * result;

                // System.out.println("one : " + one + ", two : " + two + ", result : " + result + ", one2 : " + one2 + ", two2 : " + c2);
                // System.out.println("result2 : " + result2);

                numbers.set(0, result2);
                numbers.remove(2);
                numbers.remove(1);
                cal.remove(1);
                cal.remove(0);
                DFS();
                cal.add(0, c2);
                cal.add(0, c);
                numbers.set(0, one2);
                numbers.add(1, one);
                numbers.add(2, two);

            } else {
                numbers.set(i, result);
                numbers.remove(i+1);
                cal.remove(i);
                DFS();
                cal.add(i, c);
                numbers.set(i, one);
                numbers.add(i+1, two);
            }


        }


    }

}
