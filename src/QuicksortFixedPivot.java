
/**
 * Class of QuickSort that uses a fixed pivot
 *
 * @author Tilda Jansson
 * @version 2021-02-28
 */
public class QuicksortFixedPivot extends Parent implements IntSorter
{
    /**
     * Sorts the array in-place into ascending numerical order.
     *
     * @param v An array of ints.
     */
    public void sort(int[] v)
    {
        quicksort(v, 0, v.length-1);
    }
    
    private void quicksort(int[] arr, int from, int to){
        if(from < to){
            int[] counters = threeWayPartition(arr, from, to, to);
            
            quicksort(arr, from, counters[0]);
            quicksort(arr, counters[1], to);
        }
    }
}
