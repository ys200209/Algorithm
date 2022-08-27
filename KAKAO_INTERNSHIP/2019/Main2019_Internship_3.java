import java.util.*;

class Main2019_Internship_3 {
    static String[] list;
    static Set<String> set = new HashSet<>();
    static boolean[] visited;

    public static void main(String[] args) {

        // System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
        // 2

        // System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
        // 2

        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
        // 3

    }
    
    public static int solution(String[] user_id, String[] banned_id) {
        list = new String[banned_id.length];
        Arrays.fill(list, "");
        visited = new boolean[user_id.length];

        for(int i=0; i<banned_id.length; i++) {
            String[] ban = banned_id[i].split("");

            for(int j=0; j<user_id.length; j++) {

                if (ban.length != user_id[j].length()) continue;

                String str = "";
                for(int k=0; k<ban.length; k++) {
                    if (banned_id[i].substring(k, k+1).equals("*")) {
                        ban[k] = user_id[j].substring(k, k+1);
                    }
                    str += ban[k];
                }

                if (str.equals(user_id[j])) { //  && !list.contains(j)
                    list[i] += j;
                }
            }
        }

        DFS(0, 0);

        return set.size();
    }

    public static void DFS(int index, int count) {
        if (count == list.length) {
            String s = "";

            for(int i=0; i<visited.length; i++) {
                if (visited[i]) s += i;
            }
            set.add(s);

            return;
        }

        for(int i=index; i<list.length; i++) {
            
            for(int j=0; j<list[i].length(); j++) {
                int n = Integer.parseInt(list[i].substring(j, j+1));

                if (!visited[n]) {
                    visited[n] = true;
                    DFS(i+1, count+1);
                    visited[n] = false;
                }

            }
           
        }


    }

}