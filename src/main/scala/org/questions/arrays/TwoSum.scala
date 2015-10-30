package org.questions.arrays

import scala.annotation.tailrec
import scala.collection.immutable.HashSet

/**
 * @author maximn
 * @since 30-Oct-2015
 */
class TwoSum {
  def findPairSum(seq: Seq[Int], sum: Int): Option[(Int, Int)] = {

    @tailrec
    def inner(seq: Seq[Int], hash: HashSet[Int]): Option[(Int, Int)] = seq match {
      case Nil => None
      case head :: tail =>
        val lookingFor = sum - head
        if (hash.contains(lookingFor))
          Some(head -> lookingFor)
        else inner(tail, hash + head)
    }

    inner(seq, HashSet.empty[Int])
  }
}