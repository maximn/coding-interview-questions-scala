package org.questions.fibonacci

/**
 * @author maximn
 * @since 26-Oct-2015
 */
class Recursive extends Fibonacci {
   override def nth(n: Int): Long = n match {
     case 0 | 1 => n
     case _ => nth(n-1) + nth(n-2)
   }
 }
