/*
 * OpenDSA Project Distributed under the MIT License
 *
 * Copyright (c) 2011-2016 - Ville Karavirta and Cliff Shaffer
 */

/*
 * This work complies with the JMU Honor Code.
 * References and Acknowledgments: I received no outside help with this
 * programming assignment.
 */

/**
 * Basic n^2 sorting algorithms.
 *
 * @author Dylan Moreno
 * @version 12/1/2021
 */
public class BasicSorts {

  /**
   * Insertion sort the array.
   */
  public static <T extends Comparable<T>> void insertionSort(T[] items) {

    for (int i = 1; i < items.length; i++) { // Insert i'th record
      T cur = items[i];
      int j = i;
      for (; (j > 0) && (cur.compareTo(items[j - 1]) < 0); j--) {
        items[j] = items[j - 1];
      }
      items[j] = cur;
    }
  }

  /**
   * Insertion sort just the indicated region of the array.
   */
  public static <T extends Comparable<T>> void insertionSort(T[] items, int start, int end) {

    for (int i = start + 1; i <= end; i++) {
      T cur = items[i];
      int j = i;
      for (; (j > start) && (cur.compareTo(items[j - 1]) < 0); j--) {
        items[j] = items[j - 1];
      }
      items[j] = cur;
    }

  }

  /**
   * Swap items i and j in the provided array.
   */
  public static <T extends Comparable<T>> void swap(T[] items, int i, int j) {
    T tmp = items[i];
    items[i] = items[j];
    items[j] = tmp;
  }

}
