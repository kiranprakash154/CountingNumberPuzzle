package com.kp.CountingProblem

object Main extends App {

  val res: Option[Int] = CountingHelper.findSafePos(args(0), args(1))
  println(s"res : $res")
  
}
