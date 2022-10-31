// scalac ScalaTutorial.scala && scala ScalaTutorial.scala

import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source

object ScalaTutorial {
  def main(args: Array[String]): Unit = {

    // ---------- LOOPING ----------

    delimit()
    var i = 0
    while (i <= 5) {
      println(i)
      i += 1
    }

    // DEPRECATED
    // delimit()
    // i = 0
    // do {
    //   i += 1
    // } while (i <= 5)

    delimit()
    for (i <- 1 to 5) {
      println(i)
    }

    delimit()
    val randLetters = "dadioasjdop"
    for (i <- 0 until randLetters.length)
      println(randLetters(i))

    delimit()
    val aList = List(1, 2, 3, 4, 5)
    for (i <- aList) {
      printf("List items: ")
      printf("%d", i)
      printf("\n")
    }

    delimit()
    var evensList = for {
      i <- 1 to 20
      if (i % 2) == 0
    } yield i
    for (i <- evensList)
      println(i)

    delimit()
    for (i <- 1 to 5; j <- 6 to 10) {
      println("i: " + i + ", j: " + j)
    }

    delimit()
    for (i <- 1 to 5; j <- 6 to 10) {
      println("i: " + i + ", j: " + j)
    }
    delimit()

    def printPrimes(): Unit = {
      val primeList = List(1, 2, 3, 5, 7, 11)
      for (i <- primeList) {
        if (i == 11) {
          // scala.util.control.NonLocalReturns
          return
        }

        if (i != 1)
          println(i)
      }
    }
    printPrimes()

    // ---------- INPUT / OUTPUT ----------

    delimit()
    // var numberGuess = 0
    var numberGuess = 42
    while (numberGuess != 42) {
      print("Guess a number: ")
      numberGuess = readLine.toInt
    }
    printf("You guessed the secret number %d\n", 42)

    // ---------- STRINGS ----------

    delimit()
    val name = "Luis"
    val age = 25
    val weight = 175.23232
    println(s"Hello $name")
    println(f"I am ${age + 1} and weigh $weight%.2f")
    printf("'%5d'\n", 5)
    printf("'%-5d'\n", 5)
    printf("'%05d'\n", 5)
    printf("'%05.5f'\n", 5.53141312421)
    printf("'%5s'\n", "hi")
    printf("'%-5s'\n", "hi")

    delimit()
    var randSent = "I saw a dragon fly by"
    println("3rd index: " + randSent(3))
    println("Length: " + randSent.length())
    println(randSent.concat(" and explode!"))
    println("Are strings equal: " + "I saw a".equals(randSent))
    println("'dragon' starts at index: " + randSent.indexOf("dragon"))
    var randSentArr = randSent.toArray
    for (v <- randSentArr)
      printf("'%c', ", v)
    printf("\n")

    // ---------- FUNCTIONS ----------

    delimit()
    def getSum(a: Int = 1, b: Int = 1): Int = {
      return a + b
    }
    println("getSum = " + getSum)
    println("1 + 1 = " + getSum())
    println("4 + 5 = " + getSum(4, 5))
    println("9 + 42 = " + getSum(b = 42, a = 9))

    delimit()
    def greet(): Unit = {
      println("How you doing?")
    }
    greet()
    def sumOver(args: Int*): Int = {
      var sum = 0

      for (add_me <- args)
        sum += add_me
      return sum
    }
    println("9 + 42 + 32 + 51 = " + sumOver(9, 42, 32, 51))
    println("1 + 2 + 3 + 4 = " + sumOver(1, 2, 3, 4))

    delimit()
  }

  def delimit(): Unit = {
    println("========================================")
  }
}
