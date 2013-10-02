package retranslit

import scala.collection.immutable.HashMap

trait Standard[From, To] {
  val charset: Map[String, String]
  def get(ch: String) = charset.get(ch)
}

object Standards {
  implicit val RusEng = new Standard[Russian, English] {
    private val basic = HashMap("а" -> "a",  "б" -> "b",  "в" -> "v",   "г" -> "g",  "д" -> "d",  "е" -> "e",
      "ё" -> "jo", "ж" -> "zh", "з" -> "z",   "и" -> "i",  "й" -> "jj", "к" -> "k", "л" -> "l",  "м" -> "m",
      "н" -> "n",   "о" -> "o",  "п" -> "p",  "р" -> "r", "с" -> "s",  "т" -> "t",  "у" -> "u",   "ф" -> "f",
      "х" -> "kh", "ц" -> "c", "ч" -> "ch", "ш" -> "sh", "щ" -> "shh", "ъ" -> "\"", "ы" -> "y",  "ь" -> "'",
      "э" -> "eh", "ю" -> "ju", "я" -> "ja"
    )
    val charset: Map[String, String] = basic ++ basic.map {
      case (k, v) => k.capitalize -> v.capitalize
    } ++ Map("ь" -> "'", "Ь" -> "''", "ъ" -> "\"", "Ъ" -> "\"\"")
  }
}
