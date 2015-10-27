package org.questions.fibonacci

import scala.annotation.tailrec

/**
 * @author maximn
 * @since 26-Oct-2015
 */
class TailRecursion extends Fibonacci {
  override def nth(n: Int): Long = {
    @tailrec
    def loop(n: Int, current: Int, temp: Int): Int = n match {
      case 0 => current
      case _ => loop(n - 1, temp, current + temp)
    }
    require(n >= 0)
    loop(n, 0, 1)
  }

}
