/*
 * This work complies with the JMU Honor Code.
 * References and Acknowledgments: I received no outside help with this
 * programming assignment.
 */

/**
 * IntroSort class.
 *
 * @author Dylan Moreno
 * @version 12/1/2021
 */
public class IntroSort extends QuickSort {

  private static double badDepth;  // The marker for when quicksort should switch strategies

  /**
   * Sort the provided items using the intro sort algorithm.
   */
  public static <T extends Comparable<T>> void introSort(T[] items) {

    if (items.length > 0) {
      // Set the strategy switch point as (2 * (the floor of (log base 2 of the number of items))))
      badDepth = 2 * Math.floor(Math.log(items.length) / Math.log(2));
      quickSort(items, 0, items.length - 1, 0);
    }
  }

  /**
   * Recursive helper method for quicksort.
   */
  private static <T extends Comparable<T>> void quickSort(T[] items, int left, int right,
                                                          int depth) {

    // Switch to mergesort if the recursion depth exceeds badDepth
    if (depth > badDepth) {
      MergeSortsImproved.mergeSort2(items, left, right);
      return;
    }

    /* Else, continue with quicksort as normal */

    int pivotindex = findPivot(items, left, right);

    // Curr will be the final position of the pivot item.
    int curr = partition(items, left, right, pivotindex);

    if ((curr - left) > 1) {
      quickSort(items, left, curr - 1, depth + 1); // Sort left partition
    }
    if ((right - curr) > 1) {
      quickSort(items, curr + 1, right, depth + 1); // Sort right partition
    }
  }

}
