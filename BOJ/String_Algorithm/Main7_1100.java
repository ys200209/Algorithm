package BOJ.String_Algorithm;

import java.io.*;
import java.util.*;

public class Main7_1100 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] board = new String[8][8];
        for(int i=0; i<8; i++) {
            board[i] = br.readLine().split("");
        }

        int answer=0;
        int index=0;
        while(index < 64) {
            if ((index / 8 % 2 == 0 && index % 2 ==0) || (index / 8 % 2 == 1 && index % 2 == 1)) {
                if (board[index/8][index%8].equals("F")) answer++;
            }
            index++;
        }
        System.out.println(answer);
    }
}
