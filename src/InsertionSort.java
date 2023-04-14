/**
 * This class contains a method for sorting with insertion sort 
 *
 * @author Tilda Jansson
 * @version 2021-02-28
 */ 
public class InsertionSort implements IntSorter
{   
    /**
     * Sorts the array in-place into ascending numerical order.
     *
     * @param v An array of ints.
     */
    public void sort(int[] v)
    {
        for (int t = 1; t < v.length; t++){
            int i = t;
            while(i > 0 && v[i-1] > v[i]){
                int temp = v[i];
                v[i] = v[i-1];
                v[i-1] = temp;
                i = i - 1;
            }
        }
    }    

}
