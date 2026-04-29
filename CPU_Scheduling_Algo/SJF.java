import java.util.*;
public class SJF
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
        int[] p = new int[n];
        for (int i=0; i<n; i++)
        {
            p[i] = i+1;
        }
         System.out.println("enter the burst time");
         for(int i=0; i<n; i++)
         {
             bt[i] = sc.nextInt();
         }
         
         // sort burst time only
         for(int i = 0; i <n ;i++)
         {
             for(int j = 0; j<n-i-1; j++)
             {
                 if(bt[j]>bt[j+1])
                 {
                     int temp= bt[i];
                     bt[i] = bt[j+1];
                     bt[j+1] = temp;
                  
                  
                    int tempp = p[j];
                    p[j] = p[j+1];
                    p[j+1] = tempp;
                 }
             }
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
              System.out.println("p"+p[i] + "\t" +bt[i] +"\t" + wt[i] + "\t" + tat[i]);
              
          }
          
    }
}


/*Ouput:
enter the number of processes
3
enter the burst time
4 
4
3
calculating waiting time
calculating turn around time
Process/ BT/ WT/ TAT
p1      3       0       3
p3      4       3       7
p2      4       7       11
*/