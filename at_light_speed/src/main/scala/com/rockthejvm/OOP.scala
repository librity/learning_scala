package com.rockthejvm

import org.omg.CORBA.Object

import java.awt.peer.LightweightPeer

object OOP extends App {
  class Animal {
    val age: Int = 0

    def eat(): Unit = println("I'm eating")
  }

  val anAnimal = new Animal
  anAnimal.eat()

  //  name is only an argument, not a field
  //  class Dog(name: String) extends Animal

  //  name is both an argument and a field
  class Dog(val name: String) extends Animal {
    def greet(): Unit = println(s"Hello, my name is ${this.name}")
  }

  val beygle = new Dog("Beygle")
  beygle.greet()

  //  Subtype Polymorphism
  val aDeclaredAnimal: Animal = new Dog("Bacon")
  //  The most derived method will be called at runtime
  aDeclaredAnimal.eat()

  //  Abstract Class
  abstract class WalkingAnimal {
    //    Fields and methods are public by default
    //    Can restrict w/ private and protected
    val hasLegs = true

    def walk(): Unit
  }

  //  Interface: ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // Valid method name
  }


  //  Single-class inheritance and multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println(s"Eating an animal.")

    def ?!(thought: String): Unit = println(s"I was thinking: '$thought'")
  }

  val aCroc = new Crocodile()
  val aDog = new Dog("Sparky")
  aCroc.eat(aDog)
  aCroc eat aDog // Infix Notation: for methods with only one argument
  aCroc ?! "Cogito ergo sum."

  //  Operators are methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2)

  //  Anonymous Classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("Trex gonna eat you.")
  }
  dinosaur.eat(aCroc)

  // Singleton = object, only instance of the type
  object MySingleton {
    val special = 51941

    def myFavNum(): Int = special

    //    Special Method
    def apply(x: Int): Int = x + 1
  }

  println(MySingleton.special)

  //  These are equivalent
  println(MySingleton.apply(65))
  println(MySingleton(65))

  //  Companion Object (can also be a trait)
  //  Can access each others fields and methods
  //  Singleton Animal and instances of Animal are different things
  //  We can use this as a Singleton and/or add static methods and fields
  object Animal {
    var canLiveForever = false
  }

  val animalsCanLiveForever = Animal.canLiveForever

  /*
    Case Classes
    Lightweight data sctructures with boilerplate:
    - Sensible equals and hash code
    - Sensible and quick serializations
    - Companion w/ apply()
    - Pattern matching
   */
  case class Person(name: String, age: Int)

  //  May construct without new
  val bob = Person("Bob", 54) // == Person.apply("Bob", 54)


  //  Exceptions: special objects treated by the JVM
  try {
    val x: String = null
    x.length
  } catch {
    case e: Exception => "Can't call length on a null instance"
  } finally {
    //  TODO:  CLEANUP
  }

  //  Generics: like C++ templating
  //  T: Any type we denote
  abstract class MyList[T] {
    def head: T

    def tail: MyList[T]
  }

  //   T becomes concrete here as Int
  val aList: List[Int] = List(1, 2, 3) // == List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail

  val aStringList: List[String] = List("Bob", "Ross", "Riley") // == List.apply("1", "2", "3")
  val firstString = aStringList.head
  val restString = aStringList.tail
  println(firstString)
  println(restString)


  //  We USUALLY operate with IMMUTABLE values/objects
  var reversed = aList.reverse // Returns a NEW List
  //  Benefits:
  //  - Thread and distributed environment safety
  //  - Helps to make sense of the code


  //  Scala is closest to the OO ideal: everything is inside an instance of some type
}

