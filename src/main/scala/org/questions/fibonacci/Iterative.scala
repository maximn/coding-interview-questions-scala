package org.questions.fibonacci

/**
 * @author maximn
 * @since 26-Oct-2015
 */
class Iterative extends Fibonacci {
   override def nth(n: Int): Long = {
     require(n >= 0)

     var current = 0
     var last = 1

     for (i <- 0 until n) {
       val temp = current
       current = last
       last = current + temp
     }

     current
   }
 }