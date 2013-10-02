package retranslit

object Main {
  def main(args: Array[String]) {
    val word = "Щука!"
    val s = b.translit[Russian >> English]
    println(s)
    val ss = s.translit[English >> Russian]
    println(ss)
  }
}
