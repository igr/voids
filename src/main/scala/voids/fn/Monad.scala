package voids.fn

trait Monad[F[_]] extends Applicative[F] {

  def flatMap[A,B](fa: F[A])(f: A => F[B]): F[B]

  def map2[A,B,C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] =
    flatMap(fa)(a => map(fb)(b => f(a, b)))

}
