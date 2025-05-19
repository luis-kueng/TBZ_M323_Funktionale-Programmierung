import scala.util.Random
import scala.collection.mutable.ListBuffer

object Main {

  // 1.1
  def addToCart(cartItems: ListBuffer[String], item: String): ListBuffer[String] = {
    var cartItemsCopy = cartItems
    cartItemsCopy += item
    cartItemsCopy
  }

  // 1.3
  // Funktionalität nicht gleich, da bei einem leeren String jetzt einfach
  // ein Space zurückgegeben wird
  def firstCharacter(str: String): Char = {
    if (str.size > 0) {
      str.head
    } else {
      return ' '
    }
  }

  // 1.4
  // Funktionalität nicht gleich, da der randomValue bereits mitgegeben werden
  // muss
  def multiplyWithRandom(number: Double, randomValue: Double): Double = {
    number * randomValue
  }

  // 1.5
  // Funktionalität nicht gleich, da bei einer 0 Division einfach 0
  // zurückgegeben wird
  def divideNumbers(dividend: Double, divisor: Double): Double = {
    if (divisor == 0) {
      return 0
    }

    dividend / divisor
  }

  // 1.6
  // Nicht pure umsetzbar, da println immer den Console Buffer verändern wird.

  def main(args:Array[String]) : Unit = {
    var cartItems = ListBuffer[String]()
    cartItems = addToCart(cartItems, "Apple")
    println(cartItems.toList)

    println(firstCharacter("Scala"))

    var randomValue = Random.nextDouble()
    println(multiplyWithRandom(5, randomValue))

    println(divideNumbers(10.0, 2.0))

    println("Hello")
  }
}
