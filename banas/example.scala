// Run scala REPL
// $ scala
// Quit with CTRL+C or :q

10 + 4 *12 / 42
"Your answer: " + res0

// Variable
var myName = "Luis"
// Constant
val myAge = 25


// ---------- DATA TYPES ----------

// All datatypes in Scala are objects and they include
// (Get the max value with MaxValue)
// Byte : -128 to 127
// Boolean : true or false
// Char : unsigned max value 65535
// Short : -32768 to 32767
// Int : -2147483648 to 2147483647
// Long : -9223372036854775808 to 9223372036854775807
// Float : -3.4028235E38 to 3.4028235E38
// Double : -1.7976931348623157E308 to 1.7976931348623157E308

/*
MULTILINE
COMMENTS
*/

// Double have 15 digits of precision
val num13digits = 1.9321131999999999123912391293129312939
// A Double will only hold precision up to 15 digits
val num13 = 1.999999999999999
val lrgPrime = BigInt("948129084902840912840912840921840912840921849021804981209482190482190482190481092849012849021849012849021849750372802131")
lrgPrime + 1
val bigDecimal = BigDecimal("3123213219312039123.3123213208312830128038129038192380912839021830928490240914218490128490812904812904")
bigDecimal + 0.123

var randInt = 1000
randInt.//Press TAB to get methods
// Can't do ++ or --
// randInt++
randInt += 1
randInt
randInt -= 42
randInt

val randConst = 1000
// Can't modify const
// randConst += 1
// randConst
// randConst -= 42
// randConst

"5 + 4 = " + 5 + 4
"5 + 4 = " + (5 + 4)
"5 - 4 = " + (5 - 4)
"5 * 4 = " + (5 * 4)
"5 / 4 = " + (5 / 4)
"5 % 4 = " + (5 % 4)


// ---------- MATH ----------

// Import everything from scala.math
import scala.math._
abs(-42)
cbrt(-42)
ceil(-42.2131)
floor(-42.2131)
round(-42.2131)
exp(1)
pow(2, 2)
sqrt(pow(2, 2) + pow(2, 2))
hypot( 2 ,2)
log10(1000)
log(1321312)
log(exp(1))
min(10, 5)
max(10, 5)
(random * 10 + 1).toInt
toDegrees(0.5)
toRadians(0.5)
acos(0.5)
asin(0.5)
atan(0.5)
atan2(0.5, 0.5)
cos(0.5)
cosh(0.5)
sin(0.5)
sinh(0.5)
tan(0.5)
tanh(0.5)


// ---------- CONDITIONALS ----------
// Conditional Operators : ==, !=, >, <, >=, <=
// Logical Operators : &&, ||, !

var age=18
val canVote = if(age>=18) "yes" else "no"
if((age>=  5) && (age<=6)){
  println("Go to kindergarten")
} else if((age>=  6) && (age<=7)) {
  println("Go to 1st grade")
} else {
  printf("Go to %d grade\n", age - 5)
}

true || true
true || false
false || true
false || false

true && true
true && false
false && true
false && false

// ---------- LOOPING ----------

// ---------- INPUT / OUTPUT ----------

// ---------- STRINGS ----------

// ---------- FUNCTIONS ----------

// ---------- ARRAYS ----------

// ---------- MAPS ----------

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
