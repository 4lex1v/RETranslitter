package retranslit

trait Translitter[From, To] {
  val standard: Standard[From, To]
  def apply(str: String): String
}

case class TransliterationException(msg: String) extends Throwable(msg)

object Translitter {
  implicit class TranslitSwitcher[A, B](trans: Translitter[A, B]) {
    def switch = new Translitter[B, A] with Converter {
      val standard = new Standard[B, A] {
        val charset = trans.standard.charset map {
          case (k, v) => v -> k
        }
      }
    }
  }

  implicit val ret = new Translitter[Russian, English] with Converter {
    val standard = Standards.RusEng
  }

  implicit val ert = ret.switch
}

class PhraseTranslator(str: String) {
  def translit[T <: Translitter[_, _]](implicit translitter: T) =
    str.split(" ").map(translitter(_)).mkString(" ")
}