import java.util.*;
import java.io.*;
class Main 
{

  int n;
  int adj[][];
  
  public int minimum(int a,int b)
  {
    return (a<b)?a:b;
  }
  public void floydWarshall()
  {
    
    /*for(int i=1;i<adj.length;i++)
    {
      for(int k=1;k!=i;k++)
      {
        for(int j=1;j<adj[i].length;j++)
        {
          if(i!=j)
            

        }
      }
      
    }*/
    for(int i=1;i<=n;i++)
    {
      for(int j=1;j<adj.length;j++)
      {
        for(int k=1;k<adj[i].length;k++)
        {
          if(j!=k || j!=i || k!=i)
          {
            adj[j][k]=minimum(adj[j][k],adj[j][i]+adj[i][k]);
          }
        }
      }
    }
    System.out.println("FINAL MATRIX:");
    for(int i=1;i<adj.length;i++)
    {
      for(int j=1;j<adj[i].length;j++)
      {
        System.out.print(adj[i][j]+"\t");
      }
      System.out.println();
    }
  }
  public void inputFunc()throws IOException
  {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.println("enter no of nodes:");
    n=Integer.parseInt(br.readLine());
    adj=new int[n+1][n+1];
    System.out.println("Enter adj matrix input:");
    for(int i=0;i<adj.length;i++)
    {
      String in=br.readLine();
      String arr[]=in.trim().split(" ");

      for(int j=0;j<adj[i].length;j++)
      {
        adj[i][j]=Integer.parseInt(arr[j]);
      }
    }
    for(int i=0;i<adj.length;i++)
    {
      for(int j=0;j<adj[i].length;j++)
      {
        System.out.print(adj[i][j]+"\t");
      }
      System.out.println();
    }
    floydWarshall();


    
  }
  public static void main(String[] args)throws IOException
  {
   Main m=new Main();
   m.inputFunc();


  }
}
/* 0 0 0 0 0 
   0 0 3 999999 7
   0 8 0 2 999999
   0 5 999999 0 1
   0 2 999999 999999 0 */
