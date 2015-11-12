You need to implement the `fill` method of a paint application.
``` Scala
  def fill(x: Int, y: Int, color: Char): Unit
```
You start in a given point (x, y) in a grid of size (m, n) and should fill the smallest closed shape surrounding.

* You have access to the canvas from withing your function.
* The coordinate (0, 0) is on the Left/Top

``` Scala
trait Canvas {
  def getColor(x: Int, y: Int): Char
  def setColor(x: Int, y: Int, color: Char)
  def getSize: (Int, Int)
}
```
