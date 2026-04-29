import java.util.*;
public class Priority
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
        int[] pr = new int[n];
        for (int i=0; i<n; i++)
        {
            p[i] = i+1;
        }
         System.out.println("enter the burst time");
         for(int i=0; i<n; i++)
         {
             bt[i] = sc.nextInt();
         }
         System.out.println("enter the priority");
         for(int i=0; i<n; i++)
         {
             pr[i] = sc.nextInt();
         }
         
         // sort based on priority
         for(int i = 0; i <n ;i++)
         {
             for(int j = 0; j<n-i-1; j++)
             {
                 if(pr[j]>pr[j+1])
                 {
                     int temp1= pr[i];
                     pr[i] = pr[j+1];
                     pr[j+1] = temp1;
                  
                   int temp2 = bt[j];
                    bt[j] = bt[j+1];
                    bt[j+1] = temp2;
                   
                    int temp3 = p[j];
                    p[j] = p[j+1];
                    p[j+1] = temp3;
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
          System.out.println("Process/ BT/ PR/ WT/ TAT");
          for(int i = 0; i<n ; i++)
          {
              System.out.println("p"+p[i] + "\t" +bt[i] +"\t" +pr[i]+"\t"+ wt[i] + "\t" + tat[i]);
              
          }
          
    }
}

/*Output

enter the number of processes
3
enter the burst time
4
3
2
enter the priority
3
1
2
calculating waiting time
calculating turn around time
Process/ BT/ PR/ WT/ TAT
p2      3       2       0       3
p3      2       3       3       5
p1      4       1       5       9




*/