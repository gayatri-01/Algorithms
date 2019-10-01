import java.util.*;
import java.io.*;
class Main
{
  int adj[][];
  int n;
  int cost[];
  int path[];
  int node[];
  

  
    public void pathPrint()
    {
      int val=1;
      int i=1;
      path[0]=1;
      while(val!=12)
      {
        path[i]=node[val];
        val=node[val];
        i++;
      }
      System.out.println("The Optimal Path is:");
      i=0;
      while(path[i]!=0)
      {
        System.out.print(path[i]+"\t");
        i++;
      }
    }
    public void MultiStageGraph()
    {
      cost=new int[n+1];
      path=new int[n+1];
      node=new int[n+1];
      cost[n]=0;
      
      for(int i=n;i>=1;i--)
      {
        int min=Integer.MAX_VALUE;
        for(int j=i+1;j<=n;j++)
        {
          if(adj[i][j]!=0 && cost[j]+adj[i][j]<min)
          {
            min=cost[j]+adj[i][j];
            cost[i]=cost[j]+adj[i][j];
            node[i]=j;
            

          }
        }
        
      }
      System.out.println(Arrays.toString(cost));
      System.out.println(Arrays.toString(node));
      pathPrint();
      

    }
    public void inputFunc() throws IOException
    {
      BufferedReader r = new BufferedReader(new
        InputStreamReader(System.in));
      System.out.println("Enter no of nodes:");
      n=Integer.parseInt(r.readLine());
      
      
      adj=new int[n+1][n+1];
      System.out.println("Enter adj matrix:");
      for(int i=0;i<n+1;i++)
      {
        
        String input=r.readLine();
        
        String in[]=input.trim().split(" ");
        
        for(int j=0;j<n+1;j++)
        {
          adj[i][j]=Integer.parseInt(in[j]);

        }
      }
      System.out.println("Input adj matrix:");
      for(int i=0;i<adj.length;i++)
      {
        for(int j=0;j<adj[i].length;j++)
        {
          System.out.print(adj[i][j]);
        }
        System.out.println();
      }
      MultiStageGraph();
    


    }
    public static void main(String[] args)throws IOException {
      
       Main m=new Main();
       m.inputFunc();
       

    }
}
/*
12 
0 0 0 0 0 0 0 0 0 0 0 0 0 
0 0 9 7 3 2 0 0 0 0 0 0 0
0 0 0 0 0 0 4 2 1 0 0 0 0 
0 0 0 0 0 0 2 7 0 0 0 0 0 
0 0 0 0 0 0 0 0 11 0 0 0 0 
0 0 0 0 0 0 0 11 8 0 0 0 0 
0 0 0 0 0 0 0 0 0 6 5 0 0 
0 0 0 0 0 0 0 0 0 4 3 0 0 
0 0 0 0 0 0 0 0 0 0 5 6 0 
0 0 0 0 0 0 0 0 0 0 0 0 4
0 0 0 0 0 0 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0 0 0 0 0 5 
0 0 0 0 0 0 0 0 0 0 0 0 0*/
