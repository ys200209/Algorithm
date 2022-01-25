import java.util.*;
import java.io.*;

public class Main16_1946 {
    static int T, N, result=0;
    static Queue<Person> pq = new PriorityQueue<>();
    static int[] score1, score2;
    static boolean isPass = false;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            score1 = new int[N];
            score2 = new int[N];
            
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int s1 = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());

                pq.offer(new Person(i, s1, s2));
            }
            
            int i=0;
            while(!pq.isEmpty()) {
                Person person = pq.poll();
                score1[i] = person.getScore1();
                score2[i] = person.getScore2();
                System.out.println(score1[i] + ", " + score2[i]);
                i++;
            }

            result = 1; // 가장 첫 사원
            for(i=1; i<N; i++){
                for(int j=0; j<i; j++) {
                    if (score2[j] < score2[i]) {
                        isPass = true;
                        break;
                    }
                }
                if (isPass) result += 1;
                isPass = false;
            }

            sb.append(result + "\n");
        }

        System.out.println(sb);
    }
}

class Person implements Comparable<Person> {

    private int number;
    private int score1;
    private int score2;

    public Person(int number, int score1, int score2) {
        this.number = number;
        this.score1 = score1;
        this.score2 = score2;
    }

    public int getNumber() {
        return number;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    @Override
    public int compareTo(Person p1) {
        return this.getScore1() - p1.getScore1();
    }

}