// Create a List - the old fashioned way
List('a', 'b', 'c')
List(1, 2, 3, 4)
val myList = List(1,2,3,4)

// Lists are immutable

// Create a List - the lazy ways
val turtles = "I like turtles!" toList


// Cons'ing a List - constructing a new list from a given list
// Note that a new list is returned, the original list is not changed.
"Hello" :: turtles
123 :: turtles

// Nil and ::
// Create an empty list with no data type, i.e., Nothing
List()

// Create an empty list and compare to Nil should yield true
List() == Nil

// Create an empty list of a specific data type
List[String]()

// Create a list through cons
// Note that this is right associative; it first creates a Nil list, then adds abc.
"abc" :: Nil
123 :: Nil

// Create a list through multiple cons'ing
// Note that this is right associative; it first creates a Nil list, then adds def to the head, then adds abc.
"abc" :: "def" :: Nil

// Heads, tails and isEmpty
val wisc = "Wisconsin" toList

// Get the head
wisc head

// Note that head doesn't actually cut the head off
println(wisc)

// Get the tail
wisc tail

// Check if empty
wisc isEmpty

Nil isEmpty

// Grab the head of an empty list
// This is dumb ~
// Nil head

// Take, drop and splitAt
wisc

// Take
wisc take 4

// Drop
wisc drop 4

// Note that it returns a new list, it doesn't change the original list
wisc

// splitAt in postfix and Java-like notation
wisc splitAt 4

wisc.splitAt(4)

// toString and mkString
List(1, 2, 3).toString()

println(List(1, 2, 3).toString())

List(1, 2, 3).toString() == "List(1, 2, 3)"

List(1, 2, 3) mkString(" is less than ")

List(1, 2, 3) mkString("*")

List(1, 2, 3) mkString("<:", "--", ":>")

List(1, 2, 3, 4) mkString("<:", "--", ":>")

List(1, 2, 3) mkString("(", ",", ")")

// Split, zip and Unzip
val words = "one two three" split " "

val numbers = List(1, 2, 3)

// Zip
val z = words zip numbers
val z2 = numbers zip words
val z3 = words zip words

z toMap


// Unzip
z2 unzip

// Higher-order functions
// Syntax: parameter list => function body
val brag = "I like turtles!" toList

// Higher-order function to count the "t"s
brag count((ch: Char) => ch == 't')

// Higher-order function to count how many non-letters
brag count((ch: Char) => !(ch isLetter))

// If there is only one parameter, used once, you can cheat
// with the _ notation
brag count (_ == 't')

// Fold left with _ notation
// Syntax for fold left: foldLeft <initial value> <function>
(1 to 10).foldLeft(0)(_ + _)

// This syntax is handy for sorting
val numbersList = List(4,7,3,9,5,88,6,4)
numbersList
numbersList sortWith((x, y) => x < y)

// Using _ notation
numbersList sortWith(_ < _)


numbersList sortWith(_ > _)

// forall
numbersList forall(n => n < 7) // false
numbersList forall(n => n < 100) // true

// forall using _ notation
numbersList forall(_ < 100) // true

// foreach
val someList = List("Scala", "is", "great!")
someList foreach(println(_))
someList foreach(println)

numbersList foreach (n => if (n > 4) println(n))

// numbersList is all integers, but we can add
// other stuff and it will coerce the list to Any

"coersion" :: numbersList

// Closures
var c = 5
val mult = (x: Int) => c * x

mult(3)

c = 7
mult(10)

// map and flatmap
// map produces a new list by applying the given function to each element of the given list
numbersList
numbersList map(n => n + 2)
// but remember, List is immutable - the list doesn't change, map returns a new list
numbersList

// We can also cheat and use the _ notation
numbersList map (_ >= 5)

// flatMap produces a new list by applying the given function to each element of the given list, and “flattening” the result
numbersList flatMap (x => List(x, x+2))

// filter
numbersList
numbersList filter (_ < 7)

// filter produces a new list consisting of the values that pass the given test
numbersList filter (_ % 2 == 1)





