object TipCalculator {
  
  def addPerson(names:List[String], name:String) : List[String] = {
    names :+ name
  }

  def calculateTipPercentage(names:List[String]) : Int = {
    if (names.size > 5) {
      return 20
    } else if (names.size > 0) {
      return 10
    }

    return 0
  }

  def printGroup(names:List[String]) : Unit = {
    println("\n--- Group ---")
    if (names.isEmpty) {
      println("0 People")
    } else {
      names.zipWithIndex.foreach { case (item, index) =>
        println(s"${index + 1}. $item")
      }
    }
    println("---------------------\n")
  }

  def main(args:Array[String]) : Unit = {
    var names:List[String] = List.empty
    var percentage = calculateTipPercentage(names)
    printGroup(names)
    println("Tip: " + percentage + "%")

    
    names = addPerson(names, "p1")
    percentage = calculateTipPercentage(names)
    printGroup(names)
    println("Tip: " + percentage + "%")


    names = addPerson(names, "p2")
    names = addPerson(names, "p3")
    names = addPerson(names, "p4")
    names = addPerson(names, "p5")
    names = addPerson(names, "p6")
    percentage = calculateTipPercentage(names)
    printGroup(names)
    println("Tip: " + percentage + "%")
  }
}
