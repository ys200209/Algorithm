public class BakeryMain {

    public static void main(String[] args) {

        int TNUM = 1000;
        int[] number = new int[TNUM];
        boolean[] choosing = new boolean[TNUM];
        BakeryBread bakeryBread = new BakeryBread();
        System.out.println("베이커리 동작");

        for(int i=0; i<TNUM; i++) {
            BakeryThread bakeryThread = new BakeryThread(number, choosing, TNUM, bakeryBread);
            bakeryThread.start();
        }
    }
}

class BakeryThread extends Thread {

    int TNUM;
    int[] number;
    boolean[] choosing;
    BakeryBread bakeryBread;

    BakeryThread(int[] number, boolean[] choosing, int TNUM, BakeryBread bakeryBread) {
        this.choosing = choosing;
        this.number = number;
        this.TNUM = TNUM;
        this.bakeryBread = bakeryBread;
    }

    public int MAX() { // 현재 티켓 값 중에서 가장 높은 티켓값을 반환해주는 메소드
        int MAXNUM = 0;
        for(int i=0; i<TNUM; i++) { // 스레드의 개수만큼 (TNUM)을 비교한다.
            if (MAXNUM < number[i]) { // 배열값이 MAXNUM 값 보다 크다면
                MAXNUM = number[i]; // 더 큰 값을 MAXNUM에 할당
            }
        }
        return MAXNUM;
    }

    boolean NUM(int j, int i) { // 각 스레드의 티켓번호를 비교하여 결과값을 돌려주는 함수
        if (number[j] < number[i]) { // 현재 스레드의 티켓값 number[i], 비교대상 스레드의 티켓값 number[j]

            return true; // 현재 스레드 티켓값이 높다면 바쁜대기를 위해 조건에서 참을 주어 탈출하지 못하게 한다.
        } else if (number[j] > number[i]) { 

            return false; // 위와 반대로 현재 스레드의 티켓이 더 작을 때는 while 루프를 빠져나갈 수 있도록 false를 리턴해준다.
        } else { // 두 스레드간에 티켓값이 같다면 두 스레드의 번호를 비교한다.
            // i 스레드가 현재 실행하는 스레드이므로
            if (j < i) return true; // 현재 스레드의 번호가 더 높을 때는 대기 상태를 가지기 위해 true를 반환.
            else if (j > i) return false; // 번호가 더 낮을 때는 false를 반환해 while 루프를 빠져나가도록.
        }
        return false;
    }

    void enter_bakery(int i) { // 알고리즘 시작 함수
        int j; // 현재 스레드와 비교할 다른 스레드들의 번호를 지정할 변수

        choosing[i] = true; // 티켓 선택 프로세스 시작
        number[i] = MAX() + 1; // MAX함수를 통해서 이미 발부된 티켓 중 가장 높은 값의 다음값을 받는다.
        choosing[i] = false; // 티켓 선택 프로세스 종료
        System.out.println(i + "Thread의 ticket 번호" + number[i]); // 받은 티켓의 번호를 출력

        try { // 코드의 가독성을 위해 티켓 뽑은 후 sleep으로 1초 정지
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(j=0; j<TNUM; j++) { // for문으로 모든 스레드 티켓과 번호로 통과 가능한지를 검사함
            while(choosing[j] == true){} // 스레드가 티켓을 받았는지 검사함. 받지 않았다면 대기

            while((number[j] != 0) && (NUM(j, i))){} // 티켓의 번호를 비교함.
            // 비교당하는 스레드가 number값이 0이면 비교하지 않고 나감 (계산이 끝난 스레드이기 때문)
            // 티켓의 번호가 같다면 NUM 함수 안에서 스레드 번호를 비교함
        }

        // 임계 영역 코드
        System.out.println(Thread.currentThread().getName() + " 임계영역 진입");
        System.out.println(" 구매완료, 남은 빵의 개수 : " + bakeryBread.getBread());
        System.out.println(Thread.currentThread().getName() + " 임계영역 종료 ");
        System.out.println(Thread.currentThread().getName() + " 작업 완료\n");
        number[i] = 0;
    }

    public void run() { // Thread의 run 메소드
        String Tname = Thread.currentThread().getName(); // getName으로 현재 실행 스레드의 이름을 받아온다.
        int Tnum = Integer.parseInt(Tname.substring(7, 8));
        System.out.println(Tname + "동작");
        enter_bakery(Tnum); // 현재 실행 메소드의 번호끼리 서로 비교하도록 베이커리 알고리즘 시작
    }

}

class BakeryBread {
    int bread = 10; // 임계영역의 공유변수 지정

    public int getBread() { // 빵을 꺼내올 때 하나씩 감소한다.
        return --bread;
    }

    public void setBread(int bread) {
        this.bread = bread;
    }
}
