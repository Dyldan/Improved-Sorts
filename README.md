# Improved-Sorts
Provides 2 improved mergesort algorithms, improved introspective sort, and an insertion sort that works on regions of an array

First mergesort uses an auxilary arrary that is half the size of normal mergesort.
Second mergesort switches to insertion sort for array sub-regions that are below a certain threshold
Improved introspective sort switches to the second improved mergesort when the algorithm detects that the input array is pathological


Please see the provided analysis for performance improvement details.
