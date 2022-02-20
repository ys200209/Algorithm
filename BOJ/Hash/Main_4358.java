import java.util.*;
import java.io.*;

public class Main_4358 {
    static double total=0.0;
    static Map<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str;
        while((str = br.readLine()) != null) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            total+=1;
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(String s : list) {
            double p = (double)((map.get(s)*100.0)/total);
            sb.append(s + " " + String.format("%.4f", p) + "\n");
        }
        System.out.println(sb);
    }
}