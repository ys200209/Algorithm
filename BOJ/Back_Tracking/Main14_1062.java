import java.util.*;
import java.io.*;

public class Main14_1062 {
    static int N, K, answer=0;
    static boolean[] visited;
    static ArrayList<String> words = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>();
    static ArrayList<Map.Entry<String, Integer>> list;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 5;
        
        visited = new boolean[26];

        for(int i=0; i<N; i++) {
            String word = replaceWord(br.readLine());
            if (word.equals("")) answer++;
            else {
                words.add(word);
                for(String w : word.split("")) {
                    if (!visited[w.charAt(0) - 'a']) map.put(w, map.getOrDefault(w, 0) + 1);
                } 
            }
        }
        
        list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (entry1, entry2) -> {
            return entry2.getValue() - entry1.getValue();
        });

        DFS(0, 0);

        System.out.println(answer);
    }

    public static String replaceWord(String word) {
        word.replace("a", "");
        word.replace("n", "");
        word.replace("t", "");
        word.replace("i", "");
        word.replace("c", "");

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        return word;
    }

    public static void DFS(int index, int count) {
        if (count >= K) {
            int word_cnt = 0;

            for(String w : words) {
                if (checkWord(w)) word_cnt++;
            }

            answer = Math.max(answer, word_cnt);
            return;
        }

        for(int i=index; i<list.size(); i++) {
            if (!visited[list.get(i).getKey().charAt(0) - 'a']) { // 없는 것만
                visited[list.get(i).getKey().charAt(0) - 'a'] = true;
                DFS(i+1, count+1);
                visited[list.get(i).getKey().charAt(0) - 'a'] = false;
            }
        }
        
    }

    public static boolean checkWord(String word) {
        for(int i=0; i<word.length(); i++) {
            if (!visited[word.charAt(i) - 'a']) return false;
        }
        return true;
    }

}