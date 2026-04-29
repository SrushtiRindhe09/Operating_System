import java.util.*;
public class FCFS
{
    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("enter the number of processes");
        n = sc.nextInt();
        int[] bt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];
        
         System.out.println("enter the burst time");
         for(int i=0; i<n; i++)
         {
             bt[i] = sc.nextInt();
         }
         
         wt[0] = 0;
          System.out.println("calculating waiting time");
          for(int i = 1; i<n ; i++)
          {
              wt[i] = wt[i-1] + bt[i-1];
              
          }
          System.out.println("calculating turn around time");
          for(int i = 0; i<n ; i++)
          {
              tat[i] = wt[i] + bt[i];
              
          }
          System.out.println("Process/ BT/ WT/ TAT");
          for(int i = 0; i<n ; i++)
          {
              System.out.println("p"+(i+1) + "\t" +bt[i] +"\t" + wt[i] + "\t" + tat[i]);
              
          }
         sc.close();     
    }
}

/*Output:

enter the number of processes
3
enter the burst time
2
4
5
calculating waiting time
calculating turn around time
Process/ BT/ WT/ TAT
p1      2       0       2
p2      4       2       6
p3      5       6       11

*/