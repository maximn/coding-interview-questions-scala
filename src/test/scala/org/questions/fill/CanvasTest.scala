package org.questions.fill

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

/**
 * @author maximn
 * @since 27-Oct-2015
 */
class CanvasTest extends Specification {

  class Context extends Scope {
    private val sample =
      """............
        |.*******....
        |.*....***...
        |.**.....*...
        |..*....**...
        |...*****....""".stripMargin

    private def toCharsCanvas(s: String) =
      new CharsCanvas(s.split("\n").map(_.toCharArray))

    val canvas = toCharsCanvas(sample)
    val drawUtils = new DrawUtils(canvas)

    def >(canvas: Canvas) = {
      val (rows, cols) = canvas.getSize

      for {r <- 0 until rows} {
        for {c <- 0 until cols} {
          Predef.print(canvas.getColor(r, c))
        }
        println()
      }
    }
  }

  Seq((1, 100), (100, 1), (-1, 1), (1, -1)) foreach { case (x, y) =>
    "outside of the canvas" should {
      "result in error" in new Context {
        drawUtils.fill(x, y, 'X') must throwA[IndexOutOfBoundsException]
      }
    }
  }

  "adjacent fields with same color" should {
    "be filled" in new Context {
      drawUtils.fill(3, 4, '#')

      Seq((3, 5), (3, 3), (2, 4), (4, 4)) foreach { case (x, y) =>
        canvas.getColor(x, y) must be_===('#')
      }
    }
  }

  "adjacent fields with different color" should {
    "stay with previous color" in new Context {
      drawUtils.fill(0, 1, '#')
      canvas.getColor(1, 1) must be_===('*')
    }
  }

  "selected field" should {
    "be colored" in new Context {
      drawUtils.fill(0, 0, '#')
      canvas.getColor(0, 0) must be_===('#')
    }
  }

  "far fields that in same shape" should {
    "be colored" in new Context {
      drawUtils.fill(0, 0, '#')
      canvas.getColor(5, 11) must be_===('#')
    }
  }
}