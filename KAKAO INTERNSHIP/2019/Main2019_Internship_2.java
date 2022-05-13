import java.util.*;

class Main2019_Internship_2 {

    public static void main(String[] args) {

        System.out.println(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
        // [2, 1, 3, 4]

        //System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
        // 

    }
    
    public static int[] solution(String s) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        s = s.substring(2,s.length());
        s = s.substring(0,s.length()-2).replace("},{","-");
        String str[] = s.split("-");

        Arrays.sort(str, (s1, s2) -> {
            return s1.length() - s2.length();
        });
        
        for(String numbers : str) {
            String[] number = numbers.split(",");

            for(String n : number) {
                if (!answer.contains(Integer.parseInt(n))) {
                    answer.add(Integer.parseInt(n));
                    break;
                }
            }
        }
        
        int[] result = new int[answer.size()];

        for(int i=0; i<answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}