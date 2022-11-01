package com.rockthejvm

//Only works with Scala 3
object ContextualAbstractions {
  //  Context Parameters/Arguments

  //  Ordering
  val aList = List(2, 3, 1, 4)
  // Has default Ordering parameter injected by the compiler (Contextual Argument).
  val orderedList = aList.sorted

  //  given (Scala 3):
  //  tells the compiler to inject descendingOrder in aList.sorted instead of the default ordering within this scope
  given descendingOrder: Ordering[Int] = Ordering.fromLessThan(_ > _) // Lambda notation:  (a, b) => a > b
  //  Analogous to an implicit val


  trait Combinator[A] { // aka Monoid
    def combine(a: A, b: A): A
    //    Example: 2 + 2 = 4
  }

  //  Declare a function that takes in a List and a Combinator:
  def combineAllExplicit[A](list: List[A])(combinator: Combinator[A]): A = list.reduce((a, b) => combinator.combine(a, b))

  val diffCombinator: Combinator[Int] = new Combinator[Int] {
    override def combine(a: Int, b: Int): Int = a - b
  }
  //  This can get very verbose wherever it's called:
  val aListDiff = combineAllExplicit(aList)(diffCombinator)


  //  using: Tells the compiler to look for a "given" Combinator in the scope
  def combineAllImplicit[A](list: List[A])(using combinator: Combinator[A]): A = list.reduce((a, b) => combinator.combine(a, b))

  //  Wish we could call it like this:
  val aListSum = combineAllImplicit(aList)

  //  Declare a combinator within scope and the compiler will inject it:
  given sumCombinator: Combinator[Int] = new Combinator[Int] {
    override def combine(a: Int, b: Int): Int = a + b
  }

  /*
    Compiler looks for instances in:
    1. Local Scope
    2. Imported Scope (import package.given)
    3. Companions of all the types involved in the call. Example:
      - Companion of List
      - Companion of Int
  */


  //  Context Bounds (shorthand)

  //Implicit combinator
  def combineAllV2[A](list: List[A])(using Combinator[A]): A = ???

  // [A: Combinator] == A must have an isntance of Combinator [A] in scope.
  def combineAllV3[A: Combinator](list: List[A]): A = ???

  /*
    Where Context Args are useful:
    - Type Classes
    - Dependency Injection
    - Context-dependent Functionality
    - Type-Level Programming: generate and prove relationships at compile time
  */


  //  Extension Methods
  // Add methods to a type after it has been defined.

  case class Person(name: String) {
    def greet(): String = s"Hi, my name is $name!"
  }

  extension (string: String) def greet(): String = new Person(string).greet()
  val danielGreeting = "Daniel".greet() // Type Enrichment, aka "pimping"

  //  POWER
  extension[A] (list: List[A])
    def cobineAllValues(using combinator: Combinator[A]): A =
      list.reduce(combinator.combine)
  val extensionSum = aList.cobineAllValues

  def main(args: Array[String]): Unit = {
    println(orderedList)
    println(aListDiff)
    println(aListSum)
    println(danielGreeting)
    println(extensionSum)
  }


}