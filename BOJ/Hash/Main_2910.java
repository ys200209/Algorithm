import java.util.*;
import java.io.*;

public class Main_2910 {
    static int N, C;
    static Map<Integer, Number> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            if (map.get(num) == null) map.put(num, new Number(1, i));
            else {
                Number number = map.get(num);
                number.count += 1;
                map.put(num, number);
            }
            i++;
        }

        ArrayList<Map.Entry<Integer, Number>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (entry1, entry2) -> {
            if (entry1.getValue().count == entry2.getValue().count) {
                return entry1.getValue().index - entry2.getValue().index;
            } else {
                return entry2.getValue().count - entry1.getValue().count;
            }
        });

        for(Map.Entry<Integer, Number> entry : list) {
            for(i=0; i<entry.getValue().count; i++) sb.append(entry.getKey() + " ");
        }

        System.out.println(sb);
    }

}

class Number {

    int count;
    int index;

    public Number(int count, int index) {
        this.count = count;
        this.index = index;
    }

}