// scalac ScalaTutorial.scala && scala ScalaTutorial.scala

import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source
import scala.runtime.ScalaRunTime.stringOf

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
    def factorial(num: BigInt): BigInt = {
      if (num <= 1)
        return 1

      // Implicit return (like in ruby)
      factorial(num - 1) * num
    }
    println("1! = " + factorial(1))
    println("2! = " + factorial(2))
    println("3! = " + factorial(3))
    println("4! = " + factorial(4))
    println("5! = " + factorial(5))

// ---------- ARRAYS ----------
    delimit()
    val array = Array.fill(2, 2)(0)
    val friends = Array("Bob", "Tom")
    friends(0) = "Sue"
    val stuff = Array("Bob", 32)
    println(array)
    println(stringOf(array))
    println(stringOf(friends))
    println(stringOf(stuff))

    delimit()
    // ArrayBuffer size can change
    val friends2 = ArrayBuffer[String]()
    friends2.insert(0, "Phil")
    friends2.insert(1, "Robin")
    friends2 += "Mark"
    friends2 ++= Array("Susy", "Denton")
    friends2.insert(1, "Ross")
    friends2.remove(1, 2)
    println(stringOf(friends2))
    for (fr <- friends2)
      printf("%s, ", fr)
    printf("\n")

    delimit()
    val favNums = new Array[Int](20)
    println(stringOf(favNums))
    for (j <- 0 to (favNums.length - 1))
      favNums(j) = j
    println(stringOf(favNums))

    delimit()
    val favNumsTimes2 = for (num <- favNums) yield 2 * num
    println(stringOf(favNumsTimes2))
    val favNumsDiv4 = for (num <- favNums if num % 4 == 0) yield num
    favNumsDiv4.foreach(println)
    println("sum = " + favNumsDiv4.sum)
    println("min = " + favNumsDiv4.min)
    println("max = " + favNumsDiv4.max)
    val sortedNums = favNumsTimes2.sortWith(_ > _)
    println(stringOf(sortedNums))

    delimit()
    var multiplicationTable = Array.ofDim[Int](10, 10)
    for (i <- 1 to 10)
      for (j <- 1 to 10)
        multiplicationTable(i - 1)(j - 1) = i * j
    println(stringOf(multiplicationTable))

    // ---------- MAPS ----------
    delimit()

    delimit()
// ---------- TUPLES ----------

// ---------- CLASSES ----------

// ---------- TRAITS ----------

// ---------- HIGHER ORDER FUNCTIONS ----------

// ---------- FILE I/O ----------

// ---------- EXCEPTION HANDLING ----------

// ---------- END OF MAIN ----------

// ---------- CLASSES ----------

// ---------- INHERITANCE ----------

// ---------- ABSTRACT CLASS ----------

// ---------- TRAITS ----------

// ---------- End of object ScalaTut ----------

  }

  def delimit(): Unit = {
    println("========================================")
  }
}
