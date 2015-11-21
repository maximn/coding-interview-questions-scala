package org.questions.fill

/**
 * @author maximn
 * @since 27-Oct-2015
 */
class DrawUtils(canvas: Canvas) {
  def fill(x: Int, y: Int, color: Char): Unit = {
    if (!isInCanvas(x, y)) throw new IndexOutOfBoundsException

    val initialColor = canvas.getColor(x, y)

    fillInternal(x, y, color, initialColor)
  }

  private def fillInternal(x: Int, y: Int, newColor: Char, initialColor: Char): Unit = {
    def shouldColor = canvas.getColor(x, y) == initialColor
    if (isInCanvas(x, y) && shouldColor) {
      canvas.setColor(x, y, newColor)

      Seq((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)) foreach { case (i, j) =>
        fillInternal(i, j, newColor, initialColor)
      }
    }
  }

  private def isInCanvas(x: Int, y: Int): Boolean =
    (x >= 0) &&
      (y >= 0) &&
      (x < canvas.getSize._1) &&
      (y < canvas.getSize._2)
}