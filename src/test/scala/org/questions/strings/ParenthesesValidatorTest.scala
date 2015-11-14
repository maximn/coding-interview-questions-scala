package org.questions.strings

import org.specs2.mutable.Specification

/**
 * @author maximn
 * @since 14-Nov-2015
 */
class ParenthesesValidatorTest extends Specification {
  val validator = new ParenthesesValidator

  "empty parentheses" should {
    "be valid" in {
      validator.validate("(abc)") must beTrue
    }
  }

  "no parentheses" should {
    "be valid" in {
      validator.validate("abc") must beTrue
    }
  }

  "unclosed" should {
    "be invalid" in {
      validator.validate("((abc)") must beFalse
    }
  }

  "unopened" should {
    "be invalid" in {
      validator.validate("(abc))") must beFalse
    }

    "be invalid in beginning" in {
      validator.validate(")abc(") must beFalse
    }
  }
}
