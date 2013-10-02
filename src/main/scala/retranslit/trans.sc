object test {
  import retranslit._

  def time[R](body: => R): R = {
    val start = System.nanoTime()
    val res = body
    val end = System.nanoTime() - start
    println("End up in " + end)
    res
  }

  val b = "проверканаскоростьтранлитаоченьдлиннойстрочкиизмногабукаф"
  val bb = "Эх"

  val s = time(b.translit[Russian >> English])


  time(s.translit[English >> Russian])


  time(s.translit[English >> Russian])


  time(s.translit[English >> Russian])


  time(s.translit[English >> Russian])


  time(s.translit[English >> Russian])


  time(s.translit[English >> Russian])


  time(s.translit[English >> Russian])


  time(s.translit[English >> Russian])


  time(s.translit[English >> Russian])


  time(s.translit[English >> Russian])


  time(s.translit[English >> Russian])


  time(s.translit[English >> Russian])


  time(s.translit[English >> Russian])


  time(s.translit[English >> Russian])




  b == ss




}

