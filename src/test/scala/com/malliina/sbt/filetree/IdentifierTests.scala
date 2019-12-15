package com.malliina.sbt.filetree

import org.scalatest.funsuite.AnyFunSuite

class IdentifierTests extends AnyFunSuite with ScalaIdentifiers {
  test("camelCase") {
    assert(camelCase("a-b") === "aB")
    assert(camelCase("raar_") === "raar_")
  }

  test("negative camelCase") {
    assert(camelCase("blaaBlaa") === "blaaBlaa")
  }

  test("sanitize") {
    assert(sanitize("class") === "`class`")
  }

  test("negative sanitize") {
    assert(sanitize("huuhaa") === "huuhaa")
  }

  test("worst case scenario") {
    assert(legalName("for_some") === "for_some")
  }

  test("legality") {
    assert(legalName("app-5.newest") === "app_5_newest")
  }
}
