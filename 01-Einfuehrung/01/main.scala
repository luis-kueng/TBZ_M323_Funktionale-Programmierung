oRandombject Main
{
  def main(args:Array[String]): Unit =
    println("Imperative: " + calculateScore("imperative"))
    println("Declarative: " + wordScore("imperative"))


  def calculateScore(word:String) : Int = {
    var score:Int = 0

    for (c <- word) {
      if (c != 'a') {
        score = score + 1
      }
    }

    return score
  }

  def wordScore(word:String) : Int = {
    return word.replace("a", "").size
  }
}
