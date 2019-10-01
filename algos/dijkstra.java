import java.util.*;
class Main 
{

  Scanner s=new Scanner(System.in);
  int adj[][];
  boolean visit[]=new boolean[9];
  int distance[]=new int[9];
  int temp[]=new int[9];
  int path[]=new int[9];
  LinkedHashMap<Integer,Integer> hm=new LinkedHashMap<>();
  





  public int relaxation()
  {
    int pos=0;
    int min=Integer.MAX_VALUE;
    for(int i=0;i<distance.length;i++)
    {
      if(distance[i]<min && visit[i]!=true)
      {
        min=distance[i];
        pos=i;
      }
    }
    visit[pos]=true;
    hm.put(pos,min);
    return pos;
  }
  
  public void shortestPath(int source)
  {
    
    distance[source]=0;
    
    for(int i=0;i<distance.length;i++)
    {
      if(adj[source][i]==0 && i!=source)
        distance[i]=Integer.MAX_VALUE;
      else
      {
        distance[i]=adj[source][i];
      }
    }
    hm.put(source,0);
    
    
    visit[source]=true;
    int count=8;
   
    while(count>0)
    {
      source=relaxation();
      
      
        
      
      System.out.println("source:"+source);
      for(int j=0;j<distance.length;j++)
      {
        
        if(distance[source]+adj[source][j]<distance[j] &&visit[j]!=true && j!=source && adj[source][j]!=0)
        {
          distance[j]=distance[source]+adj[source][j];
          
          //hm.put(j,distance[j]);
          System.out.println("node updated:"+j+" distance:"+distance[j]);
          System.out.println("updated array:"+Arrays.toString(distance));

        }
        
      }
      count--;
      
    }
    

    //System.out.println(Arrays.toString(temp));
  

  System.out.println(Arrays.toString(distance));
  System.out.println("Shortest path from source vertex is:");
  System.out.println(hm.toString());



   
    


    //System.out.println(Arrays.toString(distance));


  }
  public void input_func()
  {
    System.out.println("No of nodes in the graph:9");
    adj=new int[][]{{0, 4, 0, 0, 0, 0, 0, 8,0},
    {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
    {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
    {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
    {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
    {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
    {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
    {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
    {0, 0, 2, 0, 0, 0, 6, 7, 0}}; 
   /* System.out.println("input array:");
    for(int i=0;i<adj.length;i++)
    {
      for(int j=0;j<adj[i].length;j++)
      {
        System.out.print(adj[i][j]);
      }
      System.out.println();
    }*/

    System.out.println("Select source vertex:");
    int source=s.nextInt();
    shortestPath(source);
   
   

    /*System.out.println("enter adj matrix:");
    for(int i=0;i<adj.length;i++)
    {
      for(int j=0;j<adj.length;j++)
      {
        System.out.print("enter "+i+" "+j+":");
        adj[i][j]=s.nextInt();
      }
      System.out.println();*/
    
    
  }
  public static void main(String[] args) 
  {
    System.out.println("DIJKSTRA'S ALGORITHM");
    Main m=new Main();
    long start=System.currentTimeMillis();
    m.input_func();
    long end=System.currentTimeMillis();
    System.out.println("time taken in ms:"+(end-start));



  }
}