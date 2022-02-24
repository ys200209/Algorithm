import java.util.*;
import java.io.*;

public class Main_11507 {
    static Map<String, ArrayList<Integer>> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cardPack = br.readLine();

        map.put("P", new ArrayList<>());
        map.put("K", new ArrayList<>());
        map.put("H", new ArrayList<>());
        map.put("T", new ArrayList<>());

        for(int i=0; i<cardPack.length(); i+=3) {
            String card = cardPack.substring(i, i+3);
            String type = card.substring(0, 1);
            int number = Integer.parseInt(card.substring(1, 3));

            if (map.get(type).contains(number)) {
                System.out.println("GRESKA");
                return;
            }

            map.get(type).add(number);

        }

        sb.append(13-map.get("P").size() + " ");
        sb.append(13-map.get("K").size() + " ");
        sb.append(13-map.get("H").size() + " ");
        sb.append(13-map.get("T").size() + " ");

        System.out.println(sb);

    }

}