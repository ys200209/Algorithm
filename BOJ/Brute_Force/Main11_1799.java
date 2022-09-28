package BOJ.Brute_Force;

import java.util.*;

public class Main11_1799 {
    static Map<String, Integer> vector = new HashMap<>();
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static Load[][] loads;

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU")); // 7
//        System.out.println(solution("LULLLLLLU")); // 7
    }

    public static int solution(String dirs) {
        int answer = 0;

        vector.put("U", 0);
        vector.put("D", 1);
        vector.put("L", 2);
        vector.put("R", 3);
//        visited = new boolean[11][11];
        loads = new Load[11][11];
        for(int i=0; i<11; i++) {
            for(int j=0; j<11; j++) {
                loads[i][j] = new Load(i, j, new HashSet<>());
            }
        }

        String[] split = dirs.split("");
        int x = 5;
        int y = 5;
        for (String s : split) {
            int nx = x + dx[vector.get(s)];
            int ny = y + dy[vector.get(s)];

            if (nx < 0 || nx >= 11 || ny < 0 || ny >= 11) continue;

            if (loads[x][y].visited.add(loads[nx][ny])) answer++;
            loads[nx][ny].visited.add(loads[x][y]);

            x = nx;
            y = ny;
        }

        return answer;
    }

    static class Load {
        int x;
        int y;
        Set<Load> visited;

        public Load(int x, int y, Set<Load> visited) {
            this.x = x;
            this.y = y;
            this.visited = visited;
        }
    }

}