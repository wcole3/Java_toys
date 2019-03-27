//toy program to sort recursively 
//sorting an array of 100 random ints
public class sorting_by_recursion {

	public static void main(String[] args) {
		// first new to get a random array of ints
		int Len= 100;
		System.out.println("Welcome to the sort routine");
		//gen randomw array
		int [] random= new int[Len];
		for(int i=0;i<Len;i++){
			random[i]=(int)((Math.random()*100)+1);
		}
		System.out.println("The unsorted array is: ");
		printArray(random);
		System.out.println("Sorting...");
		//now sort the array
		int[] sorted =sort(random);
		System.out.println("The sorted array is: ");
		printArray(sorted);
	}
	//function to print out the array
	static void printArray(int array[]){
		int size=array.length;
		for(int i=0; i<size;i++){
			if(array[i]<10){
				System.out.print("  "+array[i]+" ");
			}
			else if(array[i]>99){System.out.print(array[i]+" ");}
			else{
				System.out.print(" "+array[i]+" ");
			}
			//start a new line every 20 elements
			if((i+1)%20==0){
				System.out.println();
			}
		}
	}
	//create an array object to hold the sorted array while being sorted
	//the reason this is here is so we don't have to continuously pass the array 
	//to all the different functions
	private static int[] a;
	static int[] sort(int array[]){
		a=array;
		sort(0,a.length-1);
		return a;
	}
	public static void sort(int low, int hi){
		//this function will be recursive
		//first need to partion the array into two smaller arrays
		
		//first and end condition
		if(low>=hi){
			return;
		}
		//need to get a changing pivot point
		int p=partition(low, hi);
		sort(low,p);
		sort(p+1,hi);
	}
	//this function will create a partition of an array into two smaller arrays
	public static int partition(int low, int hi){
		//we choose the first value as the pivot
		int pivot=a[low];
		//starting variables
		int i=low-1;
		int j= hi+1;
		//loop through the partition
		while(i<j){
			for(i++;a[i]<pivot;i++);
			for(j--;a[j]>pivot;j--);
			if(i<j){
				swap(i,j);
			}
		}
		return j;
		
	}
	//need a function to swap location of two elements
	public static void swap(int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
