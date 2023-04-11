package Answer

trait IMethods {

  def inversions(list: List[Int]): Int

  def mSort(list: List[Int]): (Int, List[Int])

  def quickSortI(list: List[Int]): List[Int]

  def closestPoints(list: List[List[Double]]): Double

  def abs(x: Double): Double = if (x >= 0) x else -x

  def root(number: Double): Double
  
}