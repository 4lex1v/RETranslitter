A very small library for the cases when you can't use Russian/Cyrillic (utf-8) symbolic table, i.e store some string
data in the db which support only ascii symbols or transfer some data over encoded with latin alphabet.

The default rules for Russian <-> English transliteration are satisfying to [ГОСТ 16876-71](http://transliteration.ru/gost/).

To use this library, just add:

<code>import retranslit._</code>

and then call <code>translit</code> function with the direction for translitteration:

```scala
val word = "Щука!"
val inLatin = word.translit[Russian >> English]
```

this will convert `Щука!` into `Shhuka!`. To convert the word back just switch the `>>` to `<<` or explicitly change the
direction:

```scala
val word = "Shhuka!"
val inLatin1 = word.translit[Russian << English]
val inLatin2 = word.translit[English >> Russian]
```


