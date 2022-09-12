package BOJ.Back_Tracking;

import java.io.*;
import java.util.*;

public class Main14_1941 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N=5, result=0;
    static Member[][] board = new Member[5][5];
    static List<Member> members = new ArrayList<>();
    static Queue<Member> queue = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException { // 15% Error

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                Member member = new Member(i, j, split[j]);
                board[i][j] = member;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                Member member = board[i][j];
                members.add(member);
                DFS(member, member.name.equals("S") ? 1 : 0);
                members.remove(member);
            }
        }
        System.out.println(result);
    }

    private static void DFS(Member member, int count) {
        if (members.size() == 7) {
            if (count >= 4 && isGroup()) {
                print();
                result++;
//                System.out.println("\nGROUP !!!");
            }
            return;
        }

        for(int i=member.x; i<N; i++) {
            for(int j=(i==member.x ? member.y+1 : 0); j<N; j++) {
                Member addMember = board[i][j];

                members.add(addMember);
                DFS(addMember, addMember.name.equals("S") ? count+1 : count);
                members.remove(addMember);
            }
        }
    }

    private static boolean isGroup() { // 모든 그룹원들이 서로 붙어있는지 확인
        int groupCount = 0;
        visited = new boolean[5][5];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (members.contains(board[i][j]) && !visited[i][j]) {
                    groupCount++;

                    if (groupCount > 1) return false; // 그룹 단위가 2개 이상이라면 모두 붙어있는 것이 아니므로 거짓.

                    BFS(board[i][j]);
                }
            }
        }
        return true;
    }

    private static void BFS(Member member) {
        queue.clear();
        queue.offer(member);
        while(!queue.isEmpty()) {
            Member poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (!members.contains(board[nx][ny])) continue;

                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.offer(board[nx][ny]);
            }

        }

    }

    private static void print() {
        String[][] prints = new String[5][5];
        for (Member member : members) {
            prints[member.x][member.y] = "O";
        }

        for(int i=0; i<N; i++) {
            System.out.println();
            for(int j=0; j<N; j++) {
                System.out.print(prints[i][j] == null ? "X" : "O");
            }
        }
        System.out.println();
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