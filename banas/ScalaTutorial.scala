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
    // Immutable
    val employees = Map("Manager" -> "Bob Smith", "Secretary" -> "Sue Garfield")
    if (employees.contains("Manager"))
      printf("Manager: %s\n", employees("Manager"))
    printf("Secretary: %s\n", employees.get("Secretary"))
    printf("BAD: %s\n", employees.get("BAD BAD"))

    delimit()
    // Mutable
    val customers =
      collection.mutable.Map(100 -> "Paul Smith", 101 -> "Sally Jones")
    printf("Customer 1: %s\n", customers(100))
    customers(100) = "James Jonah"
    printf("Customer 1: %s\n", customers(100))
    customers(102) = "Rhadamant Belovsky"
    for ((key, value) <- customers)
      printf("Customer %d: %s\n", key, value)

    // ---------- TUPLES ----------
    delimit()
    // Immutable
    var tupleMarge = (103, "Marge Simpson", 10.25)
    printf("%s owes us %.2f\n", tupleMarge._2, tupleMarge._3)
    tupleMarge.productIterator.foreach(i => println(i))
    println(tupleMarge.toString())

    // ---------- CLASSES ----------
    delimit()
    val beygle = new Animal
    beygle.setName("Beygle")
    beygle.setSound("Woof")
    println(
      "Hello, my name is " + beygle.getName() + ", I'm a cute little pug."
    )
    println(beygle.toString())

    delimit()
    val whiskies = new Animal("Whiskies", "Meow")
    println(
      s"Hello, my name is ${whiskies.getName()}, I'm a cute little cat."
    )
    println(whiskies.toString())

    delimit()
    val bacon = new Dog("Bacon", "Woof", "Grrr")
    println(
      "Hello, my name is " + bacon.getName() + ", I'm a cute little pug."
    )
    println(bacon.toString())

    delimit()
    val fenrir = new Wolf("Fenrir")
    fenrir.speed = 120
    println(fenrir.move)

    // ---------- TRAITS ----------
    delimit()
    val superman = new SuperHero("Superman")
    println(superman.fly)
    println(superman.hitByBullet)
    println(superman.ricochet(3419))

    // ---------- HIGHER ORDER FUNCTIONS ----------
    delimit()
    val log10Func = log10 _
    println(log10Func(10000))
    List(10.0, 100.0, 1000.0, 10000.0).map(log10Func).foreach(println)
    List(1, 2, 3, 4, 5).map((x: Int) => x * 50).foreach(println)
    List(1, 2, 3, 4, 5).filter(_ % 2 == 0).foreach(println)

    delimit()
    def times3(num: Int) = num * 3
    def times4(num: Int) = num * 4
    // Receives a function as an argument
    def multInt(func: (Int) => Double, num: Int) = func(num)
    printf("3 * 100 = %.1f\n", multInt(times3, 100))
    printf("4 * 100 = %.1f\n", multInt(times4, 100))

    delimit()
    val divisorVal = 5
    val divFive = (num: Double) => num / divisorVal
    printf("5 / 5 = %.1f\n", divFive(5))

    // ---------- FILE I/O ----------
    delimit()
    val writer = PrintWriter("test.txt")
    writer.write("Just do it\nYesterday you said tomorrow")
    writer.close()

    delimit()
    val textFromFile = Source.fromFile("test.txt", "UTF-8")
    val lineIterator = textFromFile.getLines()
    for (line <- lineIterator)
      println(line)
    textFromFile.close()

    // ---------- EXCEPTION HANDLING ----------
    delimit()
    def divideNums(num1: Int, num2: Int) = try {
      num1 / num2
    } catch {
      case ex: java.lang.ArithmeticException => "Can't divide by zero."
    } finally {
      // Cleanup
    }
    println("3 / 0 = " + divideNums(3, 0))

    delimit()
  }

  def delimit(): Unit = {
    println("========================================")
  }

  // ---------- CLASSES ----------

  class Animal(var name: String, var sound: String) {
    // No static variables/methods
    // Default constructor in declaration
    this.setName(name)
    val id = Animal.newId

    // You can restric access as you would in Java/JS/Whatever
    // Can only be accessed by class its own class methods
    // private var name = "No Name"
    // Can be accessed by class and sub-class methods
    // protected var name = "No Name"
    // Can be accessed by anything
    // public var name = "No Name"

    def getName(): String = name
    def getSound(): String = sound

    def setName(name: String): Unit = {
      val hasDigits = name.matches(".*\\d+.*")
      if (hasDigits) {
        println("Bad animal name!")
        return
      }

      this.name = name
    }
    def setSound(sound: String): Unit = {
      this.sound = sound
    }

    // Another constructor
    def this(name: String) = {
      this("No Name", "No Sound")
      this.setName(name)
    }
    // Method overloading
    def this() = {
      this("No Name", "No Sound")
    }

    override def toString(): String = {
      return "%s with id %d says '%s'".format(this.name, this.id, this.sound)
    }

  }

  // Companion object for static class variables and functions
  object Animal {
    private var idNumber = 0
    private def newId = { idNumber += 1; idNumber }
  }

  // 'final' Makes class uninheritable
  // 'extends' Inherits from another class
  final class Dog(name: String, sound: String, growl: String)
      extends Animal(name, sound) {
    def this(name: String, sound: String) = {
      this("No Name", sound, "No Growl")
      this.setName(name)
    }
    def this(name: String) = {
      this("No Name", "No Sound", "No Growl")
      this.setName(name)
    }
    def this() = {
      this("No Name", "No Sound", "No Growl")
    }

    override def toString(): String = {
      return "%s with id %d says '%s' and growls '%s'".format(
        this.name,
        this.id,
        this.sound,
        this.growl
      )

    }
  }

  // Can't be instantiated
  abstract class Mammal(name: String) {
    var speed: Double

    def move: String
  }

  class Wolf(name: String) extends Mammal(name) {
    var speed = 35.0

    def move = "The Wolf %s moves at %f mph".format(
      this.name,
      this.speed
    )
  }

// ---------- TRAITS ----------
  // Like Java/TypeScript interfaces
  trait Fyable {
    def fly: String
  }

  trait BulletProof {
    def hitByBullet: String

    def ricochet(initialSpeed: Double): String = {
      "The bullet ricochets at a speed of %.1f ft/sec".format(
        initialSpeed * 0.75
      )
    }
  }

  class SuperHero(name: String) extends Fyable with BulletProof {
    def fly = "%s flies around the city".format(this.name)
    def hitByBullet = "The bullet bounces off of %s".format(this.name)
  }

}
