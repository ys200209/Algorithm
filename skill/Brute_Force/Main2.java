import java.util.*;

public class Main2 {
    static int size, result = 0;
    static String str="";
    static String[] list;
    static boolean[] visited;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    


    public static void main(String[] args) {

        // System.out.println(solution("17"));
        System.out.println(solution("19"));
        // System.out.println(solution("011"));

    }
    
    public static int solution(String numbers) {
        int answer=0;
        size = numbers.length();

        list = numbers.split("");
        visited = new boolean[list.length];        

        DFS(0);


        return result;
    }

    public static void DFS(int count) {
        if (count == size) return;

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    str += list[j];

                    if (!arrayList.contains(Integer.parseInt(str))) {
                        int number = Integer.parseInt(str);
                        arrayList.add(Integer.parseInt(str));

                        if (number > 1) {
                            if (number == 2 || number == 3 || number == 5 || number == 7) result+=1;
                            else if (number % 2 != 0 && number % 3 != 0 && number % 5 != 0) result+=1;  
                        }
                        
                    }
                    count += 1;
                    DFS(count);
                    count -= 1;
                    str = str.substring(0, str.length()-1);
                    visited[j] = false;
                }
            }
            
        }

    }

}