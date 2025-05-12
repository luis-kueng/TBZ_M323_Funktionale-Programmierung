object WordPoints {
  def countPointsForWord(word:String) : Int = {
    var score:Int = 0

    for (c <- word.toLowerCase) {
      if (c != 'a') {
        score = score + 1
      }
    }

    return score
  }

  def sortWordsByScore(words:List[String]) : List[String] = {
    return words.sortBy(countPointsForWord)
  }

  def main(args:Array[String]) : Unit = {
    val word1 = "banana"
    val score1 = countPointsForWord(word1)
    println(s"The word '$word1' has a score of: $score1")

    val word2 = "apple"
    val score2 = countPointsForWord(word2)
    println(s"The word '$word2' has a score of: $score2")

    val word3 = "aaaaa"
    val score3 = countPointsForWord(word3)
    println(s"The word '$word3' has a score of: $score3")

    val word4 = "AbAcA"
    val score4 = countPointsForWord(word4)
    println(s"The word '$word4' has a score of: $score4")

    println("-" * 20)

    val wordList = List("zebra", "apple", "banana", "cat", "aaaaa", "dogma")
    println(s"Original List of Words: $wordList")

    val sortedWordList = sortWordsByScore(wordList)
    println(s"Sorted List by Score: $sortedWordList")

    println("-" * 20)

    val anotherList = List(" Scala ", "Java", "Python", "C++", "Rust")
    println(s"Original List: $anotherList")
    val sortedAnotherList = sortWordsByScore(anotherList)
    println(s"Sorted List by Score: $sortedAnotherList")
  }
}
