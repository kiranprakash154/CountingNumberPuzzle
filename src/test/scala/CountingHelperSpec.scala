package com.kp.CountingProblem

import org.scalatest.{FlatSpec, MustMatchers}

class CountingHelperSpec extends FlatSpec with MustMatchers {

  behavior of "findSafePos"
  it should "return None on Invalid parameters" in {
    CountingHelper.findSafePos("n", "5") must be(None)
    CountingHelper.findSafePos("5", "5") must be(None)
    CountingHelper.findSafePos("5", "6") must be(None)
  }

  it should "throw IllegalArgumentException on n <= k" in {
    an [IllegalArgumentException] should be thrownBy CountingHelper.findSafePos(5, 5)
    an [IllegalArgumentException] should be thrownBy CountingHelper.findSafePos(5, 6)
  }
  
  it should "if k==2 use the optimization part of the code" in {
    CountingHelper.findSafePos("100", "2") must be(Some(73))
  }

  it should "return correct values on correct inputs" in {
    CountingHelper.findSafePos("50", "25") must be(Some(0))
    CountingHelper.findSafePos("5", "3") must be(Some(1))

  }
  
}
