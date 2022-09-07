package BOJ.Implementation;

import java.io.*;
import java.util.*;

public class Main2_19236 {
         // 1부터 순서대로 ↑, ↖, ←, ↙, ↓, ↘, →, ↗ 를 의미
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int score = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] board = new int[4][4];
        Fish[] fishes = new Fish[17];

        for(int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                int number = Integer.parseInt(st.nextToken());
                int vector = Integer.parseInt(st.nextToken()) - 1;
                Fish fish = new Fish(i, j, number, vector, false);
                board[i][j] = number;
                fishes[number] = fish;
                j++;
            }
        }

        int eatFishNumber = board[0][0];
        Fish eatFish = fishes[eatFishNumber];
        eatFish.isDead = true;
        Shark shark = new Shark(0, 0, eatFish.vector);
        board[0][0] = -1;

//        print(board);

        startGame(board, fishes, shark, eatFishNumber);

//        System.out.println("recursionCount = " + recursionCount);
        System.out.println(score);
    }

    private static void startGame(int[][] board, Fish[] fishes, Shark shark, int eatSum) {
        score = Math.max(score, eatSum);

        Fish[] tempFishes = copyFishes(fishes);
        int[][] tempBoard = moveFishes(board, tempFishes);

        // 아래는 moveShark(); 따로 메서드 안뽑음.
        int nx = shark.x + dx[shark.vector];
        int ny = shark.y + dy[shark.vector];

        while(nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
            if (tempBoard[nx][ny] != 0) {
                int eatFishNumber = tempBoard[nx][ny];
                Fish eatFish = tempFishes[eatFishNumber];
                tempBoard[shark.x][shark.y] = 0;
                tempBoard[nx][ny] = -1;
                eatFish.isDead = true;
                startGame(tempBoard, tempFishes, new Shark(nx, ny, eatFish.vector), eatSum + eatFishNumber);
                eatFish.isDead = false;
                tempBoard[nx][ny] = eatFishNumber;
                tempBoard[shark.x][shark.y] = -1;
            }

            nx += dx[shark.vector];
            ny += dy[shark.vector];
        }


    }

    /*private static void print(int[][] tempBoard) {
        System.out.println();
        for(int i=0; i<4; i++) {
            System.out.println();
            for(int j=0; j<4; j++) {
                System.out.print(tempBoard[i][j] + " ");
            }
        }
        System.out.println();
    }*/

    private static int[][] moveFishes(int[][] board, Fish[] tempFishes) {
        int[][] tempBoard = copyBoard(board);

        for(int i=1; i<=16; i++) {
            if (!tempFishes[i].isDead) {
                Fish moveFish = tempFishes[i];
                int x = moveFish.x;
                int y = moveFish.y;
                int vector = moveFish.vector;

                for(int j=0; j<8; j++) {
                    int nx = x + dx[(vector+j)%8];
                    int ny = y + dy[(vector+j)%8];

                    if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue; // 수족관 밖 이동 불가

                    if (tempBoard[nx][ny] == -1) continue; // 상어가 있는 곳 이동 불가

                    int changeFishNumber = tempBoard[nx][ny];

//                    System.out.println(moveFish.number + " < - > " + changeFishNumber);

                    moveFish.x = nx;
                    moveFish.y = ny;
                    moveFish.vector = (vector+j)%8;
                    tempBoard[nx][ny] = moveFish.number;

                    if (changeFishNumber != 0) {
                        Fish changeFish = tempFishes[changeFishNumber];
                        changeFish.x = x;
                        changeFish.y = y;
                        tempBoard[x][y] = changeFish.number;
                    } else {
                        tempBoard[x][y] = 0;
                    }

                    break;
                }
            }
        }

        return tempBoard;
    }

    private static Fish[] copyFishes(Fish[] fishes) {
        Fish[] tempFishes = new Fish[17];
        for(int i=1; i<=16; i++) {
            Fish fish = fishes[i];
            tempFishes[i] = new Fish(fish.x, fish.y, fish.number, fish.vector, fish.isDead);
        }
        return tempFishes;
    }

    private static int[][] copyBoard(int[][] board) {
        int[][] tempBoard = new int[4][4];
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                tempBoard[i][j] = board[i][j];
            }
        }
        return tempBoard;
    }

    static class Fish {
        int x;
        int y;
        int number;
        int vector;
        boolean isDead;

        public Fish(int x, int y, int number, int vector, boolean isDead) {
            this.x = x;
            this.y = y;
            this.number = number;
            this.vector = vector;
            this.isDead = isDead;
        }
    }

    static class Shark {
        int x;
        int y;
        int vector;

        public Shark(int x, int y, int vector) {
            this.x = x;
            this.y = y;
            this.vector = vector;
        }
    }

}
