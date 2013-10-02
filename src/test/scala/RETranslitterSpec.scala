package retranslit

import org.scalatest._

class RETranslitterSpec extends WordSpec with Matchers {
  "RETranslitter" should {
    val russian = ('а' to 'я').toList.map(_.toString)

    "have a default standard for all russian alphabet" in {
      val standard = Standards.RusEng.charset
      russian foreach { letter =>
        standard should contain key letter
      }
    }

    "correctly translit russian alphabet with latin charset" in {
      russian map { letter =>
        val latin = letter.translit[Russian >> English]
        val char: String = Standards.RusEng.charset(letter)
        char should be === latin
      }
    }

    "support different translit syntax" in {
      val word = "Армагедонец"
      word.translit[Russian >> English] should be === word.translit[English << Russian]
    }

    "translit simple phrases into latin and back" in {
      val words = List("Больница Святого Мунго", "Иннокентий Смактуновский", "Эх была не была",
        "Педиатрическое отделение", "Психиатрия имени Васечкина")
      words foreach { phrase =>
        val inLatin = phrase.translit[Russian >> English]
        val inRussian = inLatin.translit[English >> Russian]
        phrase should be === inRussian
      }
    }

    "preserve camelCase notation" in {
      val words = List("ООченьДлинноСловО", "ЩуУка", "ПиЙ", "ЩаяС")
      words foreach { word =>
        val eng = word.translit[Russian >> English]
        val rus = eng.translit[English >> Russian]
        word should be === rus
      }
    }

    "support ascii non-letter symbols" in {
      val words = List(".О,О!?ченьДлинн@оСловО", "[Щ{у}Ука]", "(Пи)Й?", "Щ.ая!С;")
      words foreach { word =>
        val eng = word.translit[Russian >> English]
        val rus = eng.translit[English >> Russian]
        word should be === rus
      }
    }
  }
}
