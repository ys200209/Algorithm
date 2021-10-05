import java.util.*;

class Main23_3 {
    public static int N, result=0, count=0;
    public static String str;
    public static int[][] map;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> countList = new ArrayList<>();

    public static void main(String[] args) {
        
        // 백준 온라인 저지 DFS/BFS(23)의 3번

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        map = new int[N][N];
        
        for(int i=0; i<N; i++) {
            str = scanner.next();

            for(int j=0; j<N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        for(int i=0; i<N; i++) {
            
            for(int j=0; j<N; j++) {
                if (DFS(i, j)) {
                    result += 1;
                    countList.add(count);
                    count = 0;
                }
            }
            
        }
        
        Collections.sort(countList);
        
        sb.append(result);

        for(int i=0; i<countList.size(); i++) {
            sb.append("\n" + countList.get(i));
        }

        System.out.println(sb);

    }

    public static boolean DFS(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }

        if (map[x][y] == 1) {
            map[x][y] = 0;
            count += 1;
            DFS(x-1, y);
            DFS(x+1, y);
            DFS(x, y-1);
            DFS(x, y+1);
            return true;
        }
        
        return false;
    }

}