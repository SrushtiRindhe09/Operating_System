import java.util.Scanner;

public class roundRobin
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of processes");
        int n = sc.nextInt();
        
        int[] bt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];
        int[] rt = new int[n];
        
        System.out.println("enter the burst time");
        for(int i = 0; i<n ;i++)
        {
            bt[i] = sc.nextInt();
            rt[i] = bt[i];
        }
         
         int tq;
         System.out.println("enter the time quantum");
         tq = sc.nextInt();
         int time = 0;
         
         boolean done;
         do{
             done = true;
             for (int i = 0; i<n; i++)
             {
                 if(rt[i] > 0)
                 {
                     done = false;
                     
                     if(rt[i] > tq)
                     {
                         time = time + tq;
                         rt[i] = rt[i] - tq;
                         
                     }
                     else{
                         time = time + rt[i];
                         wt[i] = time- bt[i];
                         rt[i] = 0;
                     }
                 }
             }
             
         }
         while(!done);
        
        System.out.println("calculate turn around time");
        for(int i = 0; i<n ;i++)
        {
            tat[i] = wt[i] + bt[i];
        }
         
        System.out.println("\nProcess\tBT\tWT\tTAT");
        for(int i = 0; i < n; i++) 
        {
            System.out.println("P" + (i+1) + "\t" + bt[i] + "\t" + wt[i] + "\t" + tat[i]);
        }
    }
}

/*Output:
enter the number of processes
3
enter the burst time
3
2
3
enter the time quantum
2
calculate turn around time

Process BT      WT      TAT
P1      3       4       7
P2      2       2       4
P3      3       5       8


*/