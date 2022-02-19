import java.io.*;
import java.util.*;

public class Main_16165 {
    static int N, M;
    static Map<String, ArrayList<String>> kpop = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            String groupName = br.readLine();
            int memberCount = Integer.parseInt(br.readLine());

            kpop.put(groupName, new ArrayList<>());

            for(int j=0; j<memberCount; j++) {
                kpop.get(groupName).add(br.readLine());
            }
        }

        for(int i=0; i<M; i++) {
            String name = br.readLine();
            int quiz = Integer.parseInt(br.readLine());

            if (quiz == 1) {
                for(String groupName : kpop.keySet()) {
                    if (kpop.get(groupName).contains(name)) sb.append(groupName + "\n");
                }
            } else {
                for(String groupName : kpop.keySet()) {
                    if (groupName.equals(name)) {
                        Collections.sort(kpop.get(groupName));
                        for(String memberName : kpop.get(groupName)) {
                            sb.append(memberName + "\n");
                        }
                    }
                }
            }
        }

        System.out.println(sb);

    }
}