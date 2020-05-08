package com.github.wenjun.plugins.sample

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon


class SampleFileType extends LanguageFileType(SampleLanguage.INSTANCE)  {
  import SampleFileType._

  override def getName: String = "Sample"

  override def getDescription: String = "A Sample language plugin"

  override def getDefaultExtension: String = FileExtension

  override def getIcon: Icon = Icons.SampleIcon
}

object SampleFileType {
  val FileExtension = "sample1"
  val INSTANCE = new SampleFileType
}
