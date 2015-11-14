package org.questions.strings

/**
 * @author maximn
 * @since 14-Nov-2015
 */
class WildCardMatching {
  private val matchOnce = '?'
  private val matchZeroOrMany = '*'

  def isMatching(str: String, pattern: String): Boolean =
    isMatchingSeq(str.toList, pattern.toList)

  private def isMatchingSeq(str: Seq[Char], pattern: Seq[Char]): Boolean = {
    (str, pattern) match {
      case (Nil, Nil) => true
      case (sHead :: sTail, pHead :: pTail) if sHead == pHead || pHead == matchOnce =>
        isMatchingSeq(sTail, pTail)
      case (_ :: sTail, pHead :: pTail) if pHead == matchZeroOrMany =>
        isMatchingSeq(sTail, pTail) || isMatchingSeq(sTail, pattern) || isMatchingSeq(str, pTail)
      case _ => false
    }
  }
}
