package org.questions.arrays

import org.specs2.matcher.Matcher
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

/**
 * @author maximn
 * @since 30-Oct-2015
 */
class TwoSumTest extends Specification {

  class Context extends Scope {
    val arrayUtils = new TwoSum

    def sumTo(sum: Int): Matcher[(Int, Int)] = (_: (Int, Int)) match {
      case (a, b) => a + b must be_===(sum)
    }
  }

  "under 2 elements in seq" should {
    "be none" in new Context {
      arrayUtils.findPairSum(Seq(1), 8) must beNone
    }
  }

  "two elements that sum" should {
    "return these elements" in new Context {
      arrayUtils.findPairSum(Seq(2, 3), 5) must beSome(sumTo(5))
    }
  }

  "two elements that doesn't sum" should {
    "return these none" in new Context {
      arrayUtils.findPairSum(Seq(2, 3), 4) must beNone
    }
  }

  "more elements that sum" should {
    "return the sum" in new Context {
      arrayUtils.findPairSum(Seq(1, 2, 3), 5) must beSome(sumTo(5))
    }
  }
}
