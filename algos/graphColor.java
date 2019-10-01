
import java.util.*;
class GC
{
  static int ncolors;
  static int nvertices;
  static int adjacency[][];
  static int noOfSol=0;
  static int colorAssignment[];
  static String namesOfColors[]= new String[]{"R","G","B","Y","O"};

  public static void main(String args[])
  {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter no of vertices");
          nvertices=sc.nextInt();
          adjacency= new int[nvertices][nvertices];
          System.out.println("Enter adjacency matrix");
          for(int i=0;i<nvertices;i++)
          {
            for(int j=0;j<nvertices;j++)
            {
              adjacency[i][j]=sc.nextInt();
            }
          }

        colorAssignment=new int[nvertices];
        ncolors=calculateMinChromaticNo();
        System.out.println("Minimum Chromatic Number calculated is "+ncolors);
        gcolor(0);
        System.out.println("No of solutions is "+noOfSol);

  }

public static int  calculateMinChromaticNo()
{
   
    int assign [] = new int[nvertices];
    Arrays.fill(assign, -1);
    for (int i = 0; i < nvertices; i++) {
      assign[i] = 1;
      for(int j = 0;j<nvertices; j++) {
        if (adjacency[i][j] == 1 && assign[i] == assign[j]) {
          assign[i]++;
        } 
      }
    }
    int max = Integer.MIN_VALUE;
    for(int i =0;i<assign.length;i++) {
      if(assign[i]>max)
        max = assign[i];
    }

    return max;
}
public static boolean canAssign(int v,int c) 
  { 
    for (int i = 0; i < nvertices; i++) 
      if (adjacency[v][i] == 1 && c == colorAssignment[i]) 
        return false; 
    return true; 
  } 

public static void gcolor(int v)
  {

    if (v == nvertices)
    {
      for (v = 0; v < nvertices; v++)
        System.out.printf(namesOfColors[colorAssignment[v]-1]+"\t"); 

      System.out.println();
      noOfSol++;

      return;
    }

    for (int c = 1; c <= ncolors; c++)
    {     
      if (canAssign( v, c))
      {       
        colorAssignment[v] = c;     
        gcolor(v + 1);        
        colorAssignment[v] = 0;
      }
    }
  }

}

