package com.github.wenjun.plugins.sample.psi

import com.github.wenjun.plugins.sample.{Icons, SampleFileType, SampleLanguage}
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.{FileViewProvider, PsiElement, PsiNamedElement}
import javax.swing.Icon
import org.antlr.intellij.adaptor.psi.ScopeNode

class SamplePSIFileRoot(viewProvider:FileViewProvider) extends PsiFileBase(viewProvider,SampleLanguage.INSTANCE) with ScopeNode {
  override def resolve(element: PsiNamedElement): PsiElement = ???

  override def getFileType: FileType = SampleFileType.INSTANCE

  override def getIcon(flags: Int): Icon = Icons.SampleIcon
}
