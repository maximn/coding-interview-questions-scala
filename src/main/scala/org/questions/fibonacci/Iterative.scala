package org.questions.fibonacci

import scala.annotation.tailrec

/**
 * @author maximn
 * @since 26-Oct-2015
 */
class Iterative extends Fibonacci {
   override def nth(n: Int): Long = {
     var current = 0
     var temp = 1

     for (i <- 0 until n) {
       current = temp
       temp = current + temp
     }

     current
   }
 }