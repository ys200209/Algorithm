package KAKAO_BLIND_RECRUITMENT.Kakao2023;

import java.util.*;

public class MainKakao2023_6 {
    static int[] dx = {1, 0, 0, -1}; // d, l, r, u
    static int[] dy = {0, -1, 1, 0};
    static int[][] board;
    static Set<String>[][] visited;
    static Queue<Cell> pq = new PriorityQueue<>();
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution(3, 4, 2, 3, 3, 1, 5)); // "dllrl"
    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        board = new int[n+1][m+1];
        visited = new Set[n+1][m+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                visited[i][j] = new HashSet<>();
            }
        }
//        if ((Math.abs(x-r) + Math.abs(y-c)) % 2 != 0) return "impossable";

        Cell start = new Cell(x, y, new StringBuilder(), 0);
        pq.offer(start);

        exit(n, m, r, c, k);
        if (answer.size() == 0) return "impossible";

        System.out.println("answer = " + answer);
        Collections.sort(answer);

        return answer.get(0);
    }

    private static void exit(int n, int m, int r, int c, int k) {
        while(!pq.isEmpty()) {
            Cell poll = pq.poll();
            int x = poll.x;
            int y = poll.y;

//            if ((Math.abs(x-r) + Math.abs(y-c)) % 2 != 0) continue;

            if (poll.count == k && x == r && y == c) {
                answer.add(poll.str.toString());
                continue;
            }

            if (poll.count == k) continue;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;

                // d, l, r, u
                StringBuilder addStringBuilder = new StringBuilder(poll.str);
                if (i == 0) addStringBuilder.append("d");
                if (i == 1) addStringBuilder.append("l");
                if (i == 2) addStringBuilder.append("r");
                if (i == 3) addStringBuilder.append("u");

                if (!visited[nx][ny].add(addStringBuilder.toString())) continue;

                pq.offer(new Cell(nx, ny, addStringBuilder, poll.count+1));
            }
        }
    }

    static class Cell implements Comparable<Cell> {
        int x;
        int y;
        StringBuilder str;
        int count;

        public Cell(int x, int y, StringBuilder str, int count) {
            this.x = x;
            this.y = y;
            this.str = str;
            this.count = count;
        }

        @Override
        public int compareTo(Cell o) {
            return o.count - this.count;
        }
    }

}