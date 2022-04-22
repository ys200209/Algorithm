import java.util.*;
import java.io.*;

public class Main11_7568 {
    static int N;
    static Person[] p;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new Person[N];
        
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            p[i] = new Person(x, y);
        }

        for(int i=0; i<N; i++) {
            int count = 1;
            for(int j=0; j<N; j++) {
                if (i == j) continue;

                if (p[i].w < p[j].w && p[i].h < p[j].h) count++;
            }
            sb.append(count + " ");
        }
        System.out.println(sb);
    }

}

class Person {

    int w;
    int h;

    public Person(int w, int h) {
        this.w = w;
        this.h = h;
    }

}