/**
 * Class of a hybrid of the Quicksort with the insertion sort. 
 * Quicksort uses a random pivot.
 *
 * @author Tilda Jansson
 * @version 2021-03-18
 */
public class QsRandomPivotInsertion extends Parent implements Threshold
{
    /**
     * Sorts the array in-place into ascending numerical order.
     * 
     * Uses quicksort and insertion sort.
     * Quicksort uses a random pivot with cut-off to insertion sort at threshold.
     * 
     * @param v An array of ints.
     * @param threshold cut-off point
     */
    public void sort(int[] v, int threshold)
    {
        quicksortOp(v, 0, v.length-1, threshold);     
    }


    private void quicksortOp(int [] arr, int from, int to, int threshold)
    {
        if(arr.length < threshold) 
        {
            insertionSort(arr, from, to);

        }
        
        else if(from<to){
            int counter = randomMedianPivot(arr, from, to); 
            swop(arr, counter,to);

            int[] counters = threeWayPartition(arr, from, to, to);
                
            quicksortOp(arr, from, counters[0], threshold);
            quicksortOp(arr, counters[1], to, threshold);
            }
        }
}
