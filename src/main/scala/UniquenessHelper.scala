import scala.collection.mutable

class UniquenessHelper {
  private[this] val _delimiters = Array(' ',
    ','
    , ';'
    , '.'
    , '!'
    , '?'
    , '\n'
    , '\r'
    , '-'
    , '\u2012'
    , '\u2013'
    , '\u2014'
    , '\u2015'
    , '\u002d'
    , '\u058a'
    , '\u05be'
    , '\u1400'
    , '\u1806'
    , '\u2010'
    , '\u2011'
    , '\u2012'
    , '\u2013'
    , '\u2014'
    , '\u2015'
    , '\ufe58'
    , '\ufe63'
    , '\uff0d'
    , '<'
    , '>'
    , '?'
    , '«'
    , '»'
    , ':')

  private[this] def isNullOrEmpty[T](s: Seq[T]) = s match {
    case null => true
    case Seq() => true
    case _ => false
  }

  def CalcOccurencesSafe(input: String): mutable.Map[String, Int] = {
    if (isNullOrEmpty(input)) {
      print("Input is incorrect")
      scala.collection.mutable.Map[String, String]()
    }
    val words = input.toLowerCase().split(_delimiters).filter(el => el.trim().length() > 0)

    if (words.length < 1) {
      scala.collection.mutable.Map[String, String]()
    }

    CalcOccurences(words)
  }

  private[this] def CalcOccurences(words: Array[String]): mutable.Map[String, Int] = {
    val occurrences = scala.collection.mutable.Map[String, Int]()

     words foreach {
      item =>
        if (occurrences.contains(item)) {
          occurrences(item) = occurrences(item) + 1
        } else {
          occurrences(item) = 1
        }
    }

    occurrences
  }
}
