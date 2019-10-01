import java.util.*;
class Job {
  int id;
  int profit;
  int deadline;
  
  Job(int id, int profit, int deadline)
  {
    this.id=id;
    this.profit=profit;
    this.deadline=deadline;   
  }
  
}

class SortJobs implements Comparator<Job> 
{ 
    public int compare(Job j1, Job j2) 
    { 
        if (j1.profit>j2.profit) return -1; 
        if (j1.profit<j2.profit) return 1; 
        else return 0; 
    } 
}

class JobSequencing
{

  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of jobs");
    int n = sc.nextInt();
    Vector<Job> JobSeq = new Vector<Job>(n);

    for(int i=0;i<n;i++)
    {
      System.out.println("Enter profit and deadline of Job "+(i+1));
        int profit=sc.nextInt();
        int deadline=sc.nextInt();
        JobSeq.add(new Job((i+1),profit,deadline));
    }

    System.out.println("\n\nJob  Profit  Deadline");

    for(Job j: JobSeq)
    {
      System.out.println(j.id+"\t"+j.profit+"\t"+j.deadline);
    }

    SortJobs s = new SortJobs();
    Collections.sort(JobSeq,s);

    System.out.println("\n\nAfter Sorting:\n\nJob  Profit  Deadline");

    for(Job j: JobSeq)
    {
      System.out.println(j.id+"\t"+j.profit+"\t"+j.deadline);
    }

    int max=JobSeq.get(0).deadline;

    for(Job j: JobSeq)
    {
             if(max<j.deadline)
              max=j.deadline;
    }

          int[] slots = new int[max];
        for(int i=0;i<max;i++)
          slots[i]=-1;

        int maxProfit=0;
        
        System.out.println("\n\nJob Considered  Slot alloted    Profit");

    for(int i=0;i<n;i++)
    {
      System.out.print("Job "+(JobSeq.get(i).id)+"\t\t");
      int flag=0;
            for(int k=Math.min(max,JobSeq.get(i).deadline)-1;k>=0;k--)
            {
                if(slots[k]==-1)
                {
                     slots[k]=JobSeq.get(i).id;
                     System.out.print("["+k+" , "+(k+1)+"]"+"\t\t");
                     System.out.print(maxProfit+" + "+JobSeq.get(i).profit+"= ");
                     maxProfit=maxProfit+JobSeq.get(i).profit;
                     System.out.println(maxProfit+"\n");
                     flag=1;
                     break;
                }

            }

            if(flag==0)
              System.out.print("None\t\t"+maxProfit+"\t(Slots already occupied)\n\n"); 

            /*int flag=0;
            for(int m=0;m<max;m++)
          {if(slots[m]==-1)
              flag=1;
              break;
          }
          if(flag==0)
            break;*/

    }
  
  System.out.println("\nThe maximum profit sequence of Jobs is  ");
   for(int i=0;i<max;i++)
          System.out.print("Job "+slots[i]+"\t");

   System.out.println("\n\nThe maximum profit gained is "+maxProfit);

  }
}




