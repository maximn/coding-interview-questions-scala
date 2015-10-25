package org.questions.fibonacci

import scala.annotation.tailrec

/**
 * @author maximn
 * @since 26-Oct-2015
 */
class TailRecursion extends Fibonacci {
  override def nth(n: Int): Long = {
    @tailrec
    def inner(n: Int, current: Int, temp: Int): Int = n match {
      case 0 => current
      case _ => inner(n - 1, temp, current + temp)
    }

    inner(n, 0, 1)
  }
}
