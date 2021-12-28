

class Main3 {
    public static int result=0;
    public static Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {

        /*
            어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
            예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 
            이 중 가장 큰 숫자는 94 입니다.
            문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. 
            number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 
            solution 함수를 완성하세요
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