package evil.ducks.four

import org.scalatest.{FlatSpec, Matchers}

class OptionTest extends FlatSpec with Matchers {


  "An Option" should "map a value" in {
    None() map identity should be(None())
    Some(1) map(_ + 1) should be(Some(2))
  }
}