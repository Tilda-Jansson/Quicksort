### Contents

* An insertion sort implementation of the `IntSorter` interface.
* Four quicksort implementations, detailed in [Variations of Quicksort](#variations-of-quicksort)
* Test classes for all five production classes, using inheritance to avoid test duplication.

#### Variations of Quicksort

Four variations of the Quicksort algorithm:

* `QuicksortFixedPivot` - uses a fixed pivot
* `QuicksortRandomPivot` - uses a randomly selected pivot
* `QuicksortFixedPivotInsertion` - fixed pivot with cut-off to insertion sort
  at 50.  Instead of stopping the recursion when the sub array only has at most
  one element, this version sub arrays that contain at most 50
  elements are sorted with insertion sort. The threshold at 50 has been decided by
  experimentation, see the [report](docs/A-Sudy-of-Quicksort(Tilda_Jansson).pdf) for more detail.
* `QuicksortRandomPivotInsertion` - as above, but with a random pivot

The key process in Quicksort is the partition. Instead of using a two way partition these implementations all use a three way partition. The 3-way partition function partitions the array/subarrays into three parts: one part that contains smaller elements than the pivot, the second part that contains elements equal to the pivot, and the third part contains all elements that are larger than the pivot value. This method is very useful when the input data contains a lot of duplicate values.

#### Testing

* [IntSorterTest](src/IntSorterTest.java).
    - For each implementation the test class IntSorterTest is extended with a
      test class (e.g. with `QuicksortFixedPivotTest`) and the `getIntSorter()` method.


* The following types of arrays are tested:
    - Arrays of even and odd length
    - Sorted in ascending order
    - Sorted in descending order (reversed)
    - Random
    - All elements equal
    - Very large arrays
    - [Data](src/Data.java) class generate these arrays.


#### Evaluating Sorting Algorithms

See the [report](docs/A-Sudy-of-Quicksort(Tilda_Jansson).pdf) for more details.
