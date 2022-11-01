package com.rockthejvm

object Functional extends App {
  class Person(name: String) {

    def apply(age: Int): Unit = println(s"I am $age years old.")
  }

  val bob = new Person("Bob")
  bob(42)

  /*
    Scala runs on the JVM: functions aren't "first class citizens"
    Functional Programming:
    - Compose functions
    - Pass functions as arguments
    - Return functions as results

    Scala invented/jury rigged FunctionX: mutant function instances
    Function1, Function2, ..., Function22
    The number indicates the number of arguments it takes.
  */

  //  Instantiate trait with only an apply method == Defining a function
  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(num: Int): Int = num + 1
  }
  println(simpleIncrementer.apply(23))
  println(simpleIncrementer(23))
  //  ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTIONX TYPES

  val stringCat = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  println(stringCat("I love: ", "Turtles"))


  // Syntax Sugar
  val sweetIncrementer = new (Int => Int) {
    override def apply(num: Int): Int = num + 1
  }
  println(sweetIncrementer(23))
  val doubler: Function1[Int, Int] = (x: Int) => 2 * x
  println(doubler(23))
  val tripler: Int => Int = (x: Int) => 3 * x
  println(tripler(23))
  val quad = (x: Int) => 4 * x
  println(quad(23))


  //  HOFs: funtions that take or return functions (like map)
  val mappedList = List(1, 2, 3).map(x => x + 1)
  println(mappedList)
  val flatMappedList = List(1, 2, 3).flatMap { x => List(x, 2 * x) }
  println(flatMappedList)
  val evensList = List(1, 2, 3, 4, 5, 6, 7, 8).filter(_ % 2 == 0) // == filter(x => x % 2 == 0)
  //  (like Elixir)
  println(evensList)
  val allPairs = List(1, 2, 3).flatMap(number => List("a", "b", "c").map(letter => s"$number-$letter"))
  println(allPairs)


  //  For Comprehensions (like Elixir)
  val altAllPairs = for {
    number <- List(1, 2, 3)
    letter <- List("a", "b", "c")
  } yield s"$number-$letter"
  println(altAllPairs)


  //  ---------------------- Collections ----------------------

  //  Lists
  val aList = List(1, 2, 3, 4, 5)
  val first = aList.head
  val last = aList.tail
  println(aList)
  println(first)
  println(last)

  val aPrependedList = 0 :: aList
  val anExtendedList = 0 +: aList :+ 6
  println(aPrependedList)
  println(anExtendedList)


  //  Sequences
  val aSequence: Seq[Int] = Seq(1, 2, 3) // Seq.apply(1, 2, 3)
  val accessedElement = aSequence(1)
  println(aSequence)
  println(accessedElement)


  // Vectors: fast Seq implementation
  val aVector = Vector(1, 2, 3, 4, 5)
  println(aVector)


  //  Sets: no duplicates
  val aSet = Set(1, 2, 3, 1, 2, 3, 4, 5, 6, 7)
  val setHas5 = aSet.contains(5)
  val addedSet = aSet + 42
  val aRemovedSet = aSet - 3
  println(aSet)
  println(setHas5)
  println(addedSet)
  println(aRemovedSet)


  //  Ranges
  val range = 1 to 1000
  val twoByTwo = range.map(_ * 2)
  println(range)
  println(twoByTwo)
  println(twoByTwo.toList)


  //  Tuples
  val aTuple = ("Bon Jovi", "Rock", 1982)
  println(aTuple)


  //  Map
  val aPhonebook: Map[String, Int] = Map(
    ("Daniel", 23124),
    "Jane" -> 62541
  )
  println(aPhonebook)

}

