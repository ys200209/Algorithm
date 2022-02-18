import java.util.*;

public class Main2020_Internship2 {
    static int size;
    static long MAX=0;
    static ArrayList<Integer> number = new ArrayList<>();
    static ArrayList<String> calculate = new ArrayList<>();
    static Map<String, Integer> calCount = new HashMap<>();

    public static void main(String[] args) {

        // System.out.println(solution("100-200*300-500+20")); // 60420
        System.out.println(solution("50*6-3*2")); // 300

    }

    public static long solution(String expression) {

        int point=0;
        for(int i=0; i<expression.length(); i++) {
            if (expression.charAt(i) - '0' < 0) {
                number.add(Integer.parseInt(expression.substring(point, i)));
                calculate.add(expression.substring(i, i+1));
                calCount.put(expression.substring(i, i+1), calCount.getOrDefault(expression.substring(i, i+1), 0)+1);
                point = i+1;
            }
        }

        number.add(Integer.parseInt(expression.substring(point, expression.length())));

        /*System.out.println("---number---");
        for(int num : number) {
            System.out.print(num + " ");
        }

        System.out.println("\n\n---calculate---");
        for(String cal : calculate) {
            System.out.print(cal + " ");
        }

        /*System.out.println("\n\n---calCount---");
        for(String cal : calCount.keySet()) {
            System.out.println(cal + " : " + calCount.get(cal));
        }*/

        size = calculate.size();
        DFS(0, "");

        System.out.println();

        System.out.println("MAX : " + MAX);

        return MAX;
    }

    public static void DFS(int count, String cal) {
        if (count == size) {
            MAX = Math.max(MAX, Math.abs(number.get(0)));
            return;
        }

        for(int i=0; i<calculate.size(); i++) {
            if (cal.equals("")) {
                int num1 = number.remove(i);
                int num2 = number.remove(i);
                String c = calculate.remove(i);
                calCount.put(c, calCount.get(c) - 1);

                if (c.equals("+")) {
                    number.add(i, (num1 + num2));
                    DFS(count+1, "+");
                    calculate.add(i, "+");
                } else if (c.equals("-")) {
                    number.add(i, num1 - num2);
                    DFS(count+1, "-");
                    calculate.add(i, "-");
                } else if (c.equals("*")) {
                    number.add(i, (num1 * num2));
                    DFS(count+1, "*");
                    calculate.add(i, "*");
                }
                calCount.put(c, calCount.get(c) + 1);
                number.remove(i);
                number.add(i, num2);
                number.add(i, num1);
            } else {
                if (calCount.get(cal) > 0) {
                    for(int j=0; j<calculate.size(); j++) {
                        if (calculate.get(j).equals(cal)) {
                            int num1 = number.remove(j);
                            int num2 = number.remove(j);
                            String c = calculate.remove(j);
                            calCount.put(c, calCount.get(c) - 1);
        
                            if (c.equals("+")) {
                                number.add(j, (num1 + num2));
                                DFS(count+1, "+");
                                calculate.add(j, "+");
                            } else if (c.equals("-")) {
                                number.add(j, num1 - num2);
                                DFS(count+1, "-");
                                calculate.add(j, "-");
                            } else if (c.equals("*")) {
                                number.add(j, (num1 * num2));
                                DFS(count+1, "*");
                                calculate.add(j, "*");
                            }
                            calCount.put(c, calCount.get(c) + 1);
                            number.remove(j);
                            number.add(j, num2);
                            number.add(j, num1);
                        }
                    }
                } else {
                    DFS(count, "");
                }
            }
        }

    }
    
}