import scala.collection.mutable

class Extensions {
  def PrettyPrintMap(dict: mutable.Map[String, Int]): String = {
    val result = ""

    if (dict != null) {
      dict foreach(pair => {
        println(pair._1 + "-->" + pair._2)
      })
    }

    result
  }

}
