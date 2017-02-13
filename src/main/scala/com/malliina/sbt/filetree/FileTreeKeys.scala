package com.malliina.sbt.filetree

import sbt.{File, settingKey}

object FileTreeKeys {
  val fileTreeSource = settingKey[File]("File source")
  val fileTreePackageName = settingKey[String]("Destination package to write listed files")
  val fileTreeMapper = settingKey[String]("Mapper for listed files; defaults to 'identity'.")
}
