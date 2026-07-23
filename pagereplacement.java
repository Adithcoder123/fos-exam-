import java.util.Scanner;

public class pagereplacement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
     System.out.println("Enter the number of frames");
     int frame=sc.nextInt();
     System.out.println("enter the no. of pages");
     int page=sc.nextInt();
     int []frames=new int[frame];
     int []pages=new int[page];
     for(int i=0;i<frame;i++){
        frames[i]=-1;
     }
     for(int i=0;i<page;i++){
        pages[i]=sc.nextInt();
     }
     int faults=0;
     int index=0;
     for(int i=0;i<page;i++){
         boolean found=false;
        for(int j=0;j<frame;j++){
           if(pages[i]==frames[j]){
            found=true;
            break;
           }
    
        }  
        // for FIFO
        // if(!found){
        //  frames[index]=pages[i];
        //    index=((index+1)%frame);       
        //    faults++;
        //    }
        if(!found){ 
            faults++;
            int least=i;
            int pos=-1;
            for(int j = 0; j < frame; j++){
                if(frames[j] == -1){
                    pos = j;
                    break;
                }
            }
              for(int j=0;j<frame;j++){
                int k;
          for(k=i-1;k>=0;k--){
          if(pages[k]==frames[j]){
break;
          }
          
        }
        if(k<least){
            least=k;
            pos=j;
        }
          }
         
          frames[pos]=pages[i];
        
        }
  // Display frames
            System.out.print(pages[i] + " -> ");

            for (int j = 0; j < frame; j++) {
                if (frames[j] == -1)
                    System.out.print("- ");
                else
                    System.out.print(frames[j] + " ");
            }

            if (found)
                System.out.println("Hit");
            else
                System.out.println("Miss");
        }

        System.out.println("Total Page Faults = " + faults);
     }
     
    }
