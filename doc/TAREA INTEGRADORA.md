# TAREA INTEGRADORA

# TAREA INTEGRADORA

## Problem 1:

---

## Merge algorithm correction:

### Base case:

The base case of the **`merge`** function is when one of the two input lists is empty. In this case, the function returns a tuple **`(count, l)`** where **`l`** is the non-empty list and **`count`** is the number of inversions that occur when merging the two lists.

If the first list is empty, then the function simply returns the second list and there are no inversions. If the second list is empty, then the function simply returns the first list and there are no inversions.

### Inductive hypothesis:

Suppose the **`merge`** function works correctly for any pair of length **`n`** lists. That is, for any pair of lists **`l1`** and **`l2`** of length **`n`**, the function returns a tuple **`(count, mergedList)`** such that **`mergedList`** contains the same elements as the concatenation of **`l1`** and **`l2`**, but sorted in ascending order, and **`count`** is the number of inversions in the concatenation of **`l1`** and **`l2`**.

We want to prove that the **`merge`** function also works correctly for any pair of length **`n+1`** lists. To do this, we take any pair of length **`n+1`** lists **`l1`** and **`l2`** and apply the **`merge`** function to them.

### Inductive step:

First, we extract the first element **`h1`** from **`l1`** and the first element **`h2`** from **`l2`**. We then compare **`h1`** and **`h2`**. If **`h1`** is less than or equal to **`h2`**, then the first element of the resulting sorted list is **`h1`** and we can recursively apply the **`merge`** function to the list **`l1`** without its first element and the complete list **`l2`**. Otherwise, the first element of the resulting sorted list is **`h2`** and we can recursively apply the **`merge`** function to the complete list **`l1`** and the list **`l2`** without its first element.

According to the inductive hypothesis, applying the algorithm to each pair of sub-lists returns a tuple **`(count1, sortedList1)`** and **`(count2, sortedList2)`**, respectively. The list **`sortedList1`** contains the same elements as the first sub-list of the first input list, and the list **`sortedList2`** contains the same elements as the second sub-list of the second input list. Both lists are sorted in ascending order and **`count1`** and **`count2`** are the numbers of inversions in the corresponding sub-lists.

It is easy to verify that the resulting list is sorted, since the first element of the list is the smaller between **`l1head`** and **`l2head`**, and the remaining elements of the list are the result of the recursive call with the rest of the lists. We can also verify that the counted number of inversions is correct using the inductive hypothesis. The counted number of inversions is **`l2count + l1.length - l1tail.length`** since **`l2head`** is greater than the remaining elements of **`l1`**, and the remaining elements of **`l2`** are greater than **`l2head`**. Additionally, the counter of the recursive call with the remaining elements of **`l2`** is **`l2count`**.

Therefore, the **`merge`** function is correct for any pair of lists **`l1`** and **`l2`**.

## **Time complexity:**

The Merge Sort algorithm is a classic example of an algorithm that uses the divide and conquer principle. If the list that is given has more than two elements, it is divided into two halves, the algorithm is recursively invoked, and then the two ordered halves are merged.

The time complexity of the Merge Sort algorithm is defined by the following recurrence:

*T*(*n*) = 1 *n* < 1

*T*(*n*) = 2*T*(*n*/2) + *Θ*(*merge*) *n* > 1

Where the first part of the equation term represents the execution time of the two recursive calls, and the second part represents the execution time of comparisons and assignments.

We can calculate the time complexity of the **`merge`** function by assuming that the length of the lists **`l1`** and **`l2`** is **`n`**. In each recursive call, the length of one of the lists is reduced by 1. Therefore, the total number of recursive calls is **`n`**. Hence, the recurrence relation is as follows:

*T*(*n*) = 2*T*(*n*/2) + *Θ*(*n*) *n* > 1

With the master method, we have that the time complexity of the **`merge`** algorithm is given by:

*T*(*n*) = *aT*(*n*/*b*) + *f*(*n*)

*a* = 2, *b* = 2, *f*(*n*) = *Θ*(*n*)

Considering the three cases of the master method seen in class, we apply the second one in which we have to:

*T*(*n*) = *Θ*(*n*log*ba*lg *n*) *ε* > 0

Si *f*(*n*) = *Θ*(*n*log*ba*)

We replace the values we have:

*f*(*n*) = *Θ*(*n*log22)

lg22 = 1

*f*(*n*) = *Θ*(*n*)

Therefore, the time complexity of the algorithm is given by:

*T*(*n*) = *Θ*(*n*log22lg *n*)

lg22 = 1

*T*(*n*) = *Θ*(*n*log *n*)

## Problem 2:

---

## Improved Quicksort Algorithm

### **Base case:**

The base case of the **`quickSort`** function occurs when the input list **`inputList`** is empty (**`Nil`**). In this case, the function returns an empty list, which means there are no elements to sort in the input list.

### **Inductive hypothesis:**

We assume correctness about the **`quickSort`** function for a list of size **`n`**. In other words, we assume that given a list of **`n`** elements, the **`quickSort`** function correctly sorts the elements of the list in ascending order. If we can demonstrate that the function is correct for the base case (an empty list) and that, based on the inductive hypothesis, we can show that the function is correct for any list of size **`n+1`**, then we can conclude that the function is correct for any list of any size.

### **Inductive step:**

In the inductive step of the **`quickSort`** function, we assume that the function is correct for a list of size **`n`** and we must demonstrate that it is also correct for a list of size **`n+1`**. To do this, we consider a list **`inputList`** of size **`n+1`**, and we focus on the first element of the list, **`x`**.

Then, using the **`partition function`**function, we divide **`inputList`** into three sub-lists: **`less Than Pivot`** containing elements less than a randomly selected pivot , **`equal To Pivot`** containing elements equal to**`Pivot`**, and **`greater Than Pivot`** containing elements greater than **`Pivot`**. Since **`x`** is one of the elements of **`inputList`**, there are three possible cases to consider:

1. If **`x`** is less than **`Pivot`**, then **`x`** must be in the **`less Than Pivot`** sub-list.
2. If **`x`** is equal to **`Pivot`**, then **`x`** must be in the **`equal To Pivot`** sub-list.
3. If **`x`** is greater than **`Pivot`**, then **`x`** must be in the **`greater Than Pivot`** sub-list.

Then, we can apply the inductive hypothesis to each of the **`less Than Pivot`** and **`greater Than Pivot`** sub-lists, since we know that the **`quickSort`** function is correct for lists of size **`n`**. Finally, we concatenate the three sorted sub-lists using the **`:::`** operator and return the resulting sorted list. In this way, we demonstrate that the **`quickSort`** function is correct for any list of size **`n+1`**.

### Time complexity:

The recurrence relation for the modified algorithm is:

T(n) = 3T(n/3) + O(n)

Where T(n) is the execution time of the algorithm for a list of length n.

By using the Master theorem to solve the recurrence equation, we can determine that the time complexity of the algorithm is Θ(n log n), since the "partition" function runs in O(n) and the recurrence relation has the form T(n) = a*T(n/b) + f(n), with a = 3, b = 3, and f(n) = n. Since logb(a) = log3(3) = 1, the time complexity of the algorithm is Θ(n log n) according to case 2 of the Master theorem resolution method.

Therefore, the complexity of the modified algorithm is Θ(n log n), which means that its execution time increases logarithmically with the input size.

## Problem 3:

---

## Root Method:

### Base case:

If x = 0, then the square root of x is 0. This is satisfied since 1 is the initial value of the estimate and the improvement method cannot affect the estimate if the number is 0.

### Inductive hypothesis:

Assume that the root function works correctly for all input values from 0 to n, where n is a positive number.

### Inductive step:

To show that the root function also works for n + 1, we need to show that the function works correctly for x = n + 1.

Since the initial value of the estimate is 1, we can assume that the function starts with an estimate of 1. Then, the function improves the estimate using the improvement method until a good estimate is reached.

The improvement method used is (estim + x / estim) / 2, which is valid for any value of x, including x = n + 1. Then, the function checks whether the current estimate is a good estimate using the isGoodEstimation function.

In general, since the root function works correctly for x = 0 and we assume that it works for all input values from 0 to n, we can conclude that the function also works for x = n + 1. Therefore, the root function is correct for any positive number x.

## Time complexity:

To find the time complexity of the closestPoints method, we must first identify the relevant parameters that affect the time complexity of the algorithm. In this case, we can see that the algorithm is divided into two main parts: the sorting and ordering of the list, and the search for the minimum distance between points.

The first part of the algorithm, the sorting and ordering of the list, is performed by the *`sortBy`* method which has a complexity of *`O(n log n)`, where `n`* is the number of elements in the list.

The second part of the algorithm, the search for the minimum distance between the points, is performed by the recursive function *`closestPointsHelper`. This function has a complexity of `T(n) = 2T(n/2) + O(n)`, where `n` is the number of elements in the list. The complexity `O(n)`* is due to the loop used to compare the distances between the points in the base part of the algorithm.

Considering the three cases of master method seen in class which are:

- If log(b) < a, then T(n) = O(n^a).
- If log(b) = a, then T(n) = O(n^a * log(n)).
- If log(b) > a, then T(n) = O(n^log(b)).

and we have that:

T(n) = aT(n/b) + f(n).

a = 2, b = 2, f(n) = Θ(n).

Therefore, the time complexity of *`closestPointsHelper`*
is:

T(n) = Θ(n*log *n).

Taking into account that *`closestPoints`calls `closestPointsHelper`*
with an initial problem size of n, the time complexity of *`closestPoints`* is also Θ(n*log *n).
is also Θ(n*log *n).