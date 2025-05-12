object RaceTracker {

  def addRound(car:List[Int], round:Int) : List[Int] = {
    car :+ round
  }

  def calculateAverageTime(car:List[Int]) : Int = {
    if (car.size < 2) {
      0
    } else {
      val remainingRounds = car.tail

      val totalTime = remainingRounds.sum.toDouble

      val numberOfRounds = remainingRounds.size

      val averageDouble = totalTime / numberOfRounds

      averageDouble.toInt
    }
  }

  def main(args:Array[String]) : Unit = {
     var car1Times = List.empty[Int]
    println(s"Initial times for Car 1: $car1Times")
    println(s"Average time for Car 1: ${calculateAverageTime(car1Times)}") 

    car1Times = addRound(car1Times, 60) 
    println(s"Times for Car 1 after round 1: $car1Times") 
    println(s"Average time for Car 1: ${calculateAverageTime(car1Times)}") 

    car1Times = addRound(car1Times, 55)
    println(s"Times for Car 1 after round 2: $car1Times") 
    println(s"Average time for Car 1: ${calculateAverageTime(car1Times)}") 

    car1Times = addRound(car1Times, 62) 
    println(s"Times for Car 1 after round 3: $car1Times") 
    println(s"Average time for Car 1: ${calculateAverageTime(car1Times)}") 

    println("-" * 20) 

    val car2Times = List(58, 61, 59, 57, 60)
    println(s"Times for Car 2: $car2Times")
    println(s"Average time for Car 2: ${calculateAverageTime(car2Times)}")
  }
}
