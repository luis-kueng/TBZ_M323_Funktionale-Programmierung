import scala.io.StdIn

object ShoppingCart {

  def addItem(cart: List[String], item: String): List[String] = {
    cart :+ item 
  }

  def removeItem(cart: List[String], item: String): List[String] = {
    val (before, after) = cart.span(_ != item)
    if (after.nonEmpty) before ::: after.tail else cart
  }

  def calculateDiscount(cart: List[String]): Double = {
    if (cart.contains("book")) 5.0 else 0.0
  }

  def viewCart(cart: List[String]): Unit = {
    println("\n--- Shopping Cart ---")
    if (cart.isEmpty) {
      println("Your cart is empty.")
    } else {
      cart.zipWithIndex.foreach { case (item, index) =>
        println(s"${index + 1}. $item")
      }
    }
    println("---------------------\n")
  }

  def appLoop(currentCart: List[String]): Unit = {
    println("Available commands: view, add, remove, discount, exit")
    print("> ")

    StdIn.readLine().trim.toLowerCase match {
      case "view" =>
        viewCart(currentCart)
        appLoop(currentCart)

      case "add" =>
        print("Enter item to add: ")
        val newItem = StdIn.readLine().trim
        if (newItem.nonEmpty) {
          val updatedCart = addItem(currentCart, newItem)
          println(s"Added '$newItem' to the cart.")
          viewCart(updatedCart)
          appLoop(updatedCart)
        } else {
          println("Item name cannot be empty.")
          appLoop(currentCart)
        }

      case "remove" =>
        print("Enter item to remove: ")
        val itemToRemove = StdIn.readLine().trim
        if (itemToRemove.nonEmpty) {
          val updatedCart = removeItem(currentCart, itemToRemove)
          if (updatedCart.size < currentCart.size) {
             println(s"Removed '$itemToRemove' from the cart.")
             viewCart(updatedCart)
             appLoop(updatedCart)
          } else {
             println(s"'$itemToRemove' not found in the cart.")
             viewCart(currentCart)
             appLoop(currentCart)
          }
        } else {
           println("Item name cannot be empty.")
           appLoop(currentCart)
        }


      case "discount" =>
        val discount = calculateDiscount(currentCart)
        println(s"Current discount: ${discount}%")
        appLoop(currentCart) 

      case "exit" =>
        println("Exiting application.")

      case _ =>
        println("Unknown command.")
        appLoop(currentCart)
    }
  }

  def main(args: Array[String]): Unit = {
    val initialCart: List[String] = List.empty
    appLoop(initialCart)
  }
}
