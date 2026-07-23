import java.util.concurrent.Semaphore;

class Solution extends Thread{
 Semaphore fork1;
 Semaphore fork2;
int id;
    public Solution(int id,Semaphore fork1, Semaphore fork2){
 this.fork1=fork1;
 this.fork2=fork2;       
 this.id=id+1;
    }
    public void run(){
  System.out.println("the philosopher is thinking: "+id);
  try {
    fork1.acquire();

  System.out.println("philosopher choose left fork"+id);
  fork2.acquire();
  System.out.println("philosopher choose right fork"+id);
  System.out.println("philosopher is eathing"+id);
  Thread.sleep(1000);
  fork1.release();
  fork2.release();
  System.out.println("philosopher released both the forks"+id);} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
}
}
public class dyningphilosophers {
    public static void main(String[] str){
     Semaphore[] fork=new Semaphore[5];
     for(int i=0;i<5;i++){
        fork[i]=new Semaphore(1);
     }
     Solution[] p=new Solution[5];
     for(int i=0;i<4;i++){
        p[i]=new Solution(i,fork[i],fork[((i+1)%5)]);
    }
    p[4]=new Solution(4,fork[4],fork[0]);
  for(int i=0;i<5;i++){
        p[i].start();
        try {
            p[i].join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    }
}
