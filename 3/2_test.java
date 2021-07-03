import java.util.List;
import java.util.*;

class Main3_2 {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2,4,5,4,6));
        int M = 8;
        int K = 3;
        int sum = 0;
        int count = 0;

        Collections.sort(list);
        for(int i=0; i<M; i++) {
            if(count==K) {
                sum += list.get(list.size()-2);
                count = 0;
            } else {
                sum += list.get(list.size()-1);
                count++;
            }
        }
        System.out.println(sum);
    }
    
}
