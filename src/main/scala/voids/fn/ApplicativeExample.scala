package voids.fn

object ApplicativeExample {

  implicit object OptionApplicative extends Applicative[Option] {

    override def pure[A](a: A): Option[A] = Option.apply(a)

    override def ap[A, B](ff: Option[A => B])(fa: Option[A]): Option[B] = {
      // we have 2x2 variants here!
      // however, only one variant returns Some

      if ((ff.isEmpty) || (fa.isEmpty)) {
        return Option.empty
      }
      Some(ff.get(fa.get))
    }
  }

  implicit object SetApplicative extends Applicative[Set] {
    override def pure[A](a: A): Set[A] = Set(a)

    override def ap[A, B](ff: Set[A => B])(fa: Set[A]): Set[B] = {
      var result = Set[B]()

      ff.foreach(fn => {
        fa.foreach(a => {
          result += fn(a)
        })
      })

      result
    }
  }


  def main(args: Array[String]): Unit = {
    val a = Some(2)
    val ff = Some((x: Int) => x + 1)

    val b = OptionApplicative.ap(ff)(a)
    println(b)

    // --------------------

    val s = Set(1, 2, 3)
    val ff2 = Set((x: Int) => x + 1, (x: Int) => x - 1)

    val c = SetApplicative.ap(ff2)(s)

    // 0 1 2 3 4
    println(c)
  }
}
