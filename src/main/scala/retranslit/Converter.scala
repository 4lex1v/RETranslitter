package retranslit

trait Converter {
  this: Translitter[_, _] =>

  def isSpecial(ch: Char): Boolean =
    (ch != '\'' && ch != '#') &&
    (ch < 65 || (ch > 90 && ch < 97) || (ch > 122 && ch < 127))

  def apply(word: String): String = {
    val result = word.foldLeft(("", "", "")) {
      case ((res, nextLetter, orig), cur) =>
        if (isSpecial(cur)) (res + nextLetter + cur, "", "")
        else {
          val letter = cur.toString
          val single = standard.get(letter)
          val multiple = standard.get(orig + letter)
          (single, multiple) match {
            case (_, Some(l)) =>
              (res, l, orig + letter)
            case (Some(l), None) =>
              (res + nextLetter, l, letter)
            case (None, None) =>
              (res + nextLetter, "", letter)
          }
        }
    }
    result._1 + result._2
  }
}