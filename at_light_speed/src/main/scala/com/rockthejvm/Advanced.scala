
package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
// User thread pool:
import scala.concurrent.ExecutionContext.Implicits.global


object Advanced extends App {
  val aValWSideEffect = {
    println("I'm not lazy at all")
    42
  }


  //  Lazy evaluation
  //  Useful in infinite collections
  lazy val aLazyVal = 2
  lazy val aLazyValWSideEffect = {
    println("I am so very lazy")
    42
  }
  val eagerVal = aLazyValWSideEffect + 1


  //  "pseudo-collections":
  //  - Option: Collection that contains one element at most: Some(value) or None
  //  - Try: an elegant alternative to try/catch: contains Success(Value) or Failure(Exception)
  //  Can operate on Option and Try as you would any other collection: .map, .filter, etc.
  def methodWhichCanReturnNull(): String = "Hello Scala"

  val anOption = Option(methodWhichCanReturnNull())
  val processedString = anOption match {
    case Some(string) => s"I've obtained a valid string: '$string'"
    case None => "I obtained nothing."
  }
  println(processedString)


  def methodWhichCanThrowException(): String = throw new RuntimeException

  val aTry = Try(methodWhichCanThrowException())
  val anotherProcessedString = aTry match {
    case Success(string) => s"I've obtained a valid string: '$string'"
    case Failure(exception) => s"I've obtained an exception: '$exception'"
  }
  println(anotherProcessedString)


  //  Async Programming
  //  Evaluate something on another thread
  //  Future is a "collection" that contains a value when it's evaluated
  //  Composable with map, filter, etc.
  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)

    println("I have computed a value")
    42
  }
  //  Thread.sleep(2000)
  //  Future, Try and Option are all monads


  //  Implicit Arguments
  def implicitFunction(implicit arg: Int) = arg + 1

  implicit val implicitVal: Int = 46
  println(implicitFunction)


  //  Implicit Conversions
  implicit class MyRichInt(n: Int) {
    def isEven = n % 2 == 0
  }

  println(23.isEven)
  //  Use carefully!
}
