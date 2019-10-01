import java.util.*;
class item{
	int id;
	int profit;
	int wt;
	double fraction;

	item(int id,int profit, int wt,double fraction)
	{
		this.id=id;
		this.profit=profit;
		this.wt=wt;
		this.fraction=fraction;
	}
}
class knapsackGreedy{
	static int n,M;
	static item[] arr;

	public static void main(String args[])
	{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter no of items");
	n = sc.nextInt();
	arr = new item[n];
	double[] ratio = new double[n];
	for(int i=0;i<n;i++)
	{
		System.out.println("Enter profit and wt of item "+(i+1));
		int m=sc.nextInt();
		int n=sc.nextInt();
		ratio[i]=(double)m/n;
		arr[i]=new item(i+1,m,n,0);		
	}
	System.out.println("Enter value of M");
	 M=sc.nextInt();

	System.out.println("\n\nBased on maximum Profit");
	SortAccToProfit();
	KnapSackSolution();
	System.out.println("\n\nBased on minimum Weight");
	SortAccToWeight();
	KnapSackSolution();
	System.out.println("\n\nBased on maximum Profit/Weight ratio");
	SortAccToRatio(ratio);	
	KnapSackSolution();
	
	
	}





	 public static void SortAccToRatio(double ratio[])       //Insertion sort
 {
    for(int i=1;i<n;i++){
    double val=ratio[i];
    item m=arr[i];
    
    int j=i-1;
    for(;j>=0&&ratio[j]<val;j--){
      arr[j+1]=arr[j];
      ratio[j+1]=ratio[j];
    }
    arr[j+1]=m;
    ratio[j+1]=val;
  }
 

 }

 	 public static void SortAccToID()       //Insertion sort
 {
    for(int i=1;i<n;i++){
    int val=(int)arr[i].id;
    item m=arr[i];

    int j=i-1;
    for(;j>=0&&(int)arr[j].id>val;j--){
      arr[j+1]=arr[j];
      
     
    }
    arr[j+1]=m;
   
  }
 

 }

 public static void SortAccToProfit()       //Insertion sort
 {
    for(int i=1;i<n;i++){
    int val=(int)arr[i].profit;
    item m=arr[i];

    int j=i-1;
    for(;j>=0&&(int)arr[j].profit<val;j--){
      arr[j+1]=arr[j];
      
     
    }
    arr[j+1]=m;
   
  }
 

 }

 public static void SortAccToWeight()       //Insertion sort
 {
    for(int i=1;i<n;i++){
    int val=(int)arr[i].wt;
    item m=arr[i];

    int j=i-1;
    for(;j>=0&&(int)arr[j].wt>val;j--){
      arr[j+1]=arr[j];
      
     
    }
    arr[j+1]=m;
   
  }
 

 }

 public static void KnapSackSolution()
 {
 	int wt=0;
	double profit=0;

	for(int i=0;i<n;i++)
	{
		if(wt+arr[i].wt<=M)
	  {

		profit+=arr[i].profit;
		arr[i].fraction=1;
		wt+=arr[i].wt;	
		
	  }else
	  {
		
		profit+=arr[i].profit*((double)(M-wt)/arr[i].wt);
		arr[i].fraction=((double)(M-wt)/arr[i].wt);
		break;	  	
	  }

	}

   SortAccToID();

	System.out.print("\n\nObjects \t");
	for(int i=0;i<n;i++)
		System.out.print(arr[i].id+"\t");
	System.out.print("\n\nFractions \t");
	for(int i=0;i<n;i++)
		System.out.format("%.2f\t",arr[i].fraction);

	System.out.format("\n\nMaximum Profit is %.2f\t",profit);
 }
}