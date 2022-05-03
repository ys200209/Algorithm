import java.util.*;

class Main2019_Internship_2 {

    public static void main(String[] args) {

        // System.out.println(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
        // [2, 1, 3, 4]

        System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
        // 

    }
    
    public static int[] solution(String s) {
        System.out.println("S : " + s);
        s = s.replace("{", "");
        System.out.println("S : " + s);

        String[] A = s.split("\\},");
        int[] answer = new int[A.length-1];
        System.out.println(Arrays.toString(A));
        
        Arrays.sort(A, (s1, s2) -> {
            return s1.length() - s2.length();
        });

        Set<Integer> set = new HashSet<>();
        

        return answer;
    }

}