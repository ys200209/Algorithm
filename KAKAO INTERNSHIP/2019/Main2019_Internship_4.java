import java.util.*;

class Main2019_Internship_4 {
    static ArrayList<Stone> list = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3)); // 3

    }
    
    public static int solution(int[] stones, int k) {
        int answer = 0;
        

        for(int i=0; i<stones.length; i++) {
            if (i == 0) {
                list.add(new Stone(-1, 1));
            } else if (i == stones.length-1) {
                list.add(new Stone(i-1, stones.length));
            } else {
                list.add(new Stone(i-1, i+1));
            }
        }

        boolean isBreak = false;
        while(true) {
            answer++;
            
            int position = 0;
            while(position < stones.length) {

                if (stones[position] <= answer) {

                    if (position == 0) {
                        list.get(position).back = list.get(position+1).back;
                        list.get(position+1).front = -1;
                    } else if (position == stones.length - 1) {
                        list.get(position-1).back = stones.length;
                    } else {
                        list.get(position-1).back = list.get(position).back;
                        list.get(position+1).front = list.get(position).front;
                    }

                }

                if (list.get(position).back - position >= k) {
                    isBreak = true;
                    // System.out.println(list.get(position).back + " - " + position + " : " + (list.get(position).back - position));
                    break;
                }
                
                // System.out.println("answer : " + answer + ", position : " + position);
                position = list.get(position).back;
                
            }

            if (isBreak) break;
        }

        return answer;
    }

}

class Stone {

    int front;
    int back;

    public Stone(int front, int back) {
        this.front = front;
        this.back = back;
    }

}