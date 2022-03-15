import java.util.*;
import java.io.*;

public class Main11_15686 {
    static int N, M, result=(int)1e9;
    static ArrayList<House> houseList = new ArrayList<>(); // ���� ��ǥ�� ���� ��ü ����Ʈ
    static ArrayList<Chiken> chikenList = new ArrayList<>(); // ġŲ���� ��� ���� ��ü ����Ʈ
    static ArrayList<Chiken> chikenSelect = new ArrayList<>(); // M ���� ġŲ���� ������ ��ü ����Ʈ

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=0;
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) houseList.add(new House(i, j, 0));
                if (num == 2) chikenList.add(new Chiken(i, j));
                j++;
            }
        }

        DFS(0, 0);

        System.out.println(result);
    }

    public static void DFS(int index, int count) {
        if (count == M) {
            result = Math.min(result, chikenStreet());
            return;
        }

        for(int i=index; i<chikenList.size(); i++) {
            chikenSelect.add(chikenList.get(i));
            DFS(i+1, count+1);
            chikenSelect.remove(chikenSelect.size()-1);
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