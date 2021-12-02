/*
 * This work complies with the JMU Honor Code.
 * References and Acknowledgments: I received no outside help with this
 * programming assignment.
 */

/**
 * Improved MergeSort class.
 *
 * @author Dylan Moreno
 * @version 12/1/2021
 */
public class MergeSortsImproved {

  private static final int MERGE_SORT_THRESHOLD = 100; // TODO change

  /**
   * Merge sort the provided array using an improved merge operation.
   */
  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> void mergeSort1(T[] items) {

    // Unfortunately, it is not possible to create an array of T's, this is the
    // workaround.
    T[] temp = (T[]) new Comparable[items.length / 2 + 1];

    mergesort1(items, temp, 0, items.length - 1);
  }

  /**
   * Recursive helper method for the improved merge sort.
   */
  private static <T extends Comparable<T>> void mergesort1(T[] items, T[] temp, int left,
                                                           int right) {

    if (left >= right) {
      return; // Region has only one record
    }

    int mid = (left + right) / 2; // Select midpoint

    mergesort1(items, temp, left, mid);             // Mergesort first half
    mergesort1(items, temp, mid + 1, right);    // Mergesort second half

    // Merge this region's 2 halves together
    merge1(items, temp, left, mid, right);
  }

  /**
   * Merge two sorted sub-arrays.
   */
  private static <T extends Comparable<T>> void merge1(T[] items, T[] temp, int left, int mid,
                                                       int right) {

    // Copy subarray to temp
    for (int i = 0; i < temp.length && i + left <= mid; i++) {
      temp[i] = items[i + left];
    }

    int i1 = 0;         // Index of first position in temp array
    int i2 = mid + 1;   // Index of first position of sorted right half

    for (int curr = left; curr <= right; curr++) {
      if (i1 == temp.length || i1 + left > mid) {      // Left subarray exhausted
        items[curr] = items[i2++];
      } else if (i2 > right) {                         // Right subarray exhausted
        items[curr] = temp[i1++];
      } else if (temp[i1].compareTo(items[i2]) <= 0) { // Left value is less than right value
        items[curr] = temp[i1++];
      } else {                                         // Right value is less than left value
        items[curr] = items[i2++];
      }
    }
  }

  /**
   * Merge sort the provided array by using an improved merge operation and
   * switching to insertion sort for small sub-arrays.
   */
  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> void mergeSort2(T[] items) {

    // Unfortunately, it is not possible to create an array of T's, this is the
    // workaround.
    T[] temp = (T[]) new Comparable[items.length];

    mergeSort2(items, temp, 0, items.length - 1);
  }

  /**
   * Merge sort the provided sub-array using our improved merge sort. This is the
   * fallback method used by introspective sort.
   */
  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> void mergeSort2(T[] items, int start, int end) {

    // Unfortunately, it is not possible to create an array of T's, this is the
    // workaround.
    T[] temp = (T[]) new Comparable[items.length];

    mergeSort2(items, temp, start, end);
  }

  /**
   * Recursive helper method for the improved merge sort.
   */
  private static <T extends Comparable<T>> void mergeSort2(T[] items, T[] temp, int left,
                                                           int right) {

    if (left >= right) {
      return; // Region has one record
    }


    // Insertion sort on small regions
    if (right - left < MERGE_SORT_THRESHOLD) {
      BasicSorts.insertionSort(items, left, right);
      return;
    }

    // Mergesort on larger regions
    int mid = (left + right) / 2;                   // Select midpoint

    mergeSort2(items, temp, left, mid);             // Mergesort first half
    mergeSort2(items, temp, mid + 1, right);    // Mergesort second half

    merge2(items, temp, left, mid, right);
  }

  /**
   * Merge two sorted sub-arrays.
   */
  private static <T extends Comparable<T>> void merge2(T[] items, T[] temp, int left, int mid,
                                                      int right) {

    for (int i = left; i <= right; i++) {
      temp[i] = items[i]; // Copy subarray to temp
    }

    int i1 = left;
    int i2 = mid + 1;
    for (int curr = left; curr <= right; curr++) {
      if (i1 == mid + 1) {                            // Left subarray exhausted
        items[curr] = temp[i2++];
      } else if (i2 > right) {                        // Right subarray exhausted
        items[curr] = temp[i1++];
      } else if (temp[i1].compareTo(temp[i2]) <= 0) { // Get smaller value
        items[curr] = temp[i1++];
      } else {                                        // Get bigger value
        items[curr] = temp[i2++];
      }
    }
  }

}
