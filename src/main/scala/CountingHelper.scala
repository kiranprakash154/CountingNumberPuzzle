package com.kp.CountingProblem

import scala.util.{Failure, Success, Try}

object CountingHelper {


  private def nextKill(curr: Int, k: Int, n: Int): Int = (curr + k) % n

  def findSafePos(n: Int, k: Int): Int = {
    if (k > n || n == k) throw new IllegalArgumentException("k cannot be greater than or equal to n")
    if (k == 2) 2 * (n - Integer.highestOneBit(n)) + 1
    else {
      val toKillInOrder = new Array[Int](n + 1)
      toKillInOrder(0) = nextKill(0, k, n)
      for ( i <- 1 to n)
        toKillInOrder(i) = nextKill(toKillInOrder(i - 1), k, n)
      nextKill(toKillInOrder(n), k, n)
    }
  }
  
  def findSafePos(n: String, k: String): Option[Int] = {
    val safePos: Try[Int] = for {
      n <- Try(n.toInt)
      k <- Try(k.toInt)
    } yield CountingHelper.findSafePos(n, k)

    safePos match {
      case Failure(e) =>
        println(s"Invalid inputs, Exception thrown : $e")
        None
      case Success(s) =>
        println(s"The safe position : $s")
        Some(s)
    }
  }
}
