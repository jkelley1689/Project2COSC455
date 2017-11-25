// This function checks if a number is prime
def isPrime(n: Int) = (n > 1) && ((2 until n) forall (n % _ != 0))

// This function checks if two numbers are twin prime numbers
// A twin prime number is a number that differs from another prime number by 2
// For example isTwinPrime(3,5) will return true
def isTwinPrime(n1 : Int, n2 : Int) = {
  ((n2 - n1 == 2) || (n1 - n2 == 2)) &&
    isPrime(n1) &&
    isPrime(n2)
}

// This function takes in a number and creates a list of all twin primes from 2 to n
// For example twinPrimeList(50) will create List(3,5,7,11,13,17,19,29,31,41,43)
def twinPrimeList(n : Int) : List[Int] = {
  n match{
    case x if x < 3 => Nil
    case _ => if(isTwinPrime(n - 2, n) || isTwinPrime(n + 2,n))
      n :: twinPrimeList(n - 1).reverse
    else twinPrimeList(n - 1).reverse
  }
}

// This function error checks the input number(must be even, must be greater than 2)
// if true continues with algorithm
// Goldbach's Conjecture states every positive even number is the sum of two prime numbers
// For example goldbachsConjecture(28) will return 5 + 23 = 28
def goldbachsConjecture(n : Int) = {
  val primes : List[Int] = (2 to n).toList.filter(x => isPrime(x))
  isEven(n) && (n > 2) match{
    case false => println("number must be even and greater than 2")
    case true => goldbach(n,primes)
  }

}

// This function is the meat of goldbach's conjecture
// Takes in the error checked number and creates a list of prime numbers from 2 to n
// Algorithm pulls the head of the list and checks if the list of primes contains n - head
def goldbach(n :Int, primes : List[Int]) : Unit = {
  primes match {
    case head :: _ => if(primes.contains(n - head))
      println(n - head + " + " + head + " = " + n)
    else goldbach(n,primes.tail)
    case _ =>
  }

}

// Helper function to check if a number is even
def isEven(n : Int) = {
  n % 2 match{
    case 0 => true
    case _ => false
  }
}