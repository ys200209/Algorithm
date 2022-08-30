package BOJ.Back_Tracking;

import java.util.*;
import java.io.*;

public class Main14_19942 {
    static Food[] foods;
    static Food now, result_food;
    static int N, result_price=(int)1e9;
    static String result_str="", str="";
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        foods = new Food[N];
        now = new Food();
        result_food = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
        Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            foods[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        DFS(0, new Food());

        if (result_price != (int)1e9) System.out.println(result_price + "\n" + result_str);
        else System.out.println("-1");
    }

    public static void DFS(int index, Food now) {
        if(checkFood(now)) return;

        for(int i=index; i<N; i++) {
            Food food = foods[i];
            
            String add = (i+1) + " ";
            str += add;
            DFS(i+1, new Food(now.mp+food.mp, now.mf+food.mf, now.ms+food.ms, now.mu+food.mu, now.price+food.price));
            str = str.substring(0, str.length() - add.length());
        }
    }

    public static boolean checkFood(Food now) {
        if (now.mp >= result_food.mp && now.mf >= result_food.mf && 
        now.ms >= result_food.ms && now.mu >= result_food.mu) { // �ּ� ����ҿ� �����Ѵٸ�

            if (result_price > now.price) {
                result_price = now.price;
                result_str = str;
            }
            return true;
        }
        return false;
    }

    static class Food {

        int mp;
        int mf;
        int ms;
        int mu;
        int price;

        public Food() { /* empty */}

        public Food(int mp, int mf, int ms, int mu, int price) {
            this.mp = mp;
            this.mf = mf;
            this.ms = ms;
            this.mu = mu;
            this.price = price;
        }
    }

}

