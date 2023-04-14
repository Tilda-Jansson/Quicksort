/**
 * An interface for to find the optimal cut-off point.
 *
 * @author Tilda Jansson
 * @version 2021-03-17
 */
public interface Threshold {
    /**
     * Sorts the array in-place into ascending numerical order.
     *
     * @param v An array of ints.
     * @param threshold cut-off point
     */
    void sort(int[] v, int threshold);
}
