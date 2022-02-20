import java.util.*;
import java.io.*;

public class Main_1302 {
    static int N;
    static Map<String, Integer> book = new HashMap<>();
    static String s = null;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String bookName = br.readLine();
            book.put(bookName, book.getOrDefault(bookName, 0) + 1);

            if (s == null) {
                s = bookName.toString();
            } else {
                if (book.get(s) < book.get(bookName)) {
                    s = bookName.toString();
                } else if (book.get(s) == book.get(bookName)) {
                    String[] str = new String[]{s, bookName};
                    Arrays.sort(str, (s1, s2) -> {
                        return s1.compareTo(s2);
                    });
                    s = str[0].toString();
                }
            }
        }
        System.out.println(s);
    }
}