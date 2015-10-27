package org.questions.fill

/**
 * @author maximn
 * @since 27-Oct-2015
 */
class DrawUtils(canvas: Canvas) {
  def fill(x: Int, y: Int, color: Char): Unit = {
    if (!isInCanvas(x, y)) throw new IndexOutOfBoundsException

    val initialColor = canvas.getColor(x, y)

    canvas.setColor(x, y, color)

    Seq((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)) foreach { case (i, j) =>
      if (isInCanvas(i, j) && canvas.getColor(i, j) == initialColor) {
        fill(i, j, color)
      }
    }
  }

  private def isInCanvas(x: Int, y: Int): Boolean =
    (x >= 0) &&
    (y >= 0) &&
    (x < canvas.getSize._1) &&
    (y < canvas.getSize._2)
}