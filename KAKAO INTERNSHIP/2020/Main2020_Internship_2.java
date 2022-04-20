import java.util.*;

class Main2020_Internship_2 {
    static Long result = Long.MIN_VALUE;
    static ArrayList<Long> numList = new ArrayList<>();
    static ArrayList<String> operList = new ArrayList<>();
    static boolean[] visited = new boolean[3];
    static String[] check = new String[]{"+", "-", "*"};
    
    public static void main(String[] args) {

        System.out.println(solution("100-200*300-500+20")); // 60420

    }

    public static long solution(String expression) {
        String n = "";
        for(int i=0; i<expression.length(); i++) {
            if (expression.charAt(i) - '0' < 0) {
                numList.add(Long.parseLong(n));
                operList.add(expression.substring(i, i+1));
                n = "";
            } else n += expression.substring(i, i+1);
        }
        numList.add(Long.parseLong(n));

        System.out.println(numList);
        System.out.println(operList);

        DFS(0, new String[3]);

        return result;
    }

    public static void DFS(int count, String[] opers) {
        if (count == 3) {
            
            ArrayList<Long> tempNum = new ArrayList<>(numList);
            ArrayList<String> tempOper = new ArrayList<>(operList);

            for(int i=0; i<3; i++) {
                for(int j=0; j<tempOper.size(); j++) {
                    if (opers[i].equals(tempOper.get(j))) { // 현재 우선순위와 연산자가 일치한다면
                        Long num = calc(tempNum.get(j), tempNum.get(j+1), tempOper.get(j));
                        tempNum.remove(j);
                        tempNum.set(j, num);
                        tempOper.remove(j);
                        j--;
                    }
                }
            }

            result = Math.max(result, Math.abs(tempNum.get(0)));
            return;
        }

        for(int i=0; i<3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                opers[count] = check[i];
                DFS(count+1, opers);
                opers[count] = "";
                visited[i] = false;
            }
        }

    }

    public static Long calc(Long num1, Long num2, String oper) {
        
        if (oper.equals("+")) return num1 + num2;
        else if (oper.equals("-")) return num1 - num2;
        else return num1 * num2;

    }

}