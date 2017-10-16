package example

import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {
  "Example" should "work with reference type" in {
    Example(_ => "")
  }

  it should "also work with primitive type" in {
    Example(_ => true)
  }
}
