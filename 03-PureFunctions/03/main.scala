import java.time.LocalDate
import scala.annotation.tailrec

case class Item(date: LocalDate, priority: Int, title: String)
case class Node[A](value: A, children: List[Node[A]] = List.empty)

object Main {
  // 3.1
  def sumList(nums: List[Int], index: Int = 0): Int = {
    if (index == nums.size) {
      return 0
    }

    nums(index) + sumList(nums, index + 1)
  }

  // 3.2
  def calculateAverage(nums: List[Int]): Double = {
    var sum = sumList(nums)
    sum / nums.size
  }

  // 3.3
  def sortListByAlphabet(list: List[String]): List[String] = {
    if (list.length <= 1) {
      list
    } else {
      val (left, right) = list.splitAt(list.length / 2)

      val sortedLeft = sortListByAlphabet(left)
      val sortedRight = sortListByAlphabet(right)

      merge(sortedLeft, sortedRight)
    }
  }

  def merge(left: List[String], right: List[String]): List[String] = {
    (left, right) match {
      case (Nil, _) => right
      case (_, Nil) => left
      case (h1 :: t1, h2 :: t2) =>
      if ((h1 compareTo h2) <= 0) {
          h1 :: merge(t1, right)
        } else {
          h2 :: merge(left, t2)
        }
    }
  }

  // 3.4

  implicit val itemOrdering: Ordering[Item] = Ordering.fromLessThan[Item] { (item1, item2) =>
    val dateComparison = item1.date.compareTo(item2.date)

    if (dateComparison != 0) {
      dateComparison < 0
    } else {
      val priorityComparison = item1.priority.compareTo(item2.priority)
      if (priorityComparison != 0) {
        priorityComparison < 0
      } else {
        item1.title.compareTo(item2.title) < 0
      }
    }
  }

  def mergeItems(left: List[Item], right: List[Item]): List[Item] = {
    (left, right) match {
      case (Nil, _) => right
      case (_, Nil) => left
      case (h1 :: t1, h2 :: t2) =>
        if (itemOrdering.lteq(h1, h2)) { 
          h1 :: mergeItems(t1, right)
        } else {
          h2 :: mergeItems(left, t2)
        }
    }
  }

  def sortItems(list: List[Item]): List[Item] = {
    
    if (list.length <= 1) {
      list
    } else {
      val (left, right) = list.splitAt(list.length / 2)

      val sortedLeft = sortItems(left)
      val sortedRight = sortItems(right)

      mergeItems(sortedLeft, sortedRight)
    }
  }

  // 3.4
  
  def flattenTree[A](node: Node[A]): List[Node[A]] = {
    node :: node.children.flatMap(flattenTree)
  }




  def main(args:Array[String]) : Unit = {
    println(sumList(List(1, 2, 3, 4)))

    println(calculateAverage(List(1, 2, 2, 3)))

    println(sortListByAlphabet(List("banana", "apple", "orange", "abba")))

    val items = List(
      Item(LocalDate.of(2023, 1, 15), 2, "A1"),
      Item(LocalDate.of(2023, 1, 10), 1, "A2"),
      Item(LocalDate.of(2023, 1, 15), 1, "A3"),
      Item(LocalDate.of(2023, 1, 10), 1, "A4"),
      Item(LocalDate.of(2023, 1, 20), 3, "A5"),
      Item(LocalDate.of(2023, 1, 15), 2, "A6"),
      Item(LocalDate.of(2023, 1, 10), 2, "A7")
    )

    val sortedItems = sortItems(items)

    println("\nSorted List:")
    sortedItems.foreach(println)


    val leaf4 = Node("B4")
    val leaf5 = Node("B5")
    val child3 = Node("A3", List(leaf4, leaf5))
    val leaf2 = Node("B2")
    val child2 = Node("A2", List(leaf2, child3))

    val leaf1 = Node("B1")
    val child1 = Node("A1", List(leaf1))

    val root = Node("Stamm", List(child1, child2))

    val flattenedNodes = flattenTree(root)

    println("\nFlattened List:")
    flattenedNodes.foreach(node => println(node.value))
  }
}
