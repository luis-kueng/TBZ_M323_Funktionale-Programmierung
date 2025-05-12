object TravelPlanner {
  def createRoute(destinations:List[String]) : List[String] = {
    destinations
  }

  def addDestinationToRoute(route:List[String], destination:String, index:Int) : List[String] = {
      if (index < 0 || index > route.size) {
      throw new IndexOutOfBoundsException(s"Index $index is out of bounds for route of size ${route.size}")
    }

    val (before, after) = route.splitAt(index)
    before ::: List(destination) ::: after
  }

  def main(args:Array[String]) : Unit = {
    val initialDestinations = List("Paris", "Rome", "London")
    val myRoute = createRoute(initialDestinations)
    println(s"Initial Route: $myRoute")

    try {
      val routeWithNewYork = addDestinationToRoute(myRoute, "New York", 1)
      println(s"Route after adding New York at index 1: $routeWithNewYork")

      val routeWithTokyo = addDestinationToRoute(routeWithNewYork, "Tokyo", routeWithNewYork.size)
      println(s"Route after adding Tokyo at the end: $routeWithTokyo")

      val routeWithBerlin = addDestinationToRoute(routeWithTokyo, "Berlin", 0)
      println(s"Route after adding Berlin at the beginning: $routeWithBerlin")

    } catch {
      case e: IndexOutOfBoundsException => println(s"Error: ${e.getMessage}")
    }
  }
}
