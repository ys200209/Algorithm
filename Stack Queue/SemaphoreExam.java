import java.util.*;
import java.util.concurrent.Semaphore;

public class SemaphoreExam {
    final SomeResourceReader resource = new SomeResourceReader();
    private static Semaphore writer = new Semaphore(1);
    static Semaphore reader = new Semaphore(1);
    public static int criticalValue, readers = 0; // 리더의 수
    
    boolean writeLock = false; // 라이터가 쓰고 있을 경우 true

    public static void main(String[] args) {

        Thread t;
        
        for(int i = 1 ; i <= 2 ; i++) {   //입력받은 정수만큼 스레드를 생성
            t = new Thread(new Runnable() {
                  public void run() {
                    resource.use();
                  }
            });
               
            t.start();   //스레드 수행
         }
        
    }

    class SomeResourceReader {

        public static void use() {
            try {
                do {
                    reader.acquire(); // P연산 (wait)
                    readers += 1;
                    if (readers == 1) {
                        writer.release(); 
                    }
                    reader.release(); // V연산 (signal)

                    // Reader 임계 영역 진입
                    
                    reader.acquire(); // wait
                    readers -= 1;
                    if (readers == 0) {
                        writer.acquire();
                    }
                    reader.release(); // signal

                } while(true);
                
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
        }
    }

    class SomeResourceWriter {
        
        public static void use() {
            try {
                do {
                    writer.acquire();

                    // Writer 임계 영역 진입

                    writer.release();
                } while(true);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
