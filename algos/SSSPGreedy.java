import java.util.*;
import java.io.*;

class Main {

  static int N;
  static Vector v = new Vector();
  public static int minimum_dist(int dist[], Boolean visited[]){
    int min=10000000;
    int index=-1;
    for(int i=0;i<N;i++){
      //not yet visited and closest to source
      if(!visited[i] && dist[i]<min){
        index=i;
        min=dist[i];
      }        
    }
    return index;
  }

  public static int[] Dijkstra(int g[][], int source){
    int dist[]=new int[N];
    Boolean visited[]=new Boolean[N];

    for(int i=0;i<N;i++){
      dist[i]=Integer.MAX_VALUE;
      visited[i]=false;
    }

    dist[source]=0;

    for(int i=0;i<N-1;i++){
      //find the node closest to source in each iteration
      int min=minimum_dist(dist, visited);
      if(min==-1){
        break;
      }
      visited[min]=true;
      v.add(min+1);
      System.out.println("\nVisited vertices: "+v);
      //System.out.println();
      
      for(int j=0;j<N;j++){
  if(!visited[j] && g[min][j]!=0 && g[min][j]+dist[min]<dist[j] ){
    dist[j]=g[min][j]+dist[min];
    }
    //print
    if(dist[j]==Integer.MAX_VALUE)
    	System.out.print(j+": infinity"+"\t");
    else
    	System.out.print(j+": "+dist[j]+"\t");
   }

  }
   return dist; 
  }
  public static void main(String[] args) {
  	Scanner sc = new Scanner(System.in);
    int src;
    System.out.print("\n\nEnter number of vertices: ");
    N=sc.nextInt();
    //int graph[][]=new int[N][N];
    System.out.print("Enter source index: ");
    src=sc.nextInt();
    System.out.println("Enter Adjacency Matrix:");
    /*for(int i=0;i<N;i++){
    	for(int j=0;j<N;j++){
    		graph[i][j]=sc.nextInt();
    	}
    }*/

    /*int g[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0} 
                                 }; */


 int graph[][]= new int[][]{
 {0,50,45,10,0,0},
 {0,0,10,15,0,0},
 {0,0,0,0,35,0},
 {20,0,0,0,15,0},
 {0,20,35,0,0,0},
 {0,0,0,0,0,0}};

  System.out.println("\nIterations:");
    int dist[]=Dijkstra(graph,src);

    System.out.println("\nShortest Distance of nodes from the source:\n");
    System.out.println("Node"+"\t\t"+"Distance");

    for(int i=0;i<N;i++){
      if(dist[i]!=Integer.MAX_VALUE)
        System.out.println((i+1)+"\t\t"+dist[i]);
      else
        System.out.println((i+1)+"\t\tInfinite");
    }

    System.out.println("\nSHORTEST PATHS\n");

    for(int i=0;i<N;i++){

      Vector<Integer> path= new Vector<Integer>();

      if(dist[i]==graph[src][i]){
        System.out.println("Shortest path for "+(i+1)+": "+(src+1)+"-"+(i+1));
        continue;
      }
      
      path.add(i+1);
      int min_prev,index=-1;
      int new_node=i;
      
    do{
        //find a closest node to my node.
        min_prev=Integer.MAX_VALUE;
      for(int j=0;j<N;j++){
        if(graph[j][new_node]!=0&&graph[j][new_node]<min_prev&&dist[i]!=Integer.MAX_VALUE)
          {index=j; min_prev=graph[j][new_node];}
        }
  //add closest node to path
      path.add(index+1);
      new_node=index;
      if(index==-1)
        break;
        //keep tracing till we reach src.
    }while(new_node!=src);

        if(index==-1)
          System.out.println("Shortest path for "+(i+1)+": None");
        else{
          Collections.reverse(path);
          System.out.print("Shortest path for "+(i+1)+": ");
          Enumeration e =path.elements();
          System.out.print(e.nextElement());
          while(e.hasMoreElements())
            System.out.print("-"+e.nextElement());
          System.out.println();
        } 
             
    }

  }
}