package BOJ.Back_Tracking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main14_1941 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N = 5, result = 0;
    static Member[][] board = new Member[5][5];
    static boolean[][] visited; // 전체 방문 처리
    static boolean[][] sVisited = new boolean[5][5]; // 이다솜 그룹의 멤버 방문 처리
    static List<Member> members = new ArrayList<>();
    static List<Member> sMember = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                Member member = new Member(i, j, split[j]);
                board[i][j] = member;
                if (member.name.equals("S")) sMember.add(member);
            }
        }

        for (int i = 0; i < sMember.size()-3; i++) { // 이다솜 파는 최소 4명 이상이어야 하기 때문에 -3을 해주어 최댓값을 조정함 (어차피 그 뒤부턴 이다솜 파가 무조건 4명 미만이 되기 때문에 계산할 필요가 없음)
            Member member = sMember.get(i);
            visited = new boolean[5][5];
            sVisited[member.x][member.y] = true;
            members.add(member);
            DFS(member, 1, 1);
            members.remove(member);
        }

        System.out.println(result);
    }

    private static void DFS(Member sMem, int depth, int count) {
        if (depth == 7) {
            if (count >= 4) result++; // 다솜파가 우세할 때만 경우의 수 +1

            /*sb = new StringBuilder();
            for (int i = 0; i < members.size(); i++) {
                sb.append(members.get(i).name);
            }
            if (sb.toString().contains("1111111")) {
                System.out.println("1111111 is True!!");
            }*/
//            System.out.println("sb = " + sb);
            return;
        }

        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            int x = member.x;
            int y = member.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (visited[nx][ny] || sVisited[nx][ny]) continue;

                if (nx < sMem.x || (nx == sMem.x && ny <= sMem.y)) continue;

                Member addMember = board[nx][ny];

                visited[nx][ny] = true;
                members.add(addMember);

                if (board[nx][ny].name.equals("S")) DFS(addMember, depth + 1, count + 1);
                else DFS(addMember, depth + 1, count);

                members.remove(addMember);
                visited[nx][ny] = false;
            }
        }
    }

    static class Member {
        int x;
        int y;
        String name;

        public Member(int x, int y, String name) {
            this.x = x;
            this.y = y;
            this.name = name;
        }
    }
}