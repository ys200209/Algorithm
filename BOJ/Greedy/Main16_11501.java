import java.util.*;
import java.io.*;

public class Main16_11501 {
    static int T, N;
    static int[] dayPrices, sumPrices;
    static StringBuilder sb = new StringBuilder();
    static Queue<Day> pq; 
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int result = 0;
            N = Integer.parseInt(br.readLine());
            dayPrices = new int[N+1];
            sumPrices = new int[N+1];
            int sum = 0;
            pq = new PriorityQueue<>();
            Day now=null;

            st = new StringTokenizer(br.readLine(), " ");
            int j=1;
            while(st.hasMoreTokens()) {
                sumPrices[j] = sum += dayPrices[j] = Integer.parseInt(st.nextToken());
                pq.offer(new Day(j, dayPrices[j]));
                j++;
            }

            int count = 0;
            int minusSum = 0;
            while(!pq.isEmpty()) {
                Day day = pq.poll();

                if (now != null && day.index < now.index) continue;
                
                if (now == null) {
                    count = day.index - /*now.index - */1;
                    minusSum = sumPrices[day.index-1]/* - sumPrices[now.index] */;
                } else {
                    count = day.index - now.index - 1;
                    minusSum = sumPrices[day.index-1] - sumPrices[now.index];
                    // System.out.println("minusSum = " + sumPrices[day.index-1] + " - " + sumPrices[now.index]);
                }

                // System.out.println("count : " + count);
                // System.out.println("minusSum : " + minusSum);
                result += (count < 1 ? 0 : (count * dayPrices[day.index] - minusSum));
                now = day;
            }

            sb.append(result + "\n");
        }  

        System.out.println(sb);

    }

}

class Day implements Comparable<Day> {

    int index;
    int price;

    public Day(int index, int price) {
        this.index = index;
        this.price = price;
    }

    @Override
    public int compareTo(Day day) {
        return day.price - this.price;
    }

}