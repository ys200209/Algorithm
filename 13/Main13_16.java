import java.util.*;

class Main13_16 {
    public static int N, M, result=0;
    public static int[][] map, virus, temp;


    public static void main(String[] args) {

        /*
            - �Ｚ���� SW �����׽�Ʈ
            
            ��ü�� ġ������ ���̷����� �����ϴ� �����ҿ��� ���̷����� ����Ǿ����ϴ�. ������ ���̷����� ���� ������ 
            �ʾҰ�, ���̷����� Ȯ���� �ڱ� ���� �����ҿ� ���� ������� �մϴ�.
            �����Ҵ� ũ�Ⱑ N x M�� ���簢������ ��Ÿ�� �� ������, ���簢���� 1 X 1 ũ���� ���簢������ �������� �ֽ��ϴ�.
            �����Ҵ� ��ĭ, ������ �̷���� ������, ���� ĭ �ϳ��� ���� �����մϴ�.
            �Ϻ� ĭ�� ���̷����� �����ϸ�, �� ���̷����� �����¿�� ������ ��ĭ���� ��� �������� �� �ֽ��ϴ�.
            ���� ���� �� �ִ� ���� ������ 3���̸�, �� 3���� ������ �մϴ�.

            �� 3���� ���� ��, ���̷����� ���� �� ���� ���� ���� �����̶�� �� �� �������� ���� ���� ũ���� �ִ��� ���ϴ�
            ���α׷��� �ۼ��ϼ���. (3 <= N, M <= 8) ( 0�� ��ĭ, 1�� ��, 2�� ���̷����� �ִ� ��ġ�̴� )

            7 7
            2 0 0 0 1 1 0
            0 0 1 0 1 2 0
            0 1 1 0 1 0 0
            0 1 0 0 0 0 0
            0 0 0 0 0 1 1
            0 1 0 0 0 0 0
            0 1 0 0 0 0 0
        */

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N][M];
        virus = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = scanner.nextInt();
                /*if (map[i][j] == 2) {
                    virus[i][j] = 2;
                }*/
            }
        }

        DFS(0);

        

        System.out.println("result = " + result);

    }

    public static void DFS(int wall) {
        if (wall == 3) {
            temp = new int[N][M];

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    temp[i][j] = map[i][j];
                }
            }
            
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if (temp[i][j] == 2) {
                        Virus(i, j);
                    }
                }
            }

            int score = getScore();
            result = Math.max(result, score);

            /*System.out.println("-------------");
            for(int i=0; i<N; i++) {
                System.out.println(Arrays.toString(temp));
            }*/

            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    wall += 1;
                    DFS(wall);
                    wall -= 1;
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void Virus(int x, int y) {

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        // ���̷��� Ȯ�� ����
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            if (temp[nx][ny] == 0) {
                temp[nx][ny] = 2;
                Virus(nx, ny);
            }
        }
    }

    public static int getScore() {
        int score = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (temp[i][j] == 0) score+=1;
            }
        }

        return score;
    }



}