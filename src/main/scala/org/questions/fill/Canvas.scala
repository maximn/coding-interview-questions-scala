package org.questions.fill

/**
 * @author maximn
 * @since 27-Oct-2015
 */
trait Canvas {
  def getColor(x: Int, y: Int): Char

  def setColor(x: Int, y: Int, color: Char)

  def getSize: (Int, Int)
}


class CharsCanvas(canvas: Array[Array[Char]] = Array.fill[Char](5, 5)('.')) extends Canvas {
  require(canvas.length > 0)
  require(canvas.head.length > 0)

  override def getColor(x: Int, y: Int): Char = canvas(y)(x)

  override def setColor(x: Int, y: Int, color: Char): Unit = canvas(y)(x) = color

  override def getSize: (Int, Int) = (canvas.head.length, canvas.length)

  def print() = {
    canvas foreach { row => {
      row.foreach(Predef.print)
      println()
    }}
  }
}