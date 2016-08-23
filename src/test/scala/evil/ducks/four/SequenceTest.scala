package evil.ducks.four

import org.scalatest.{FlatSpec, Matchers}

class SequenceTest extends FlatSpec with Matchers {

  "Sequences" should "combine a list of options" in {
    val options = Some("one") :: None() :: Some("three") :: Nil
    Option.sequence(options) should be (Some("one" :: "three" :: Nil))
  }
}
