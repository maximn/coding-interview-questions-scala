package org.questions.arrays

import org.specs2.mutable.Specification


/**
 * @author maximn
 * @since 28-Oct-2015
 */
trait ArrayMaxSumNonConsecutiveTest extends Specification {

  val accumulator: ArrayMaxSumNonConsecutive

  "maxSum" should {
    "be 0 for empty seq" in {
      accumulator.maxSum(Nil) must be_===(0)
    }

    "be the single number for a single item seq" in {
      accumulator.maxSum(Seq(1)) must be_===(1)
    }

    "be the Max of 2 items" in {
      accumulator.maxSum(Seq(1, 2)) must be_===(2)
    }

    "be the Max Sum of non consecutive numbers" in {
      accumulator.maxSum(Seq(1, 2, 3, 4, 5)) must be_===(9)
    }
  }
}

class RecursiveTest extends ArrayMaxSumNonConsecutiveTest {
  override val accumulator = new Recursive
}

class DynamicProgrammingTest extends ArrayMaxSumNonConsecutiveTest {
  override val accumulator = new DynamicProgramming
}

class DynamicProgrammingImmutableTest extends ArrayMaxSumNonConsecutiveTest {
  override val accumulator = new DynamicProgrammingImmutable
}