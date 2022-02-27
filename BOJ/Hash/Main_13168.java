import java.util.*;
import java.io.*;

public class Main_13168 {
    static int N, R, M, K, yes=0, no=0;
    static Map<String, ArrayList<Tour>> tour = new HashMap<>();
    static ArrayList<String> tourList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        yes += R;

        br.readLine();

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
            tourList.add(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            String type = st.nextToken();
            String from = st.nextToken();

            if (tour.get(from) == null) tour.put(from, new ArrayList<Tour>());

            tour.get(from).add(new Tour(type, st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        
        for(int i=0; i<M-1; i++) {
            String from = tourList.get(i);
            String to = tourList.get(i+1);
            System.out.println("(M) " + from + " - " + to);
    
            for(Tour t : tour.get(from)) {
                if (t == null) {
                    System.out.println("null");
                } else {
                    System.out.println(from + " ~ " + t.to);
                }
                if (t.to.equals(to)) {
                    if (t.type.equals("Mugunghwa") || t.type.equals("ITX-Saemaeul") || t.type.equals("ITX-Cheongchun")) {
                        no += t.price;
                    } else if (t.type.equals("V-Train") || t.type.equals("S-Train")) {
                        yes += (t.price * 0.5);
                        no += t.price;
                    } else {
                        yes += t.price;
                        no += t.price;
                    }
                    System.out.println("yes : " + yes + ", no : " + no);
                    break;
                }
            }
        }

        if (yes < no) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    public static void yes_Ticket() {
        
    }

    public static void no_Ticket() {
        for(int i=0; i<M-1; i++) {
            String from = tourList.get(i);
            String to = tourList.get(i+1);



        }
    }
    
}

class Tour {

    String type;
    String to;
    int price;

    public Tour(String type, String to, int price) {
        this.type = type;
        this.to = to;
        this.price = price;
    }

}