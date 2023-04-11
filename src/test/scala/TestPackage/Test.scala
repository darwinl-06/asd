package TestPackage

import Answer.Methods

class Test extends munit.FunSuite {

  def list0 = List()
  def list1 = List(2, 3, 9, 2, 9)
  def list2 = List(3, 1, 4, 2)
  def list3 = List(1, 2, 3, 4, 5)
  def list4 = List(9, 8, 7, 6, 5)
  def list5 = List(1, 1, 1, 1, 1)
  def list6 = List(3,4,2,5,1,9,8,7)

  def poinst1 = List(List(1.0, 2.0), List(6.0, 8.0))
  def poinst2 = List(List(0.0, 0.0), List(4.0, 2.0))
  def poinst3 = List(List(1.0, 2.0), List(6.0, 9.0))
  def poinst4 = List(List(7.0, 4.0), List(5.0, 1.0))
  def poinst5 = List(List(7.0, -4.0), List(4.0, 0.0), List(7.0, 9.0))
  def poinst6 = List(List(-1.0, -7.0), List(2.0, 4.0), List(1.0, 7.0), List(-3.0, 9.0), List(8.0, -1.0))
  def poinst7 = List(List(7.0, -4.0), List(4.0, 0.0), List(7.0, 9.0), List(3.0, 1.0))
  def poinst8 = List(List(0.0, 0.0), List(0.0, 0.0), List(0.0, 0.0), List(0.0, 0.0))


  // ------ exercise 1 tests ------------------------------------------------------

  test("Number of inversions") {

    assert(Methods.inversions(list0) == 0) //Test with empty list
    assert(Methods.inversions(list1) == 2) //Test with disordered list
    assert(Methods.inversions(list2) == 3) //Test with disordered list
    assert(Methods.inversions(list3) == 0) //Test with ordered list
    assert(Methods.inversions(list4) == 7) //Test with unversed list
    assert(Methods.inversions(list5) == 0) //Test with list of equal numbers
    assert(Methods.inversions(list6) == 5) //Test with disordered list

  }

  // ------ exercise 2 tests ------------------------------------------------------

  test("Quick sort improve") {

    assert(Methods.quickSortI(list0) == List()) //Test with empty list
    assert(Methods.quickSortI(list1) == List(2, 2, 3, 9, 9)) //Test with list that contains 2 pairs of equal numbers
    assert(Methods.quickSortI(list2) == List(1, 2, 3, 4)) //Test with disordered list
    assert(Methods.quickSortI(list3) == List(1, 2, 3, 4, 5)) //Test with ordered list
    assert(Methods.quickSortI(list4) == List(5, 6, 7, 8, 9)) //Test with unversed list
    assert(Methods.quickSortI(list5) == List(1, 1, 1, 1, 1)) //Test with list of equal numbers
    assert(Methods.quickSortI(list6) == List(1, 2, 3, 4, 5, 7, 8, 9)) //Test with disordered list


  }

  // ------ exercise 3 tests ------------------------------------------------------

  test("Closest point") {

    assert(Methods.closestPoints(poinst1) == 7.8103)//test with base cases
    assert(Methods.closestPoints(poinst2) == 4.4721)
    assert(Methods.closestPoints(poinst3) == 8.6023)
    assert(Methods.closestPoints(poinst4) == 3.6056)
    assert(Methods.closestPoints(poinst5) == 5.0)//test with negative points
    assert(Methods.closestPoints(poinst6) == 3.1623)//test with much point
    assert(Methods.closestPoints(poinst7) == 1.4142)//test with much points and negative points
    assert(Methods.closestPoints(poinst8) == 0.0078)//test with same points

  }
}
