package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_16637 {
    static int N, MAX=0;
    static List<Integer> numbers = new ArrayList<>();
    static List<String> cals = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        String[] split = br.readLine().split("");
        for(int i=0; i<N; i++) {
            if (i % 2 == 0) numbers.add(Integer.parseInt(split[i]));
            else cals.add(split[i]);
        }

//        System.out.println("numbers = " + numbers);
//        System.out.println("cals = " + cals);

        DFS(0, 0);

        System.out.println(MAX);

    }

    private static void DFS(int index, int count) {

        MAX = Math.max(MAX, getResult());
//        System.out.println("MAX = " + MAX + ", count - " + count);

        for(int i=index; i<cals.size(); i++) {
            int num1 = numbers.get(i);
            int num2 = numbers.get(i+1);
            String cal = cals.get(i);
            int result;

            if (cal.equals("+")) result = num1 + num2;
            else if (cal.equals("-")) result = num1 - num2;
            else result = num1 * num2;

            numbers.remove(i+1);
            numbers.set(i, result);
            cals.remove(i);
            DFS(i+1, count+1);
            cals.add(i, cal);
            numbers.add(i+1, num2);
            numbers.set(i, num1);
        }

    }

    private static int getResult() {
        int result = numbers.get(0);

        for(int i=0; i<cals.size(); i++) {
            String cal = cals.get(i);

            if (cal.equals("+")) result += numbers.get(i+1);
            else if (cal.equals("-")) result -= numbers.get(i+1);
            else result *= numbers.get(i+1);
        }

        return result;
    }

}