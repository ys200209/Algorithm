import java.util.*;

public class Brute_Force2 {
    static int MAX, size, number, result=0;
    static String str="";
    static String[] str_list;
    static boolean[] visited, list;
    static HashSet<Integer> set = new HashSet<>();
    static ArrayList<String> arrayList = new ArrayList<>();
    


    public static void main(String[] args) {

        System.out.println(solution("17"));
        // System.out.println(solution("19"));
        // System.out.println(solution("011"));

    }
    
    public static int solution(String numbers) {
        size = numbers.length();
        str_list = numbers.split("");
        visited = new boolean[size];
        
        
        for(String num : str_list) arrayList.add(num);
        Collections.sort(arrayList, Collections.reverseOrder());

        checkList(); // 소수 = False, 소수가 아니라면 True

        DFS(0);

        return result;
    }

    public static void checkList() {
        String s = "";
        for(int i=0; i<arrayList.size(); i++) {
            s += arrayList.get(i);
        }

        MAX = Integer.parseInt(s) + 1;
        list = new boolean[MAX];
        list[0] = true;
        list[1] = true;

        for(int i=2; i<MAX; i++) {
            if (!list[i]) {
                for(int j=i*2; j<MAX; j+=i) {
                    list[j] = true;
                }
            }
        }

    }

    public static void DFS(int count) {
        if (count == size) return;

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    str += str_list[j];
                    count += 1;
                    number = Integer.parseInt(str);
                    if (set.add(number)) {
                        if (!list[number]) {
                            result += 1;
                        }
                    }
                    DFS(count);
                    count -= 1;
                    str = str.substring(0, str.length()-1);
                    visited[j] = false;
                }
            }
        }

    }

}