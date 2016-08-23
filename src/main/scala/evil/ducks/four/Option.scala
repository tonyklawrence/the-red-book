package evil.ducks.four

sealed trait Option[+A] {
  def map[B](f: A => B): Option[B] = this match {
    case None() => None()
    case Some(a) => Some(f(a))
  }
  def getOrElse[B >: A](default: => B): B = this match {
    case None() => default
    case Some(a) => a
  }
  def flatMap[B](f: A => Option[B]): Option[B] = map(f) getOrElse None()
  def orElse[B >: A](ob: => Option[B]): Option[B] = map (Some(_)) getOrElse ob
  def filter(f: A => Boolean): Option[A] = flatMap (n => if (f(n)) Some(n) else None())
}

case class Some[+A](get: A) extends Option[A]
case class None() extends Option[Nothing]

object Option {
  def sequence[A](a: List[Option[A]]): Option[List[A]] = a match {
    case Nil => Some(Nil)
    case (None() :: as) => None()
    case (Some(a) :: as) => a :: sequence(as)
  }
}