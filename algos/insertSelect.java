import java.util.*;
class EXP1 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("1) Randomised input\n2) User input\n");     
    System.out.print("Enter option: ");
    int choice = sc.nextInt();

    System.out.println("Enter size of array: ");
    int n=sc.nextInt();

    int[] arr1=new int[n];
    int[] arr2=new int[n];

    if(choice==1)                                                        //Taking Random Inputs
    {
      Random r = new Random();
      for(int i=0;i<n;i++)
      {
      int p=r.nextInt(100);
      arr1[i]=p;
      arr2[i]=p;
      }
    }
      else
      
   {
      System.out.println("Enter elements");                  //Taking User Inputs
      for(int i=0;i<n;i++)
      {
      int p=sc.nextInt();
      arr1[i]=p;
      arr2[i]=p;
      }
   }

   System.out.println("\n1) Non-recursive\n2) Recursive");
   int opt=sc.nextInt();
   if(opt==1)
   {                                                                                                                //Time Calculation for Insertion sort
     
     long t=System.currentTimeMillis();
     insertionSort(arr1, n);
     long end=System.currentTimeMillis()-t;
     
     System.out.println("\nAfter  Insertion Sort: ");
     
     if(choice==2)
     {
       
       for(int i=0;i<n;i++)
       {
         System.out.print(arr1[i]+" ");
       }
     } 
       
     System.out.println("\nTime taken: "+((float)end/(float)1000));
                                                                                                                       //Time Calculation for Selection sort

     t=System.currentTimeMillis();
     selectionSort(arr2, n);
     end=System.currentTimeMillis()-t;
     
     System.out.println("\nAfter Selection Sort: ");
     
     if(choice==2)
     {
     
     for(int i=0;i<n;i++)
     {
       System.out.print(arr1[i]+" ");
     }
     
     }
     System.out.println("\nTime taken: "+((float)end/(float)1000));
     
   }

   if(opt==2)
   {
   	
   	
     long t=System.currentTimeMillis();   	         //Time Calculation for Recursive Insertion sort
     insRec(arr1,1,n);
     long end=System.currentTimeMillis()-t;
     
     System.out.println("\nAfter Recursive Insertion Sort: ");
     
     if(choice==2)
     {
     
     for(int i=0;i<n;i++)
     {
       System.out.print(arr1[i]+" ");
     }
     }
     
     System.out.println("\nTime taken: "+((float)end/(float)1000));
     
     t=System.currentTimeMillis();            //Time Calculation for Recursive Selection sort
     selRec(arr2, 0, n);
     end=System.currentTimeMillis()-t;
     
     
     
     if(choice==2)
     {
    
     for(int i=0;i<n;i++)
     {
       System.out.print(arr2[i]+" ");
     }
     }
     
     System.out.println("\nTime taken: "+((float)end/(float)1000));
   }
   
  }


 public static void insertionSort(int a[],int n)                 //Insertion sort
 {
    for(int i=1;i<n;i++){
    int val=a[i];
    int j=i-1;
    for(;j>=0&&a[j]>val;j--){
      a[j+1]=a[j];
    }
    a[j+1]=val;
  }
 
 }

  public static void selectionSort(int a[],int n)           //Selection sort
 {
  for(int i=0;i<n-1;i++)
{
  int index=i;
  for(int j=i+1;j<n;j++)
 {
   if(a[j]<a[index])
    index=j;
 }
   int temp=a[i];
   a[i]=a[index];
   a[index]=temp;
}

 
 }

  public static void insRec(int a[],int i,int n)                //Recursive Insertion sort
  {
    if(i==n)
    return; 
    
    int val=a[i];
    int j=i-1;
    for(;j>=0&&a[j]>val;j--){
      a[j+1]=a[j];
    }
    a[j+1]=val;
    i++;
    
    insRec(a,i,n);
   
  }

  public static void selRec(int a[],int i,int n)         //Recursive Selection sort
  {
 if(i==n)
 return;

  int index=i;
  for(int j=i+1;j<n;j++)
 {
   if(a[j]<a[index])
    index=j;
 }
   int temp=a[i];
   a[i]=a[index];
   a[index]=temp;   
    i++;
   selRec(a,i,n);   
}
  
}
