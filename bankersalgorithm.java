import java.util.Scanner;

class bankerssalgorithm{
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("enter the number of pes");  
      int p=sc.nextInt();
      System.out.println("enter the number of r");
        int r=sc.nextInt();
             int[][] Allocation = new int[p][r];
        int[][] Need = new int[p][r];
        int[][] RemainingNeed = new int[p][r];
        int[] Available = new int[r];
        boolean[] done=new boolean[p];
        System.out.println("enter the Allocation");
    for(int i=0;i<p;i++){for(int j=0;j<r;j++){
        Allocation[i][j]=sc.nextInt();
    }}
        System.out.println("Enter Need Matrix:");
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                Need[i][j] = sc.nextInt();
            }
        }

    System.out.println("enter the available resources");
   for(int i=0;i<r;i++){
    Available[i]=sc.nextInt();
   }
   //ramaining need
   for(int i=0;i<p;i++){
for(int j=0;j<r;j++){
   RemainingNeed[i][j]=Need[i][j]-Allocation[i][j];
}
   }
   int h=0;
   boolean complete = false;
   while(h<p){
    complete=false;
for(int i=0;i<p;i++){
    if(!done[i]){
    int j;
        boolean v=true;
    for(j=0;j<r;j++){  
        if(RemainingNeed[i][j]>Available[j]){
            v=false;
            break;
        }
    }
    if(v){
        for(j=0;j<r;j++){
            Available[j]+=Allocation[i][j];
        }
        System.out.print("P"+(i+1)+" ");
        h++;
    complete=true;
    done[i]=true;
    }
    }
}}
if(!complete){
System.out.println("System is not in safe state");}
System.out.println("system is in safe state");
    }

}