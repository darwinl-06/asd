package Answer

import scala.annotation.tailrec
import scala.util.Random

object Methods extends App with IMethods {


  // ------ Problem 1  ------------------------------------------------------------------------------------------------

  /**
   * Inversions: pulls out the first mSort return
   *
   * @param list List of integers we want to order
   * @return Number of inversions
   */
  override def inversions(list: List[Int]): Int = mSort(list)._1 //Getting the first part of the return of mSort

  /**
   * Modificated Merge Sort algorithm
   *
   * @param xs List of integers we want to order
   * @return Number of inversions , Ordered list
   */
  override def mSort(xs: List[Int]): (Int, List[Int]) = {

    /**
     * Merge algorithm: orders and counts the number of inversions
     *
     * @param l1    First part of the split list
     * @param l2    Second part of the split list
     * @param count Inversions counter
     * @return Number of inversions , Ordered list
     */
    def merge(l1: List[Int], l2: List[Int], count: Int = 0): (Int, List[Int]) =
      (l1, l2) match {
        case (Nil, l2) => (count, l2) //Case in which the first list is empty
        case (l1, Nil) => (count, l1) //Case in which the second list is empty
        case (l1head :: l1tail, l2head :: l2tail) => //Case where both lists have content
          if (l1head <= l2head) {
            val (l1count, list) = merge(l1tail, l2, count) //If the head of the second list is bigger than the head of the first list: merge with the tail and the second list
            (l1count, l1head :: list) //Add the head of the first list
          } else {
            val (l2count, list) = merge(l1, l2tail, count) //If the head of the first list is bigger than the head of the second list: merge with the first list and the tail of the second
            (l2count + l1.length - l1tail.length, l2head :: list) //Adding to the count and the head od the second list
          }
      }

    val n = xs.length / 2 //Half of the list
    if (n == 0) (0, xs) //If the list is empty return 0 inversions
    else {
      val (l1, l2) = xs splitAt n //Splitting the list
      val (leftCount, leftList) = mSort(l1) //Doing mSort with the first part of the split list
      val (rightCount, rightList) = mSort(l2) //Doing mSort with the second part of the split list
      val (mergeCount, mergeList) = merge(leftList, rightList) //Do merge with the two list
      (leftCount + rightCount + mergeCount, mergeList) //Adding the inversions of the two lists and the merge list
    }
  }


  // ------ Problem 2  ------------------------------------------------------------------------------------------------

  /**
   * partitionFunc: Partitions a list of integers into three sub-lists (less than, equal to, greater than) using a random pivot value.
   *
   * @param list The list of integers to partition.
   * @param randomPivot The value of the random pivot.
   * @param less The list of integers less than the pivot.
   * @param equal The list of integers equal to the pivot.
   * @param greater The list of integers greater than the pivot.
   * @return A list of three lists (less, equal, greater) containing the integers from the original list classified according to their relationship with the pivot.
   */
  @tailrec
  def partitionFunc(list: List[Int], randomPivot: Int, less: List[Int], equal: List[Int], greater: List[Int]): (List[Int], List[Int], List[Int]) = {
    list match {
      case Nil => (less, equal, greater) //If the list is empty, the function returns the list of the three lists.
      case x :: xs if x < randomPivot => partitionFunc(xs, randomPivot, x :: less, equal, greater) // If the first item in the list is less than the random pivot, partitionFunc is called recursively with the rest of the list, the same partition for less
      case x :: xs if x > randomPivot => partitionFunc(xs, randomPivot, less, equal, x :: greater) // If the first item in the list is greater than the random pivot, partitionFunc is called recursively with the rest of the list, the same partition for greater
      case x :: xs => partitionFunc(xs, randomPivot, less, x :: equal, greater) //If the first item in the list is equal to the random pivot, partitionFunc is called recursively with the rest of the list, the same partition for equal
    }
  }

  /**
   * quickSortSorter: Classify the different cases with pattern matching and solve each case differently.
   *
   * @param inputList The list of integers to sort.
   * @param partitionFunc The function that partitions the list into three sub-lists (less than, equal to, greater than).
   * @return A sorted list of integers.
   */
  def quickSortSorter(inputList: List[Int], partitionFunc: (List[Int], Int, List[Int], List[Int], List[Int]) => (List[Int], List[Int], List[Int])): List[Int] = {
    inputList match {
      case Nil => Nil //If the list is empty, the function returns an empty list.
      case x :: Nil => List(x) // If the list has only one element, the function returns a list containing that element.
      case x :: xs => { //If the list has more than one element
        val randomPivot = xs(new Random().nextInt(xs.length)) //Generate a random number between 0 and the length of the list minus one. This number is used to select the random pivot from the list.
        val (lessThanPivot, equalToPivot, greaterThanPivot) = partitionFunc(inputList, randomPivot, List(), List(), List()) //Split the input list into three lists: a list with elements less than the pivot, a list with elements equal to the pivot, and a list with elements greater than the pivot.
        quickSortSorter(lessThanPivot, partitionFunc) ::: equalToPivot ::: quickSortSorter(greaterThanPivot, partitionFunc) //quickSortSorter is called recursively to sort the lessThanPivot list, the results are concatenated with the equalToPivot list, and quickSortSorter is called recursively to sort the greaterThanPivot list. The end result is the concatenation of these three ordered lists.
      }
    }
  }

  /**
   * quickSortTemporary: Call the function quickSortSorter to solve the Quicksort algorithm.
   *
   * @param inputList The list of integers to sort.
   * @return A sorted list of integers.
   */
  def quickSortTemporary(inputList: List[Int]): List[Int] = {
    quickSortSorter(inputList, partitionFunc)
  }

  /**
   * quickSortI: Sort a list of integers using the QuickSort algorithm.
   *
   * @param list The list of integers to sort.
   * @return A sorted list of integers.
   */
  override def quickSortI(list: List[Int]): List[Int] = quickSortTemporary(list)

  // ------ Problem 3  ------------------------------------------------------------------------------------------------

  /**
   * Calculate the euclidean distance between two point
   *
   * @param list is the list  that cointains the points represented by list
   * @return the euclidean distances between the points as Double
   */
  override def closestPoints(list: List[List[Double]]): Double = {

    val sortedX = list.sortBy(_.head) //list sorted using the coordinate x of the point
    val n = sortedX.length // the lenght of the list

    /**
     * Get the distance between two points using the euclidean distance
     *
     * @param p1 is the point 1 represented by a list of double
     * @param p2 is the point 2 represented by a list of double
     * @return the distances between the point 1 and point 2 as a double
     */
    def distance(p1: List[Double], p2: List[Double]): Double = //to get the distance of two point using the euclidean teorem
      val result = (p1.head - p2.head) * (p1.head - p2.head) + (p1.last - p2.last) * (p1.last - p2.last)
      root(result)

    /**
     * Recursive method to get the minimum distances of points
     *
     * @param left  the left subset of the list from which the minimum distance is to be found as an Int
     * @param right the right subset of the list from which the minimum distance is to be found as an Int
     * @return the minimum distance of the all points
     */
    def closestPointsHelper(left: Int, right: Int): Double = //recursive function where the calculation of the two closest points is performed.
      if (right - left <= 3) { //base case
        var minDistance = Double.MaxValue
        for (i <- left until right; j <- i + 1 until right) { //comparates the distances and gets the minimum
          val d = distance(sortedX(i), sortedX(j))
          if (d < minDistance) minDistance = d
        }
        (minDistance * 10000).round.toDouble / 10000 //to get 4 decimals
      } else {
        val mid = (left + right) / 2 //if there is more points, we divide the list in two to get the minimum distance
        val dl = closestPointsHelper(left, mid) // recursions
        val dr = closestPointsHelper(mid, right)
        var minDistance = min(dl, dr)

        val strip = sortedX.filter(p => abs(p.head - sortedX(mid).head) < minDistance) // the filter to get the minum distances in diferents halves
        for (i <- strip.indices; j <- i + 1 until min(i + 8, strip.length).toInt) { // last comparition to get the minimum distance, using the distances that were not discarded
          val d0 = distance(strip(i), strip(j))
          if (d0 < minDistance) minDistance = d0
        }

        (minDistance * 10000).round.toDouble / 10000 // to get 4 decimals
      }


    closestPointsHelper(0, n)
  }

  /**
   * calculate the root
   *
   * @param x Double we want to know the root
   * @return Double result
   */
  def root(x: Double) = {
    def abs(x: Double) =
      if (x > 0)
        x
      else
        -x

    def improve(estim: Double, x: Double) =
      (estim + x / estim) / 2

    def isGoodEstimation(estim: Double, x: Double) =
      abs(estim * estim - x) < 0.0001

    @tailrec
    def raizIter(estim: Double, x: Double): Double =
      if (isGoodEstimation(estim, x))
        estim
      else
        raizIter(improve(estim, x), x)

    raizIter(1, x)
  }

  override def abs(x: Double) = if (x >= 0) x else -x


  /**
   * This function returns the minimum of two given numbers.
   *
   * @param a the first number to be compared.
   * @param b the second number to be compared.
   * @return the minimum of the two given numbers as a double.
   */
  @tailrec
  def min(a: Double, b: Double): Double = {
    if (a == b) b
    else if (a < b) a
    else min(b, a)
  }

  }
