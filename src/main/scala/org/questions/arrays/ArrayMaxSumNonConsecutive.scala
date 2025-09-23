package org.questions.arrays

import scala.annotation.tailrec

/**
 * Find the highest sum of non-consecutive numbers in an array.
 *
 * This algorithm assumes all numbers are non-negative (>= 0).
 * With negative numbers, the problem becomes more complex as the optimal
 * strategy may involve skipping multiple consecutive negative values.
 *
 * @author
 *   maximn
 * @since 28-Oct-2015
 */
trait ArrayMaxSumNonConsecutive {
  def maxSum(numbers: Seq[Int]): Int
}

class Recursive extends ArrayMaxSumNonConsecutive {
  def maxSum(numbers: Seq[Int]): Int = numbers match {
    case Nil       => 0
    case Seq(n)    => n
    case Seq(a, b) => Math.max(a, b)
    case head :: tail =>
      val currentAndSkipOne = head + maxSum(tail.tail)
      val skipCurrent       = maxSum(tail)
      Math.max(currentAndSkipOne, skipCurrent)
  }
}

class DynamicProgramming extends ArrayMaxSumNonConsecutive {
  override def maxSum(numbers: Seq[Int]): Int = {
    if (numbers.isEmpty) return 0

    var inclusive = numbers.head
    var exclusive = 0

    for (i <- 1 until numbers.length) {
      val newInclusive = exclusive + numbers(i)
      val newExclusive = inclusive
      inclusive = newInclusive
      exclusive = newExclusive
    }

    math.max(exclusive, inclusive)
  }
}

class DynamicProgrammingImmutable extends ArrayMaxSumNonConsecutive {
  override def maxSum(numbers: Seq[Int]): Int = {
    @tailrec
    def inner(numbers: Seq[Int], inclusive: Int, exclusive: Int): Int = numbers match {
      case Nil          => math.max(inclusive, exclusive)
      case head :: tail => inner(numbers.tail, numbers.head + exclusive, inclusive)
    }

    if (numbers.nonEmpty)
      inner(numbers.tail, numbers.head, 0)
    else
      0
  }
}
