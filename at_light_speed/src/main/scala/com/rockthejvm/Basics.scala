package com.rockthejvm

object Basics extends App {

  val meaningOfLife: Int = 42
  //  Int, Double, Float, Boolean, Char, String
  val aBoolean = false

  val aString = "I don't completely hate Scala... yet"
  val aComposedString = "I " + "like " + "turtles"
  val anInterpolatedString = s"The meaning of life: $meaningOfLife"

  //  Expressions = structures that can be reduced to a value
  val anExpression = 2 + 3
  val ifExpression = if (meaningOfLife > 42) 56 else 999
  val chainedIf =
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 98
    else 0

  //  Code Blocks
  val aCodeBlock = {
    val localValue = 39

    localValue + 3
  }
  println(aCodeBlock)

  //  Functions
  def myFunc(x: Int, y: String): String = y + " " + x

  println(myFunc(42, "life is"))

  //  Scala prefers recursion over loops and iterations (like in Elixir)
  def factorial(n: Int): Int = if (n <= 1) 1 else factorial(n - 1) * n

  println(factorial(0))
  println(factorial(1))
  println(factorial(2))
  println(factorial(3))
  println(factorial(4))
  println(factorial(5))

  // Unit == void, or not a meaningful value
  //def println(x: Any): Unit
  //  type of SIDE EFFECTS
  def myUnitFunc(): Unit = println(aString)

  val theUnit: Unit = ()
  println(theUnit)


}
