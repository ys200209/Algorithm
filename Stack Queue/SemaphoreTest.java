import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreTest { //수행시간 측정을 위해 만들어둔 클래스
   public static SomeResourceReader resourceReader = new SomeResourceReader();
	public static SomeResourceWriter resourceWriter = new SomeResourceWriter();
	public static Semaphore writer = new Semaphore(1);
   public static Semaphore reader = new Semaphore(1);
   public static int criticalValue, readers = 0; // 리더의 수
    

	public static void main(String[] args) {
		
		Thread tRead = new Thread(new Runnable() {
			public void run() {
				resourceReader.use();
			}
		});
		
		Thread tWrite = new Thread(new Runnable() {
			public void run() {
				resourceWriter.use();
			}
		});
		
		tRead.start();
		
		tWrite.start();
		
	}
	
}

class SomeResourceReader {

    public void use() {
        try {
            do {
            	Thread.sleep(new Random().nextInt(1000));
            	
            	System.out.println("Reader : " + SemaphoreExam.readers);
            	
            	SemaphoreExam.reader.acquire(); // P연산 (wait)
            	SemaphoreExam.readers += 1;
               if (SemaphoreExam.readers == 1) {
               	SemaphoreExam.writer.acquire(); 
               }
                SemaphoreExam.reader.release(); // V연산 (signal)

                // Reader 임계 영역 진입
                
                SemaphoreExam.reader.acquire(); // wait
                SemaphoreExam.readers -= 1;
                if (SemaphoreExam.readers == 0) {
                	SemaphoreExam.writer.release();
                }
                SemaphoreExam.reader.release(); // signal

                
                
            } while(true);
            
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
    }
}

class SomeResourceWriter {
    
    public void use() {
        try {
            do {
            	SemaphoreExam.writer.acquire();

                // Writer 임계 영역 진입
            	System.out.println("Writer");

            	Thread.sleep(new Random().nextInt(1000));
            	
            	SemaphoreExam.writer.release();
            } while(true);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
