package org.questions.strings

import org.specs2.mutable.Specification

/**
 * @author maximn
 * @since 14-Nov-2015
 */
class WildCardMatchingTest extends Specification {
  val matcher = new WildCardMatching


  "same string" should {
    "be matching" in {
      val string = "abc"
      matcher.isMatching(string, string) must beTrue
    }
  }

  "different string" should {
    "not match" in {
      matcher.isMatching("ab", "bc") must beFalse
    }
  }

  "question mark" should {
    "allow to skip one char" in {
      matcher.isMatching("abc", "a?c") must beTrue
    }
  }

  "star" should {
    "replace many chars" in {
      matcher.isMatching("abcd", "a*d") must beTrue
    }

    "replace zero chars" in {
      matcher.isMatching("abc", "ab*c") must beTrue
    }

    "replace one char" in {
      matcher.isMatching("abc", "a*c") must beTrue
    }

    "match if star is in the end" in {
      matcher.isMatching("abc", "a*") must beTrue
    }
  }
}
