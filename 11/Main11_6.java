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
        long size = food_times.length;
        long total = 0;
        long extract = 0; 
        int result = -1;
        PriorityQueue<Food> pq = new PriorityQueue<>();

        for(int i=0; i<food_times.length; i++) {
            pq.offer(new Food(food_times[i], i+1));
            total += food_times[i];
        }

        if (total <= k) {
            return -1;
        }

        while( size * (pq.peek().getTime() - extract) <= k ) {
            k -= size * (pq.peek().getTime() - extract);
            extract = pq.peek().getTime();
            pq.poll();
            size -= 1;
        }

        ArrayList<Food> arrayList = new ArrayList<>();
        while( !pq.isEmpty() ) {
            arrayList.add(pq.poll());
        }

        Collections.sort(arrayList, new Comparator<Food>(){
            @Override
            public int compare(Food o1, Food o2) {
                return Integer.compare(o1.getNumber(), o2.getNumber());
            }
        });
        
        while( result == -1 ) {
            for(int i=0; i<arrayList.size(); i++) {
                if (k == 0 && arrayList.get(i).getTime() != 0) {
                    result = arrayList.get(i).getNumber();
                    break;
                }
    
                if (arrayList.get(i).getTime() != 0) {
                    k -= 1;
                }
            }
        }

        return result;
    }
    
}

class Food implements Comparable<Food>{
    private int time;
    private int index;

    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    public int getTime() {
        return this.time;
    }

    public int getNumber() {
        return this.index;
    }

    @Override
    public int compareTo(Food o) {
        return Integer.compare(this.time, o.time);
    }
}