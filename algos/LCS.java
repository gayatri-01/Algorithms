import java.util.*;
import java.io.*;
class Main {
  String x,y;
  int table[][];
  int p,q;
  String common=" ";
  public void backTracking(int i,int j)
  {
    if(i==0)
    {
      System.out.println("BackTracking over");
    }
    else
    {
      //System.out.print(table[i][j]+" ");
      if(table[i][j]==table[i-1][j])
      {
        backTracking(i-1,j);
      }
      else if(table[i][j]==table[i][j-1])
      {
        backTracking(i,j-1);
      }
      else
      {
        common=common+x.charAt(i-1);
        backTracking(i-1,j-1);
      }
      
    }
  }
  public int maximum(int a,int b)
  {
    return (a>b)?a:b;
  }

  public void LCS()
  {
    for(int i=1;i<table.length;i++)
    {
      //System.out.println(x.charAt(i-1));
      for(int j=1;j<table[i].length;j++)
      {
        
        // System.out.println(y.charAt(j-1));

        if(x.charAt(i-1)==y.charAt(j-1))
        {
          table[i][j]=1+table[i-1][j-1];
        }
        else
        {
          table[i][j]=maximum(table[i-1][j],table[i][j-1]);
        }
      }
    }
    System.out.println("Memoization table:");
    for(int i=0;i<table.length;i++)
    {
      for(int j=0;j<table[i].length;j++)
      {
        System.out.print(table[i][j]+"\t");
      }
      System.out.println();
    }
    backTracking(p,q);
  }
  public void inputFunc()throws IOException
  {
    BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter x:");
    x=r.readLine();
    System.out.println("Enter y:");
    y=r.readLine();
    p=x.length();
    q=y.length();

    
    table=new int[p+1][q+1];
    LCS();
    StringBuilder s=new StringBuilder(common);

   System.out.println("Longest common system:"+s.reverse());
    System.out.println("length of string:"+((s.length())-1));


    
  }
  public static void main(String[] args)throws IOException {
    Main m=new Main();
    m.inputFunc();
    
  }
}