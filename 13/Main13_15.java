import java.util.*;

class Main13_15 {
    public static int n, m, result = 0, rot = 0;
    public static int[][] arr = new int[8][8]; // �ʱ� �� �迭
    public static int[][] temp = new int[8][8]; // ���� ��ġ�� ���� �� �迭
    
    // 4���� �̵� ���⿡ ���� �迭
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    // ���� �켱 Ž��(DFS)�� �̿��� �� ���̷����� ������� �������� �ϱ�
    public static void virus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // ��, ��, ��, �� �߿��� ���̷����� ���� �� �ִ� ���
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (temp[nx][ny] == 0) {
                    // �ش� ��ġ�� ���̷��� ��ġ�ϰ�, �ٽ� ��������� ����
                    temp[nx][ny] = 2;
                    virus(nx, ny);
                }
            }
        }
    }

    // ���� �ʿ��� ���� ������ ũ�� ����ϴ� �޼���
    public static int getScore() {
        int score = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) {
                    score += 1;
                }
            }
        }
        return score;
    }

    // ���� �켱 Ž��(DFS)�� �̿��� ��Ÿ���� ��ġ�ϸ鼭, �� �� ���� ������ ũ�� ���
    public static void dfs(int count) {
        rot += 1;
        // ��Ÿ���� 3�� ��ġ�� ���
        if (count == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = arr[i][j];
                }
            }
            // �� ���̷����� ��ġ���� ���� ����
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 2) {
                        virus(i, j);
                    }
                }
            }
            // ���� ������ �ִ밪 ���
            result = Math.max(result, getScore());
            System.out.println("result = " + result);
            return;
        }
        // �� ������ ��Ÿ���� ��ġ
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    count += 1;
                    //System.out.println(i+", "+j+" = 1 , count = " + count);

                    dfs(count);
                    arr[i][j] = 0;
                    count -= 1;
                    //System.out.println(i+", "+j+" = 0 , count = " + count);

                }
            }
        }
    }

    public static void main(String[] args) {

        /*
            � ���󿡴� 1 ~ N�������� ���ÿ� M���� �ܹ��� ���ΰ� �����մϴ�. ��� ������ �Ÿ��� 1�Դϴ�.
            �̶� Ư���� ���� X�κ��� ����Ͽ� ������ �� �ִ� ��� ���� �߿���, �ִ� �Ÿ��� ��Ȯ�� K�� ��� ������
            ��ȣ�� ����ϴ� ���α׷��� �ۼ��ϼ���. ���� ��� ���� X���� ��� ���� X�� ���� �ִ� �Ÿ��� �׻�
            0�̶�� �����մϴ�.
            ���� ��� N = 4, K = 2, X = 1�� �� 1�� ���ÿ��� ����Ͽ� ������ �� �ִ� �����߿���,
            �ִ� �Ÿ��� 2�� ���ô� 4�� ���û��Դϴ�. 2���� 3�� ������ ���, �ִ� �Ÿ��� 1�̱� ������ ������� �ʽ��ϴ�.

            ������ ���� N, ������ ���� M, �Ÿ� ���� K, ��� ������ ��ȣ X.
        */

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0);
        System.out.println(result);
        System.out.println("rot = " + rot);
    }
    
}