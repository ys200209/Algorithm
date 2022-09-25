package KAKAO_BLIND_RECRUITMENT.Kakao2023;

import java.util.*;

public class MainKakao2023_5 {
    static int N=50;
    static Map<String, List<Cell>> valueMap = new HashMap<>();
    static Cell[][] board = new Cell[51][51];
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new String[]{"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"})));
        // ["EMPTY", "group"]

        System.out.println(Arrays.toString(solution(
                new String[]{
                        "UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c",
                        "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1",
                        "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"})));
        // ["d", "EMPTY"]
    }

    public static String[] solution(String[] commands) {
        String[] answer;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                board[i][j] = new Cell(null, new ArrayList<>(), null);
            }
        }

        for(int i=0; i<commands.length; i++) {
            String[] split = commands[i].split(" ");
            String command = split[0];
            if (command.equals("UPDATE")) {
                if (split.length == 4) {
                    UPDATE1(Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3]);
                } else if (split.length == 3) {
                    UPDATE2(split[1], split[2]);
                }
            } else if (command.equals("MERGE")) MERGE(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]));
            else if (command.equals("UNMERGE")) UNMERGE(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            else PRINT(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }

        answer = new String[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private static void PRINT(int r, int c) {
        Cell cell = board[r][c];
        if (cell.reference != null) cell = cell.reference;
        result.add(cell.value == null ? "EMPTY" : cell.value);
    }

    private static void UNMERGE(int r, int c) {
        Cell cell = board[r][c];
        if (cell.reference != null) cell = cell.reference;

        for (Cell ref : cell.beReferenced) {
            ref.reference = null;
            if (valueMap.get(ref.value) == null) valueMap.put(ref.value, new ArrayList<>());

            valueMap.get(ref.value).add(ref);
        }

        cell.beReferenced.clear();
        board[r][c].value = cell.value;
        if (valueMap.get(board[r][c].value) == null) valueMap.put(board[r][c].value, new ArrayList<>());
        if (valueMap.get(cell.value) != null) valueMap.get(cell.value).remove(cell);
        valueMap.get(board[r][c].value).add(board[r][c]);
        cell.value = null;
    }

    private static void MERGE(int r1, int c1, int r2, int c2) {
        Cell cell1 = board[r1][c1];
        Cell cell2 = board[r2][c2];

        if (cell1.reference != null) cell1 = cell1.reference;
        if (cell2.reference != null) cell2 = cell2.reference;


        if (cell1.value != null) { // 1 로 통합
            if (valueMap.get(cell2.value) != null) valueMap.get(cell2.value).remove(cell2);
            cell2.value = null;
            cell2.reference = cell1;
            cell1.beReferenced.add(cell2);
        } else { // 2 로 통합
            if (valueMap.get(cell1.value) != null) valueMap.get(cell1.value).remove(cell1);
            cell1.value = null;
            cell1.reference = cell2;
            cell2.beReferenced.add(cell1);
        }

    }

    private static void UPDATE2(String value1, String value2) {
        if (value1.equals(value2)) return;
        
        Queue<Cell> removeQueue = new LinkedList<>();
        
        for (Cell cell : valueMap.get(value1)) {
            cell.value = value2;
            if (valueMap.get(value2) == null) valueMap.put(value2, new ArrayList<>());
            
            removeQueue.offer(cell);
            valueMap.get(value2).add(cell);
        }

        if (valueMap.get(value1) == null) return;
        while(!removeQueue.isEmpty()) {
            valueMap.get(value1).remove(removeQueue.poll());
        }
        
    }

    private static void UPDATE1(int r, int c, String value) {

        Cell cell = board[r][c];
        if (cell.reference != null) cell = cell.reference;

        if (valueMap.get(cell.value) != null) valueMap.get(cell.value).remove(cell);
        cell.value = value;
        
        if (valueMap.get(value) == null) valueMap.put(value, new ArrayList<>());
        valueMap.get(value).add(board[r][c]);
    }

    static class Cell {
        String value;
        List<Cell> beReferenced;
        Cell reference;

        public Cell(String value, List<Cell> beReferenced, Cell reference) {
            this.value = value;
            this.beReferenced = beReferenced;
            this.reference = reference;
        }
    }

}