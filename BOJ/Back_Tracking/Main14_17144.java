import java.util.*;
import java.io.*;

public class Main14_17144 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int R, C, T;
    static Dust[][] dusts;
    static AirCleaner AC = new AirCleaner();
    static ArrayList<Dust> dustList = new ArrayList<>();
    static Queue<Dust> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        dusts = new Dust[R][C];

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int j=0;
            while(st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());

                if (n == -1) {
                    if (AC.front_x == 0 && AC.front_y == 0) {
                        AC.front_x = i;
                        AC.front_y = j;
                    } else {
                        AC.back_x = i;
                        AC.back_y = j;
                    }
                } 

                if (n > 0) {
                    Dust dust = new Dust(i, j, n, 0);
                    dusts[i][j] = dust;
                    dustList.add(dust);
                    queue.offer(new Dust(i, j, n, 0));
                }
                j++;
            }
        }

        for(int i=0; i<T; i++) {
            exclude();
            sumDust();
            clean();
        }

        /*System.out.println("확산");
        
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if (dusts[i][j] != null) System.out.print(dusts[i][j].amount + ", ");
                else System.out.print("0, ");
            }
            System.out.println();
        }*/


    }

    public static void exclude() {

        int size = dustList.size();
        for(int i=0; i<size; i++) {
            Dust d = dustList.get(i);
            int x = d.x;
            int y = d.y;
            int count=0; // 확산한 미세먼지
            int per = d.amount / 5;

            for(int j=0; j<4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                if ((nx == AC.front_x && ny == AC.front_y) || (nx == AC.back_x && ny == AC.back_y)) continue;

                if (dusts[nx][ny] == null) { // 확산하려는 공간이 아직 미세먼지가 없었다면
                    Dust dust = new Dust(nx, ny, per, 0);
                    dusts[nx][ny] = dust;
                    dustList.add(dust);
                } else { // 이미 미세먼지가 있는 곳이었다면
                    dusts[nx][ny].sum += per; // 이미 있는 미세먼지를 가져와서 확산된 미세먼지만큼 추가
                }

                count++;
            }
            d.amount -= (per * count);
        }
    }

    public static void sumDust() { // 확산받은 미세먼지들을 자신의 미세먼지와 합치는 부분
        for(int i=0; i<dustList.size(); i++) {
            dustList.get(i).amount += dustList.get(i).sum;
            dustList.get(i).sum = 0;
        }
    }

    public static void clean() {
        Dust[][] temp = copyDusts();

        UpperClean(temp);
        LowerClean(temp);
    }

    public static void UpperClean(Dust[][] temp) {
        System.out.println("UpperClean");

        for(int i=0; i<AC.front_x; i++) {
            for(int j=0; j<C; j++) {
                if (temp[i][j] != null) System.out.print(temp[i][j].amount + ", ");
                else System.out.print("0, ");
            }
            System.out.println();
        }
        System.out.println("----------------------");

        for(int i=1; i<=AC.front_x; i++) {
            temp[i][0] = dusts[i-1][0];
            temp[AC.front_x - i - 1][C - 1] = dusts[AC.front_x - 1][C - 1];
        }

        for(int i=1; i<AC.front_y; i++) {
            temp[0][i - 1] = dusts[0][i];
            temp[AC.front_x - 1][i] = dusts[AC.front_x - 1][i - 1];
        }

        for(int i=0; i<AC.front_x; i++) {
            for(int j=0; j<C; j++) {
                if (temp[i][j] != null) System.out.print(temp[i][j].amount + ", ");
                else System.out.print("0, ");
            }
            System.out.println();
        }

    }

    public static void LowerClean(Dust[][] temp) {


    }

    public static Dust[][] copyDusts() {
        Dust[][] temp = new Dust[R][C];
        
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                temp[i][j] = dusts[i][j];
            }
        }

        return temp;
    }

}

class AirCleaner {

    int front_x, front_y;
    int back_x, back_y;

    public AirCleaner(){ /* empty */}

}

class Dust {

    int x;
    int y;
    int amount; // 현재 가지고 있는 미세먼지
    int sum; // 다른 미세먼지로부터 확산받은 미세먼지 

    public Dust(int x, int y, int amount, int sum) { 
        this.x = x;
        this.y = y;
        this.amount = amount;
        this.sum = sum;
    }

}