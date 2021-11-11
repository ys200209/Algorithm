package Search;

import java.util.*;

public class Main2 {
    public static boolean[] visited;
    public static String number;
    public static ArrayList<Integer> list;

    public static void main(String[] args) {

        // 소수 찾기 (2)
        System.out.println(solution("17")); // 3
        System.out.println(solution("011")); // 2
        System.out.println(solution("1230"));

    }

    public static int solution(String numbers) {
        int answer = 0;
        boolean check = false;
        String[] str = numbers.split("");
        list = new ArrayList<>();
        
        for (int i=0; i<str.length; i++) {
            visited = new boolean[str.length];
            number = "";
            DFS(str, i);
        }

        for(int i=0; i<list.size(); i++) {
            if (list.get(i) == 0 || list.get(i) == 1) continue;
            if (list.get(i) == 2) {
                answer+=1; 
                continue; 
            }
            if (list.get(i) % 2 == 0) continue;

            for(int j=3; j<list.get(i)/2; j+=2) {
                if (list.get(i) % j == 0) {
                    check = true;
                    break;
                }
            }

            if (!check) {
                answer += 1;
                check = false;
            }
        }

        System.out.println("list = " + list);
        
        return answer;
    }

    public static void DFS(String[] str, int i) {
        if (i < 0 || i >= str.length) {
            return;
        }

        if (visited[i] == true) return;

        if (visited[i] == false) {
            number += str[i];
            if (!list.contains(Integer.parseInt(number))) {
                list.add(Integer.parseInt(number));
            }
        }

        visited[i] = true;

        for(int j=1; j<str.length-1; j++) {
            DFS(str, i-j);
            DFS(str, i+j);
        }
        

    }
    
}
