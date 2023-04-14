import java.util.Random;
/**
 * A superclass that contains methods the variations of the Quicksort have
 * incommon in order to avoid code duplication.
 *
 * @author Tilda Jansson
 * @version 2021-02-28
 */
public class Parent
{
    /**
     * Swap two elements in an array of ints.
     *
     * @param array  An array of ints.
     * @param from   position of element to swop
     * @param to     position of element to swop
     */

    public void swop(int[] arr, int from, int to)
    {
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }

    /**
     * Two way partitioning an array of ints.
     *
     * @param array  An array of ints.
     * @param from   Position of the first element in the array/subarray
     * @param to     Position of the last element in the array/subarray
     * 
     * @return counter Position of the pivot element after partitioning
     */

    public int partition(int[] arr, int from, int to)
    {
        int value = arr[to]; //Pivot point
        int counter = from -1;
        for(int i = from; i<to; i++){
            if(arr[i]<= value){
                counter++;
                swop(arr, counter, i);
            }
        }
        swop(arr, counter+1, to);
        return counter+1;
    }
    
    /**
     * 3 way partitioning an array of ints.
     *
     * @param array  An array of ints to be partitioned.
     * @param from   Position of the first element in the array/subarray
     * @param to     Position of the last element in the array/subarray
     * @param pivot  index of value to compare with
     * 
     * @return breaks   array including index breakpoints
     */
    public int[] threeWayPartition(int[] arr, int from, int to, int pivot){
        int pivotV = arr[pivot];
        int[] breaks = new int[2];
        int mid = from;
        
        while (mid <= to){
            if(arr[mid] > pivotV){
                swop(arr, mid, to);
                to--;
            }
            else if(arr[mid] < pivotV){
                swop(arr, from, mid);
                from++;
                mid++;
            }
            else{
                mid++;
            }
        }
        breaks[0] = from-1;
        breaks[1] = mid;
        return breaks;
    }
    
    /**
     * Picks a random integer from the array.
     *
     * @param arr  An array of ints.
     * @param from   position of the first element in the array/subarray
     * @param to     Position of the last element in the array/subarray
     * @return the index of the median of three randomly selected elements
     */
    
    public int randomMedianPivot(int[] arr, int from, int to){
        Random random = new Random();
        int rand1 = random.nextInt(to-from +1)+from;
        int rand2 = random.nextInt(to-from +1)+from;
        int rand3 = random.nextInt(to-from +1)+from;
        
        if( rand2>rand3 && rand3>rand1 && rand1<rand3 && rand3<rand2){
            return rand3;
        }
        else if(rand3<rand2 && rand2<rand1 && rand1<rand2 && rand2<rand3){
            return rand2;
        }
        else{
            return rand1;
        }
    }
    
    

    /**
     * Sorts an array of ints with insertion sort.
     *
     * @param arr  An array of ints.
     * @param from   position of the first element in the array/subarray
     * @param to     Position of the last element in the array/subarray
     */

    public void insertionSort(int[] arr,int from, int to)
    {
        for (int i = from+1; i <= to; i++)
        {
            int value = arr[i];
            int j = i;
            while(j > from && arr[j-1] > value)
            {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = value;
        }
    }
}
