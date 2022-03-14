import java.util.*;
import java.io.*;

public class Main16_1213 {
    static String[] str, result;
    static Map<String, Integer> map = new HashMap<>();
    static ArrayList<Map.Entry<String, Integer>> list;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().split("");
        System.out.println(Arrays.toString(str));
        
        for(String s : str) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        result = new String[str.length];


        if (str.length % 2 == 0) { // 문자열이 짝수개
            for(String s : map.keySet()) {
                if (map.get(s) % 2 == 1) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
        } else { // 문자열이 홀수개
            // 센터에 둘 문자열 탐색
            String center = null;
            for(String s : map.keySet()) {
                System.out.println(s + " : " + map.get(s));
                if (map.get(s) % 2 == 1) {
                    if (center != null) {
                        System.out.println("I'm Sorry Hansoo");
                        return;
                    } else {
                        center = s;
                        map.put(s, map.get(s)-1);
                    }
                }
                System.out.println("end");
            }
            result[result.length/2] = center;
        }
       
        match();
        for(String s : result) {
            sb.append(s);
        }

        System.out.println(sb);
        
    }

    public static void match() {

        list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (entry1, entry2) -> {
            return entry1.getKey().compareTo(entry2.getKey());
        });

        int index=0;
        for(int i=0; i<list.size(); i++) {
            int size = list.get(i).getValue()/2;

            while(size != 0) {
                result[index] = list.get(i).getKey();
                result[result.length-index-1] = list.get(i).getKey();
                size--;
                index++;
            }
        }

    }

}