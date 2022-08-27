import java.util.*;

public class Main2022_4 {
    static int N, diff, total=(int)1e9;
    static int[] apeach, lion, result;
    
    public static void main(String[] args) {

        // ¾ç±Ã ´ëÈ¸ (Level : 2)
        //System.out.println(Arrays.toString(solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0}))); 
        // [0,2,2,0,1,0,0,0,0,0,0]
        //System.out.println(Arrays.toString(solution(1, new int[]{1,0,0,0,0,0,0,0,0,0,0}))); 
        // [-1]
        System.out.println(Arrays.toString(solution(9, new int[]{0,0,1,2,0,1,1,1,1,1,1}))); 
        // [1,1,2,0,1,2,2,0,0,0,0]
        //System.out.println(Arrays.toString(solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3}))); 
        // [1,1,1,1,1,1,1,1,0,0,2]
        //System.out.println(Arrays.toString(solution(10, new int[]{0,0,0,0,0,0,0,0,0,1,9}))); 
        // [-1]

    }

    public static int[] solution(int n, int[] info) {
        apeach = new int[11];
        lion = new int[11];
        result = new int[11];

        for(int i=0; i<info.length; i++) {
            apeach[i] = info[i];
        }

        N = n;
        DFS(0, 0);

        System.out.println("diff : " + diff);
        if (diff <= 0) return new int[]{-1};
        else return result;
    }

    public static void DFS(int index, int count) {
        if (count == N) {
            int apeachScore = getApeachScore();
            int lionScore = getLionScore();
            
            if (diff <= lionScore - apeachScore) {
                if (diff == lionScore - apeachScore) {
                    for(int i=10; i>=0; i--) {
                        if (result[i] < lion[i]) break;
                        else if (result[i] == lion[i]) continue;
                        else return;
                    }
                }
                
                for(int i=0; i<11; i++) {
                    result[i] = lion[i];
                    diff = lionScore - apeachScore;
                }
            }

            return;
        }

        for(int i=index; i<11; i++) {
            lion[i] = N >= count + apeach[i] + 1 ? apeach[i] + 1 : N - count;
            DFS(i+1, count + lion[i]);
            lion[i] = 0;
            
        }

    }

    public static int getApeachScore() {
        int score = 0;

        for(int i=0; i<11; i++) {
            if (apeach[i] != 0 && apeach[i] >= lion[i]) score += (10 - i);
        }

        return score;
    }

    public static int getLionScore() {
        int score = 0;

        for(int i=0; i<11; i++) {
            if (apeach[i] < lion[i]) score += (10 - i);
        }

        return score;
    }

}