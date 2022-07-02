import java.util.*;
import java.io.*;

public class Main_17281 {
    static int N, result=0, s, index=0;
    static ArrayList<Integer> score;
    static Map<Integer, Integer> map;
    static Queue<Integer> queue;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            score = new ArrayList<>();
            map = new HashMap<>();
            queue = new LinkedList<>();
            int first = 0;
            int out = 0;
            s = 0; // score

            map.put(1, 0);
            map.put(2, 0);
            map.put(3, 0);
            map.put(4, 0);

            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                if (j == 0) first = Integer.parseInt(st.nextToken());
                else score.add(Integer.parseInt(st.nextToken()));
                j++;
            }

            Collections.sort(score, (n1, n2) -> {
                if (n1 == 0 || n2 == 0) return n2 - n1;
                else return n1 - n2;
            });

            score.add(3, first);

            System.out.println("i : " + i + ", " + score);
            
            // index = 0; // 주자 번호
            while(out < 3) {
                // System.out.println("index : " + index);
                if (index == 9) index = 0;

                if (score.get(index) == 0) {
                    out++;
                    index++;
                    continue;
                }

                getScore(score.get(index));

                index++;
            }
            // System.out.println("s : " + s);
            // result = Math.max(result, s);
        }

        System.out.println("result : " + result);

    }

    public static void getScore(int n) {
        if (n == 4) {
            result++; // 타자

            while(!queue.isEmpty()) { // 나머지 선수들
                result += queue.poll();
            }
        } else {
            queue.offer(1);

            for(int i=1; i<n; i++) {
                queue.offer(0);
            }
    
            while(queue.size() >= 4) {
                result += queue.poll();
            }
        }
    }

}
