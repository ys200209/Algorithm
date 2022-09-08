package BOJ.Implementation;

import java.io.*;
import java.util.*;

public class Main2_21608 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    static Position[][] board;
    static List<Integer> studentNumbers = new ArrayList<>(); // 어떤 학생부터 앉을지 순서대로 담은 리스트
    static Student[] students; // 모든 학생 정보들

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new Position[N+1][N+1];
        students = new Student[N*N+1];

        for(int i=0; i<N*N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int number = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            students[number] = new Student(number, new ArrayList<>(Arrays.asList(a, b, c, d)));
            studentNumbers.add(number); // 어떤 학생부터 앉을지 순서대로 담은 리스트
            board[i/N+1][i%N+1] = new Position(i/N+1, i%N+1, null); // 아직 아무 학생도 앉지 않음 (null)
        }

        for(int i=0; i<studentNumbers.size(); i++) {
            int sitNumber = studentNumbers.get(i); // 앉을 학생의 번호

            Position position = search(sitNumber); // 학생이 앉을 위치(Position)
            position.student = students[sitNumber]; // 해당 위치에 학생을 앉힘

//            print();
        }

        int score = getScore();
        System.out.println(score);
    }

    private static int getScore() {
        int score = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                int count = 0;

                for(int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

                    if (board[i][j].student.friends.contains(board[nx][ny].student.number)) count++; // 친구가 옆에 앉아있다면
                }

                score += Math.pow(10, count-1);
            }
        }
        return score;
    }

    /*private static void print() {
        for(int i=1; i<=N; i++) {
            System.out.println();
            for(int j=1; j<=N; j++) {
                System.out.print((board[i][j].student == null ? "X" : board[i][j].student.number) + " ");
            }
        }
        System.out.println();
    }*/

    private static Position search(int sitNumber) {
        Position position = null;
        List<Integer> friends = students[sitNumber].friends;
        int maxEmptyCount = -1;
        int maxFriendCount = -1;

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if (board[i][j].student == null) { // 빈 자리라면 (이 곳에 앉으려고 할 때)
                    int emptyCount = 0;
                    int friendCount = 0;
                    for(int k=0; k<4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

                        if (board[nx][ny].student == null) emptyCount++;
                        else {
                            if (friends.contains(board[nx][ny].student.number)) { // 친한 친구 리스트에 있다면
                                friendCount++;
                            }
                        }
                    }

                    if (maxFriendCount < friendCount) {
                        position = board[i][j];
                        maxEmptyCount = emptyCount;
                        maxFriendCount = friendCount;
                    } else if (maxFriendCount == friendCount) {
                        if (maxEmptyCount < emptyCount) {
                            position = board[i][j];
                            maxEmptyCount = emptyCount;
                            maxFriendCount = friendCount;
                        } else if (maxEmptyCount == emptyCount) {
                            if (position.x > i) {
                                position = board[i][j];
                                maxEmptyCount = emptyCount;
                                maxFriendCount = friendCount;
                            } else if (position.x == i) {
                                if (position.y > j) {
                                    position = board[i][j];
                                    maxEmptyCount = emptyCount;
                                    maxFriendCount = friendCount;
                                }
                            }
                        }
                    }
                }
            }
        }
        return position;
    }

    static class Position { // 교실의 자리 위치

        int x;
        int y;
        Student student; // 해당 (x, y) 좌표에 어떤 학생이 앉아있는지를 나타냄

        public Position(int x, int y, Student student) {
            this.x = x;
            this.y = y;
            this.student = student;
        }
    }

    static class Student { // 학생 정보
        int number;
        List<Integer> friends;

        public Student(int number, List<Integer> friends) {
            this.number = number;
            this.friends = friends;
        }
    }

}
