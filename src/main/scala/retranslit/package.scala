package object retranslit {
  type >>[F, T] = Translitter[F, T]
  type <<[T, F] = Translitter[F, T]

  implicit def phaseTranslitter(str: String) = new PhraseTranslator(str)
}
