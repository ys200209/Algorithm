import java.util.*;

class Main11_6 {

    public static void main(String[] args) {

        /*
            ��ҿ� �Ŀ��� �ռ��� ������ �ڽ��� ����� �˳��� ���� �Թ� ���̺� ����� �ϱ�� �ߴ�. ����� �Թ���� ��������
            �α� ���� ��Ư�� ������� �Թ��� �ϱ�� �Ͽ���.
            
            ȸ���ǿ� �Ծ�� �� N���� ������ ������ �� ���Ŀ��� 1���� N������ ��ȣ�� �پ��ִ�. �� ������ �����ϴµ� ����
            �ð��� �ҿ�Ǹ� ������ ���� ������� ������ �����Ѵ�.

            1. ������ 1�� ���ĺ��� �Ա� �����ϸ�, ȸ������ ��ȣ�� �����ϴ� ������� ������ ���� ������ ������ �����ϴ�.
            2. ������ ��ȣ�� ������ ������ �Ŀ��� ȸ���ǿ� ���� �ٽ� 1�� ������ ���� ������ �ɴϴ�.
            3. ������ ���� �ϳ��� 1�� ���� ������ �� ���� ������ �״�� �ΰ�, ���� ������ �����մϴ�.
            4. ȸ������ ���� ������ ���� ������ �������� �� �ɸ��� �ð��� ���ٰ� �����Ѵ�.

            ������ �Թ��� ������ �� K�� �Ŀ� ��Ʈ��ũ ��ַ� ���� ����� ��� �ߴܵǾ���. �ٽ� ����� �̾ ��,
            �� �� ���ĺ��� �����ؾ� �ϴ����� �˰��� �Ѵ�. 

            �� ������ ��� �Դ� �� �ʿ��� �ð��� ����ִ� �迭 food_times, ��Ʈ��ũ ��ְ� �߻��� �ð� K�ʰ�
            �Ű������� �־��� �� ��� ���ĺ��� �ٽ� �����ϸ� �Ǵ��� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
            (���� �� �����ؾ� �� ������ ���ٸ� -1�� ��ȯ�ϸ� �˴ϴ�.)
        */

        System.out.println(solution(new int[]{3, 1, 2}, 5));
        System.out.println(solution(new int[]{1, 1, 1, 1}, 4));
        System.out.println(solution(new int[]{7, 5, 4, 8, 3}, 20));
        System.out.println(solution(new int[]{7, 5, 4, 8, 3}, 300));
        System.out.println(solution(new int[]{2, 2, 2, 15, 2}, 12));
    }
    
    public static int solution(int[] food_times, long k) {
        int size = food_times.length;
        int total = 0;
        int min = 100000000;
        int result = -1;
        int index;

        for(int i=0; i<food_times.length; i++) {
            if (food_times[i] < min) {
                min = food_times[i]; // ex) min = 3
            }
            total += food_times[i];
        }

        if (total < k) {
            System.out.println(total + " < " + k);
            return -1;
        }

        System.out.println("(1) k = " + k);

        if (k - (min*size) >= 0) {
            for(int i=0; i<food_times.length; i++) {
                // �ϳ��� ���ָ� ����.
                food_times[i] -= min;
            }
            k -= min*size;
        } else {
            min = (int) (k/size);
            for(int i=0; i<food_times.length; i++) {
                // �ϳ��� ���ָ� ����.
                food_times[i] -= min;
            }
            k -= min*size;
        }

        /*for(int i=0; i<food_times.length; i++) { // [5, 0, 0, 0, 0] k=3, �̷� ��찡 �ֱ⿡ �ѹ����� ���� �ȵȴ�.(����)
            if (k == 0) break;
            if (food_times[i] == 0) {
                continue;
            } else {
                result = i+1;
                k -= 1;
            }
        }*/

        // System.out.println("(while) k == " + k);
        // System.out.println(Arrays.toString(food_times));

        if (k == 0) {
            for(int i=0; i<food_times.length; i++) {
                if (food_times[i] != 0 ) {
                    result = i+1;
                    return result;
                }
            }
        }
        
        while(true) {
            if (k == 0) break;
            for(int i=0; i<food_times.length; i++) {
                if (food_times[i] != 0) {
                    k -= 1;
                    result = i+1;
                }
                if (k == 0) break;
            }
        }

        System.out.println("result = " + result);
        if (result != -1) {
            
            for (int i=result; i<food_times.length+result; i++) {
                index = i;
                if (index >= size) {
                    index -= size;
                }
                if (food_times[index] != 0) {
                    result = index+1;
                    break;
                }
            }
            // ���� result������ �Թ��� ����� �� ��Ʈ��ũ ��ְ� �߻��Ͽ����� �ǹ��Ѵ�.
            // ���� ��Ʈ��ũ ��ְ� ������ �ĺ��� ���� ���� ���� ��ȣ�� ��ȯ�ϱ����� 1�� �����ش�.
        }

        if (result > food_times.length) {
            result /= food_times.length; // �ѹ����� ���� �ٽ� ó�� �������� ���ư����� �ǹ���.
        }
        return result;
    }
    
}
