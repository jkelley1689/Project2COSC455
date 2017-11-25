val chinese : List[String] = List("ling","yi","er","san","si","wu","liu","qi","ba","jiu","shi")
val english : List[String] = List("zero","one","two","three","four","five","six","seven","eight","nine")




val list : List[String] = List("yi","two","san","justin","mike","si","six")


// This function takes in a list of strings and translates them to numbers,
// performs addition and multiplication on them and prints out the result
def go(list : List[String]) : Unit = {
  val intList = translate(list)

  println("Translated list is: " + intList.mkString(","))
  println("Addition: " + intList.mkString(" + ") + " = " + add(intList))
  println("Multiplication: " + intList.mkString(" * ") + " = " + multiply(intList))
}

//This function translates chinese and english words to their numerical counterparts
def translate(list : List[String]) : List[Int] = {
  list match {
    case Nil => Nil
    case head :: tail => if(chinese.contains(head))
      chinese.indexOf(head) :: translate(tail)
    else if(english.contains(head))
      english.indexOf(head) :: translate(tail)
    else translate(filter(head,list))
  }
}

// This function filters out words that are not numbers in the list and returns the new list
def filter(s : String,list : List[String]) : List[String] = {
  list.filter(_ != s)
}

translate(list) // List(1,2,3,4,6)

def add(list : List[Int]) = list.foldLeft(0)(_ + _)

def multiply(list : List[Int]) = list.foldLeft(1)(_ * _)

val intList = translate(list)
intList.mkString(",")

add(intList)
multiply(intList)

go(list) // List : 1,2,3,4,6  Addition : 1 + 2 + 3 + 4 + 6 = 16
          // Multiplication: 1 * 2 * 3 * 4 * 6 = 144









