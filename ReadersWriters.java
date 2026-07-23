import java.util.concurrent.Semaphore;
class Sharesamaphore{
    int data=0;
    int readcount=0;
    Semaphore mutex=new Semaphore(1);
    Semaphore wrt=new Semaphore(1);
}
class reader extends Thread{
    int id;
    Sharesamaphore s;
     reader(int id,Sharesamaphore s){
        this.id=id;
        this.s=s;
     }
   public void run(){
     try {
        s.mutex.acquire();
        s.readcount++;
        if(s.readcount==1){
   s.wrt.acquire();
}
s.mutex.release();  
System.out.println("reader id :"+id+"reader data"+s.data); 
Thread.sleep(1000);
        s.mutex.acquire();
        //do job
        s.readcount--;
        if(s.readcount==0){
            s.wrt.release();
        }
        s.mutex.release();
     } catch (InterruptedException e) {
        e.printStackTrace();
     }}}
     class writer extends Thread{
       int id;
       Sharesamaphore s;
       writer(int id,Sharesamaphore s){
     this.id=id;
     this.s=s;
       }
       public void run(){
        try {
       s.wrt.acquire();
       s.data++;
       System.out.println("writer id :"+id+"writer data"+s.data);
       s.wrt.release();}catch(InterruptedException e){
        System.out.println(e.getMessage());
       }}
     }
public class ReadersWriters {
    public static void main(String[] args) {
     Sharesamaphore s=new Sharesamaphore();   
     reader  r=new reader(1,s);
     writer w=new writer(1,s);
     w.start();
   r.start();
    }
}
