package com.github.wenjun.plugins.sample

import com.intellij.openapi.fileTypes.{FileTypeConsumer, FileTypeFactory}

class SampleFileTypeFactory extends FileTypeFactory {
  override def createFileTypes(fileTypeConsumer: FileTypeConsumer): Unit = {
    fileTypeConsumer.consume(SampleFileType.INSTANCE,SampleFileType.FileExtension)
  }
}
