import java.util.*;
import java.io.*;

public class Main11_15686 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M, result=(int)1e9;
    static int[][] city;
    static boolean[][] visited;
    static ArrayList<Chiken> chikenSelect = new ArrayList<>();
    static Queue<House> houseQueue;
    static ArrayList<House> houseList = new ArrayList<>();
    static ArrayList<Chiken> chikenList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) houseList.add(new House(i, j, 0));
                if (city[i][j] == 2) {
                    chikenList.add(new Chiken(i, j));
                    city[i][j] = 0;
                }
                j++;
            }
        }

        DFS(0, 0);

        System.out.println("result : " + result);
    }

    public static void DFS(int index, int count) {
        if (count == M) {
            // 치킨 거리 계산 (BFS 연산으로)
            result = Math.min(result, chikenStreet());
            return;
        }

        for(int i=index; i<chikenList.size(); i++) {
            //if (!visited[i]) {
                //visited[i] = true;
                // city[chikenList.get(i).x][chikenList.get(i).y] = 2;
                chikenSelect.add(chikenList.get(i));
                DFS(i+1, count+1);
                chikenSelect.remove(chikenSelect.size()-1);
                // city[chikenList.get(i).x][chikenList.get(i).y] = 0;
                //visited[i] = false;
            //}
        }

    }

    public static int chikenStreet() {
        int chikenDistance = 0;

        for(House house : houseList) {
            int distance = (int)1e9;

            for(Chiken chiken : chikenSelect) {
                distance = Math.min(distance, Math.abs(chiken.x - house.x) + Math.abs(chiken.y - house.y));
            }

            chikenDistance += distance;
        }

        return chikenDistance;
    }

    /*public static void BFS() {
        houseQueue = new LinkedList<>();
        visited = new boolean[N][N];

        for(House house : houseList) {
            houseQueue.offer(house);
            visited[house.x][house.y] = true;
        }

        int chikenDistance = 0;

        while(!houseQueue.isEmpty()) {
            House house = houseQueue.poll();
            int x = house.x;
            int y = house.y;

            if (city[x][y] == 2) {
                chikenDistance += house.distance;
                continue;
            }

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;


            }
        }

        

    }*/
        
}

class House {

    int x;
    int y;
    int distance;

    public House(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

}

class Chiken {

    int x, y;

    public Chiken(int x, int y) {
        this.x = x;
        this.y = y;
    }

}