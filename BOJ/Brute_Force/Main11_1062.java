package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_1062 {
    static int answer=(int)1e9;
    static List<NameCard> cards = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}})); // 4000
//        System.out.println(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})); // 120

    }

    public static int solution(int[][] sizes) {
        /*int w=0;
        int h=0;
        for(int i=0; i<sizes.length; i++) {
            w = Math.max(w, sizes[i][0]);
            h = Math.max(h, sizes[i][1]);
            cards.add(new NameCard(sizes[i][0], sizes[i][1], false));
        }
        answer = w * h;

        DFS(0);*/

        int w = 0;
        int h = 0;
        for (int[] size : sizes) {
            if (answer == 0) {
                w = size[0];
                h = size[1];
                answer = w*h;
            } else {
                // 뒤집은게 더 작은 사각형이라면
                if (Math.max(w, size[0]) * Math.max(h, size[1]) > Math.max(w, size[1]) * Math.max(h, size[0])) {
                    w = Math.max(w, size[1]);
                    h = Math.max(h, size[0]);
                } else {
                    w = Math.max(w, size[0]);
                    h = Math.max(h, size[1]);
                }
            }
        }

        return w*h;
    }

    /*private static void DFS(int index) {
        answer = Math.min(answer, getSize());

        for(int i=index; i<cards.size(); i++) {
            cards.get(i).isRotate = true;
            DFS(i+1);
            cards.get(i).isRotate = false;
        }
    }

    private static int getSize() {
        int w=0, h=0;

        for (NameCard card : cards) {
            w = Math.max(w, card.isRotate ? card.h : card.w);
            h = Math.max(h, card.isRotate ? card.w : card.h);
        }
        return w*h;
    }*/

    static class NameCard {
        int w;
        int h;

        public NameCard(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }

}