package com.rockthejvm

object PatternMatching extends App {
  val anInt = 42
  val order = anInt match {
    case 1 => "First"
    case 2 => "Second"
    case 3 => "Third"
    case _ => anInt + "th"
  }
  println(order)


  //  Pattern matching case classes is easy.
  //  Pattern normal classes is a nightmare.
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 42)
  val greeting = bob match {
    case Person(name, age) => s"Hi, my name is $name and I'm $age years old"
    case _ => "Howdy stranger."
  }
  println(greeting)


  //  Deconstruct Tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to genre $genre."
    case _ => "I don't know what you're talking about."
  }
  println(bandDescription)


  //  Decompose Lists
  val aList = List(1, 2, 3)
  val listDescription = aList match {
    case List(_, 2, _) => "List contais 2 on its second position"
    case _ => "Unknown list"
  }
  //  Unlike Rust, wildcard match isn't mandatory.
  // Unmatched blocks throw MatchError

  // Matches cases in sequence
  val unknownDescription = aList match {
    case _ => "Unknown list"
    case List(_, 2, _) => "List contais 2 on its second position"
  }
  println(unknownDescription)


}
