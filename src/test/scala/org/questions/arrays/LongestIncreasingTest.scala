package org.questions.arrays

import org.specs2.mutable.Specification

/**
 * @author maximn
 * @since 30-Oct-2015
 */
trait LongestIncreasingTest extends Specification {
  val finder: LongestIncreasing

  "empty seq" should {
    "throw argument exception" in {
      finder.findLongestIncreasing(Nil) must throwA[IllegalArgumentException]
    }
  }

  "single item" should {
    "return a seq with that item" in {
      finder.findLongestIncreasing(Seq(1)) must be_===(Seq(1))
    }
  }

  "all increasing seq" should {
    "return the seq" in {
      finder.findLongestIncreasing(Seq(1, 2, 3, 4)) must be_===(Seq(1, 2, 3, 4))
    }
  }

  "increasing starts not in the beginning" should {
    "return the increasing seq" in {
      finder.findLongestIncreasing(Seq(8, 1, 2, 3)) must be_===(Seq(1, 2, 3))
    }
  }

  "findLongestIncreasing" should {
    "return the longest increasing seq" in {
      finder.findLongestIncreasing(Seq(1, 2, 0, 0, 3, 0, 4, 5, 6, 5, 2, 3)) must be_===(Seq(0, 4, 5, 6))
    }
  }
}

class LongestIncreasingRecursiveTest extends LongestIncreasingTest {
  override val finder = new LongestIncreasingRecursive
}

class LongestIncreasingIterativeTest extends LongestIncreasingTest {
  override val finder = new LongestIncreasingIterative
}
