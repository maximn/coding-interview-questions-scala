package org.questions.arrays

import scala.annotation.tailrec

/**
 * @author maximn
 * @since 30-Oct-2015
 */
trait LongestIncreasing {
  def findLongestIncreasing(seq: Seq[Int]): Seq[Int]
}

class LongestIncreasingRecursive extends LongestIncreasing {
  override def findLongestIncreasing(seq: Seq[Int]): Seq[Int] = {
    require(seq.nonEmpty)

    findLongestIncreasingInternal(seq)
  }

  private def findLongestIncreasingInternal(seq: Seq[Int]): Seq[Int] = seq match {
    case Nil => Nil
    case _ =>
      val firstIncreasing = increasingSeq(seq)
      val otherIncreasing = findLongestIncreasingInternal(seq.drop(firstIncreasing.length))

      Seq(firstIncreasing, otherIncreasing).maxBy(_.length)
  }

  @tailrec
  private def increasingSeq(seq: Seq[Int], res: Seq[Int] = Nil): Seq[Int] = seq match {
    case head :: (tail@Seq(next, _*)) =>
      if (head < next) increasingSeq(tail, res :+ head)
      else res :+ head
    case Seq(single) => res :+ single
    case _ => res
  }
}

class LongestIncreasingIterative extends LongestIncreasing {
  def findLongestIncreasing(seq: Seq[Int]): Seq[Int] = {
    require(seq.nonEmpty)

    var localLongest = Seq[Int](seq.head)
    var globalLongest = Seq[Int]()
    def setGlobalFromLonger(): Unit = {
      globalLongest = Seq(localLongest, globalLongest).maxBy(_.length)
    }

    for (i <- seq.indices.drop(1)) {
      val prev = seq(i - 1)
      val current = seq(i)

      if (prev < current) {
        localLongest = localLongest :+ current
      }
      else {
        setGlobalFromLonger()
        localLongest = Seq(current)
      }
    }

    setGlobalFromLonger()

    globalLongest
  }
}
