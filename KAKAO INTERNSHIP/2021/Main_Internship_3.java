import java.util.*;

public class Main_Internship_3 {
    static int cursor;
    static LinkedList<Integer> list = new LinkedList<>();
    static Stack<Integer> removeStack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        System.out.println(solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
        // "OOOOXOOO"

        //System.out.println(solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
        // "OOXOXOOO"
    }

    public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        for(int i=0; i<n; i++) {
            list.add(i);
        }
        cursor = k;
        answer = sb.toString();

        for(int i=0; i<cmd.length; i++) {
            
            String[] arr = cmd[i].split(" ");
            String command = arr[0];
            int count=0;
            // System.out.println("command : " + command + ", cursor : " + cursor);
            if (command.equals("U") || command.equals("D")) count = Integer.parseInt(arr[1]);

            if (command.equals("U")) cursor -= count;
            else if (command.equals("D")) cursor += count;
            else if (command.equals("C")) {
                int remove = list.remove(cursor);
                // System.out.println("(C) remove : " + remove + ", cursor : " + cursor);
                removeStack.push(remove);
                if (cursor > list.size()-1) cursor = list.size();
                // else cursor += 1;
            } else if (command.equals("Z")) {
                int remove = removeStack.pop();
                // System.out.println("(Z) remove : " + remove + ", cursor : " + cursor);
                list.add(remove);
                Collections.sort(list);
            }
            
        }

        // System.out.println("list : " + list);
        int j=0;
        for(int i=0; i<n; i++) {
            if (list.get(j) == i) {
                sb.append("O");
                j++;
            } else sb.append("X");
        }
        
        System.out.println(sb);

        return answer;
    }
    
}

class Cell implements Comparable<Cell> {

    int index;
    char name;

    public Cell(int index, char name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public char getName() {
        return name;
    }

    @Override
    public int compareTo(Cell c1) {
        return this.getIndex() - c1.getIndex();
    }
}