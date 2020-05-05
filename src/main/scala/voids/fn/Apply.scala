package voids.fn

trait Apply[F[_]] extends Functor[F] {
  /**
   * Turns a function within a context into a function that operates on contexts.
   * Effectively ap can let us lift a function through a functor.
   */
  def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]
}
