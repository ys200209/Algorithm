package BOJ.Implementation;

import java.io.*;
import java.util.*;

public class Main2_21608 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, score=0;
    static Position[][] board;
    static List<Position> posList = new ArrayList<>();
    static List<Integer> numList = new ArrayList<>();
    static Map<Integer, List<Integer>> friend = new HashMap<>();
    static Map<Integer, Position> sit = new HashMap<>();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new Position[N+1][N+1];

        for(int i=1; i<=N*N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            numList.add(num);
            friend.put(num, new ArrayList<>());
            while(st.hasMoreTokens()) {
                friend.get(num).add(Integer.parseInt(st.nextToken()));
            }
//            System.out.println("board[" + ((i+N-1)/N) + "][" + ((i-1)%N + 1) + "]");

            Position position = null;
            if (((i+N-1)/N == 1 || (i+N-1)/N == N) && ((i-1)%N + 1 == 1 || (i-1)%N + 1 == N)) { // 가장 구석 (r = 2)
                position = new Position((i+N-1)/N, (i-1)%N + 1, 0, 2);
            } else if (((i+N-1)/N == 1 || (i+N-1)/N == N) || ((i-1)%N + 1 == 1 || (i-1)%N + 1 == N)) { // 모서리 (r = 3)
                position = new Position((i+N-1)/N, (i-1)%N + 1, 0, 3);
            } else {
                position = new Position((i+N-1)/N, (i-1)%N + 1, 0, 4);
            }
            posList.add(position);
            board[(i+N-1)/N][(i-1)%N + 1] = position;
        }

        for (int n : numList) {
            Position sitPos = null;

            for(int i=0; i<friend.get(n).size(); i++) {

                if (sit.get(friend.get(n).get(i)) != null) {

                    Position sitFriend = sit.get(friend.get(n).get(i));
                    int x = sitFriend.x;
                    int y = sitFriend.y;

                    if (n == 3) {
                        System.out.println("3 friend : " + sitFriend.number);
                    }

                    Position nSitPos = null;
                    int count = 0;

                    for(int j=0; j<4; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];

                        if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

                        if (board[nx][ny] != null) continue;

                        nSitPos = board[nx][ny];

                        if (sitPos == null) sitPos = nSitPos;

                        if (sitPos != null) {
                            if (sitPos.r < nSitPos.r) sitPos = nSitPos;
                            else if (sitPos.r == nSitPos.r) {
                                if (sitPos.x > nSitPos.x) sitPos = nSitPos;
                                else if (sitPos.x == nSitPos.x) {
                                    if (sitPos.y > nSitPos.y) sitPos = nSitPos;
                                }
                            }
                        }
                    }


                }
            }

            if (sitPos == null) { // 아직 친구가 아무도 앉지 않았다면
                Collections.sort(posList);
                sitPos = posList.get(0); // 여기에 그냥 앉아버림
            }

            decreaseR(sitPos.x, sitPos.y); // 주변의 여유 공간 감소
            sitPos.number = n;
            sit.put(n, sitPos); // 앉은 사람과 위치 정보를 기록
            posList.remove(sitPos); // 남은 자리에 대한 정보에서 삭제
        }

        getScore();

        print();

        System.out.println("score = " + score);
    }

    private static void print() {
        for(int i=1; i<=N; i++) {
            System.out.println();
            for(int j=1; j<=N; j++) {
                System.out.print(board[i][j].number + " ");
            }
        }
        System.out.println();

        System.out.println("4 = (" + sit.get(4).x + ", " + sit.get(4).y + ")");
    }

    private static void getScore() {
        for (int n : numList) {
            Position me = sit.get(n);
            int x = me.x;
            int y = me.y;

            int count = 0;
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

                if (friend.get(n).contains(board[nx][ny].number)) count++;
            }

            System.out.println("getScore() n=" + n + ", count : " + count);

            if (count != 0) score += Math.pow(10, count-2);
        }
    }

    private static void decreaseR(int x, int y) {
        for(int i=0; i<4; i++) { // 주변의 여유 공간을 하나씩 줄임 (가운데 착석 했기 때문에)
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

            board[nx][ny].r--;
        }
    }

    static class Position implements Comparable<Position> {
        int x;
        int y;
        int number; // 학생 번호
        int r; // 인접한 비어있는 칸의 갯수

        public Position() {
        }

        public Position(int x, int y, int number, int r) {
            this.x = x;
            this.y = y;
            this.number = number;
            this.r = r;
        }

        @Override
        public int compareTo(Position p) {
            if (p.r == this.r) {
                if (p.x == this.x) {
                    return this.y - p.y;
                }
                return this.x - p.x;
            } else return p.r - this.r;
        }
    }

}
