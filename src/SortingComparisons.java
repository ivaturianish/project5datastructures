
/**
 * This class implements six different comparison sorts (and an optional
 * heap sort for extra credit):
 * 
 * insertion sort
 * selection sort
 * shell sort
 * quick sort
 * bubble sort
 * merge sort
 * (extra credit) heap sort
 * 
 * It also has a method that runs all the sorts on the same input array and
 * prints out statistics.
 */

public class SortingComparisons{

    /**
     * Sorts the given array using the insertion sort algorithm. Note: after
     * this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <T extends SortObject> void insertionSort(T[] A) {
    	int i = 0 , j = 0;
    	SortObject k = new SortObject();
    	for(i=1; i<A.length; i++){
    		k.assignTo(A[i]);
    		j = i-1;
    	while(j >= 0 && A[j].compareTo(k) > 0){
    		A[j+1] = A[j];
    		j = j-1;
    	}
    	A[j+1].assignTo(k);
    	}
    	}


    /**
     * Sorts the given array using the selection sort algorithm. 
     * Note: after this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <T extends SortObject> void selectionSort(T[] A) {
    	int min = 0;
    	for (int i=0; i<A.length;i++){
    		for(int j=i; j<A.length; j++){
    			min = i;
    			if(A[j].compareTo(A[min]) < 0){
    				min = j;
    				}
    		SortObject temp = new SortObject();
    		temp.assignTo(A[i]);
    		A[i].assignTo(A[min]);
    		A[min].assignTo(temp);
    	}
    	}
    }  

    /**
     * Sorts the given array using the bubble sort algorithm.
     * Note: after this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <T extends SortObject> void bubbleSort(T[] A) {
    	for(int i=0; i<A.length-1;i++) {
    		for(int j=0; j<A.length-1;j++) {
    			if(A[j].compareTo(A[j+1]) > 0) {
    				SortObject temp = new SortObject();
    				temp.assignTo(A[j+1]);
    				A[j+1].assignTo(A[j]);
    				A[j].assignTo(temp);
    			}
    		}
    	}
    }
    
    
    /**
     * Sorts the given array using the shell sort algorithm.
     * Note: after this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
 	public static <T extends SortObject> void shellSort(T[] A)
 	{
 		for(int gap = A.length/2; gap>0; gap/=2) {
 			for(int i = gap; i<A.length;i++) {
 				SortObject temp = new SortObject();
 				temp.assignTo(A[i]);
 				int j;
 				for(j = i; j >= gap && A[j-gap].compareTo(temp)>0;j-=gap) {
 					A[j].assignTo(A[j-gap]);	
 				}
 				A[j].assignTo(temp);	
 			}
 			}

 	 	
 	} // end shellSort

 
    /**
     * Sorts the given array using the merge sort algorithm. 
     * Note: after this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
   
 	public static <T extends SortObject> void mergeSort(T[] A) {
 		int[] left = new int[A.length/2+1];
 		int[] right = new int[A.length-1+A.length/2];
 		for(int i = 0; i< A.length/2+1; i++) {
 			SortObject temp = new SortObject();
 			temp.assignTo(A[i]);
 			left[i] = temp.getData();
 		}
 		for(int i = A.length-1; i < A.length/2;i--){
 			SortObject temp = new SortObject();
 			temp.assignTo(A[i]);
 			right[i] = temp.getData();
 		}
 		 int i = 0, j = 0;
         int k = 0;
         while (i < A.length/2+1 && j < A.length-1+A.length/2){
        	 if (left[i] <= right[j])
             {
        		 SortObject temp = new SortObject(left[i]);
                 A[k].assignTo(temp);
                 i++;
             }
             else
             {
            	 SortObject temp = new SortObject(right[j]);
                 A[k].assignTo(temp);
                 j++;
             }
             k++;
         }
         while (i < A.length/2+1)
         {
        	 SortObject temp = new SortObject(left[i]);
             A[k].assignTo(temp);
             i++;
             k++;
         }
         while (j <A.length-1)
         {
        	 SortObject temp = new SortObject(right[j]);
             A[k].assignTo(temp);
             j++;
             k++;
         }
         
     }
  
        	 
 		 

   
        
    /**
     * Sorts the given array using the quick sort algorithm, using the median of
     * the first, last, and middle values in each segment of the array as the
     * pivot value. 
     * Note: after this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A   the array to sort
     */
    public static <T extends SortObject> void quickSort(T[] A) {
    	if(A[0].compareTo(A[A.length-1]) < 0) {
    	 	SortObject temp = new SortObject();
    		temp.assignTo(A[A.length-1]);
    		SortObject temp2 = new SortObject();
    		temp2.assignTo(A[0]);
        	int pivot = temp.getData();
        	int i = temp2.getData()-1;
        	for (int j=temp2.getData(); j<temp.getData(); j++) {
        		if(A[j].compareTo(temp) < 0) {
        			i++;
        			SortObject temp3 = new SortObject();
        			temp3.assignTo(A[i]);
        			A[i].assignTo(A[j]);
        			A[j].assignTo(temp3);
        			
        			
        			
        		}
        	}
        	SortObject temp4 = new SortObject();
    		temp4.assignTo(A[i+1]);
    		A[i+1].assignTo(A[A.length-1]);
    		A[A.length-1].assignTo(temp4);
    		int parition = i+1;
    	}
    	

		
    }


        
    /**
     * Sorts the given array using the heap sort algorithm outlined below. 
     * Note: after this method finishes the array is in sorted order.
     * 
     * The heap sort algorithm is:
     * 
     * for each i from 1 to the end of the array
     *     insert A[i] into the heap (contained in A[0]...A[i-1])
     *     
     * for each i from the end of the array up to 1
     *     remove the max element from the heap and put it in A[i]
     * 
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <T extends SortObject> void heapSort(T[]  A)
    {
    	
       	
    }    
    
       
    
 
    /**
     * Internal helper for printing rows of the output table.
     * 
     * @param sort          name of the sorting algorithm
     * @param compares      number of comparisons performed during sort
     * @param moves         number of data moves performed during sort
     * @param milliseconds  time taken to sort, in milliseconds
     */
    @SuppressWarnings("unused")
	private static void printStatistics(final String sort, final int compares, final int moves,
                                        final long milliseconds) {
        System.out.format("%-23s%,15d%,15d%,15d\n", sort, compares, moves, 
                          milliseconds);
    }

    /**
     * Sorts the given array using the six (heap sort with the extra credit)
     * different sorting algorithms and prints out statistics. The sorts 
     * performed are:
     * 
     * insertion sort
     * selection sort
     * shell sort
     * quick sort
     * bubble sort
     * merge sort
     * (extra credit) heap sort
     * 
     * The statistics displayed for each sort are: number of comparisons, 
     * number of data moves, and time (in milliseconds).
     * 
     * Note: each sort is given the same array (i.e., in the original order). 
     * 
     * @param A  the array to sort
     */
    public static <T extends SortObject>void runAllSorts(T[] A) {
        System.out.format("%-23s%15s%15s%15s\n", "algorithm", "data compares", 
                          "data moves", "milliseconds");
        System.out.format("%-23s%15s%15s%15s\n", "---------", "-------------", 
                          "----------", "------------");
        // TODO: run each sort and print statistics about what it did
        
        long startTime, endTime;
        T[] arr=reset(A);
        startTime = System.nanoTime();
        insertionSort(arr);
        endTime = System.nanoTime();

        System.out.format("%-23s%15s%15s%15s\n", "insertion sort", SortObject.getCompares(), 
                SortObject.getAssignments(),(endTime-startTime)/1000000);
        
        arr=reset(A);
        startTime = System.nanoTime();
        selectionSort(arr);
        endTime = System.nanoTime();
        System.out.format("%-23s%15s%15s%15s\n", "selection sort", SortObject.getCompares(), 
                 SortObject.getAssignments(),(endTime-startTime)/1000000);
  
        
        arr=reset(A);
        startTime = System.nanoTime();
        shellSort(arr);
        endTime = System.nanoTime();
        System.out.format("%-23s%15s%15s%15s\n", "shell sort", SortObject.getCompares(), 
                   SortObject.getAssignments(),(endTime-startTime)/1000000 );
          

        arr=reset(A);
        startTime = System.nanoTime();
        quickSort(arr);
        endTime = System.nanoTime();
          System.out.format("%-23s%15s%15s%15s\n", "quick sort", SortObject.getCompares(), 
                    SortObject.getAssignments(),(endTime-startTime)/1000000);
    

        arr=reset(A);
        startTime = System.nanoTime();
        heapSort(arr);
        endTime = System.nanoTime();
        System.out.format("%-23s%15s%15s%15s\n", "heap sort", SortObject.getCompares(), 
                    SortObject.getAssignments(),(endTime-startTime)/1000000);

          
        arr=reset(A);
        startTime = System.nanoTime();
        bubbleSort(arr);
        endTime = System.nanoTime();
        System.out.format("%-23s%15s%15s%15s\n", "bubble sort", SortObject.getCompares(), 
                    SortObject.getAssignments(),(endTime-startTime)/1000000);

           
        arr=reset(A);
        startTime = System.nanoTime();
        mergeSort(arr);
        endTime = System.nanoTime();
        System.out.format("%-23s%15s%15s%15s\n", "merge sort", SortObject.getCompares(), 
                    SortObject.getAssignments(),(endTime-startTime)/1000000);
    }
    
    @SuppressWarnings("unchecked")
	private static <T extends SortObject> T[] reset(T[] A){

    	SortObject[] arr = TestSort.makeCopy(A, A.length); 
        SortObject.resetCompares();
    	SortObject.resetAssignments();
    	return (T[])arr;
        
    }
}
