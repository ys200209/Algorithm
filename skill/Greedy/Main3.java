

class Main3 {
    public static int result=0;
    public static Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {

        /*
            � ���ڿ��� k���� ���� �������� �� ���� �� �ִ� ���� ū ���ڸ� ���Ϸ� �մϴ�.
            ���� ���, ���� 1924���� �� �� ���� �����ϸ� [19, 12, 14, 92, 94, 24] �� ���� �� �ֽ��ϴ�. 
            �� �� ���� ū ���ڴ� 94 �Դϴ�.
            ���ڿ� �������� ���� number�� ������ ���� ���� k�� solution �Լ��� �Ű������� �־����ϴ�. 
            number���� k ���� ���� �������� �� ���� �� �ִ� �� �� ���� ū ���ڸ� ���ڿ� ���·� return �ϵ��� 
            solution �Լ��� �ϼ��ϼ���
        */

        //System.out.println(solution("1924", 2)); // "94"
        //System.out.println(solution("1231234", 3)); // "3234"
        System.out.println(solution("4177252841", 4)); // "775841"

    }

    public static String solution(String number, int k) {
        String answer = "";

        for(int i=0; i<number.length(); i++) {
            queue.offer(number.charAt(i) - '0');
        }

        while(!queue.isEmpty()) {
            System.out.println("queue.size() = " + queue.size());
            int n = queue.poll();

            int front = 0;
            int back = number.length();

            for(int i=0; i<5; i++) {
                System.out.println("front : " + front + ", back : " + back);
                int index = number.substring(front, back).indexOf(Integer.toString(n));

                if (index == -1 || index > number.length() - k) break;
                
                answer = number.substring(front, front+k);

                if (result < Integer.parseInt(answer)) result = Integer.parseInt(answer);

                front = index+1;

            }
            
            if (result != 0) break;

        }


        return Integer.toString(result);
    }

}