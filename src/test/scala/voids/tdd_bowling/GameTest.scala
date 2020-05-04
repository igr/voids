package voids.tdd_bowling

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameTest {

  def game() = {
    new Game7
  }

  @Test
  def test_0 {
    val g = game()

    rollMany(g, 20, 0)

    assertEquals(0, g.score())
  }

  @Test
  def test_1 {
    val g = game()

    rollMany(g, 19, 0)
    g.roll(1)

    assertEquals(1, g.score())
  }

  @Test
  def test_3_weak {
    val g = game()

    g.roll(5)
    g.roll(3)
    rollMany(g, 18, 0)

    assertEquals(8, g.score())
  }

  @Test
  def test_4_strike {
    val g = game()

    g.roll(10)
    g.roll(4)
    g.roll(3)
    rollMany(g, 16, 0)

    assertEquals(17 + 7, g.score())
  }

  @Test
  def test_5_spare {
    val g = game()

    g.roll(6)
    g.roll(4)
    g.roll(3)
    rollMany(g, 17, 0)

    assertEquals(13 + 3, g.score())
  }

  @Test
  def test_6_perfectGame {
    val g = game()

    rollMany(g, 12, 10)

    assertEquals(300, g.score())
  }

  private def rollMany(g: Game, count: Int, pins: Int): Unit = {
    for (_ <- 0 until count) {
      g.roll(pins)
    }
  }

}
