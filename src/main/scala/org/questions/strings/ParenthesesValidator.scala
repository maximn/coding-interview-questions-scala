package org.questions.strings

/**
 * @author maximn
 * @since 14-Nov-2015
 */
class ParenthesesValidator {
  def validate(str: String): Boolean =
    validateCharSeq(str.toList, 0)

  private def validateCharSeq(str: Seq[Char], count: Int): Boolean =
    if (count < 0) {
      false
    }
    else str match {
      case Nil => count == 0
      case head :: tail if head == '(' => validateCharSeq(tail, count + 1)
      case head :: tail if head == ')' => validateCharSeq(tail, count - 1)
      case _ :: tail => validateCharSeq(tail, count)
    }
}
