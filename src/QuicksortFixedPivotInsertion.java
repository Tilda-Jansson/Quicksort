/**
 * Class of a hybrid of the Quicksort with the insertion sort.
 * Quicksort uses a fixed pivot.
 *
 * @author Tilda Janssom
 * @version 2021-02-28
 */
public class QuicksortFixedPivotInsertion extends Parent implements IntSorter
{

    /**
     * Sorts the array in-place into ascending numerical order.
     *
     * Uses quicksort and insertion sort.
     * Quicksort uses a fixed pivot with cut-off to insertion sort at 50.
     *
     * @param v An array of ints.
     */
    public void sort(int[] v)
    {
        quicksortOp(v, 0, v.length-1);       
    }


    private void quicksortOp(int [] arr, int from, int to)
    {
        if(arr.length < 50) //Switch to insertion sort when there are only 50 elements in array/subarray
            {
             insertionSort(arr, from, to); 
        }
        else if(from<to){
             int[] counters = threeWayPartition(arr,from,to,to);
             quicksortOp(arr, from, counters[0]); 
             quicksortOp(arr, counters[1], to); 
        }
    }
}
