package example

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

trait Example

object Example {
  def apply[T](f: Any => T): Example = macro applyImpl

  def applyImpl(c: blackbox.Context)(f: c.Tree): c.Expr[Example] = {
    import c.universe._
    val functionName = TermName(c.freshName())
    c.Expr[Example] {
      q"""
        new Example {
          val $functionName = $f
        }
      """
    }
  }
}
