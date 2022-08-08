import java.io.FileNotFoundException
import scala.io.{BufferedSource, Source}

class FileProcessor {
  val _uniquenessHelper = new UniquenessHelper()
  val _extensions = new Extensions()

  def CalcWordOccurrencesInFile(path: String): String = {
    val str =  GetFileAsString(path)

    val occ = _uniquenessHelper.CalcOccurencesSafe(str)
    _extensions.PrettyPrintMap(occ)
  }

  private[this] def GetFileAsString(path: String): String = {
    val builder = new StringBuilder()
    var bufferedSource: BufferedSource = null;
    try {
      bufferedSource = Source.fromFile (path)

      for (line <- bufferedSource.getLines () ) {
        builder ++= line + '\n'
      }
    } catch {
      case e: FileNotFoundException => println ("Error occurred while reading the file " + e.toString () )
      case e: Exception => println ("Unexpected error while reading the file" + e.toString () )
    } finally {
      if (bufferedSource != null) {
        bufferedSource.close
      }
    }

    builder.toString()
  }
}
