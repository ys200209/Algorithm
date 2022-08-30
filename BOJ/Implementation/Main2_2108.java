package BOJ.Implementation;

import java.io.*;
import java.util.*;

public class Main2_2108 {
    static int N, sum=0;
    static List<Integer> list = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

//        System.out.println("Math.round(sum*1.0/N) : " + Math.round(sum*1.0/N));
        sb.append(Math.round(sum*1.0/N) + "\n");

        Collections.sort(list);
        sb.append(list.get(list.size()/2) + "\n");

        if (N == 1) sb.append(list.get(0) + "\n");
        else {
            List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
            Collections.sort(entries, (entry1, entry2) -> {
                if (entry1.getValue() == entry2.getValue()) {
                    return entry1.getKey() - entry2.getKey();
                } else {
                    return entry2.getValue() - entry1.getValue();
                }
            });

            Map<Integer, Integer> result = new HashMap<>();
            for(Map.Entry<Integer, Integer> entry : entries) {
                if (result.isEmpty()) {
                    result.put(entry.getKey(), entry.getValue());
                } else {
                    for(int key : result.keySet()) {
                        if (result.get(key) == entry.getValue()) sb.append(entry.getKey() + "\n");
                        else sb.append(key + "\n");
                    }
                    break;
                }
            }
        }

        sb.append(list.get(N-1) - list.get(0));

        System.out.println(sb);
    }

}
