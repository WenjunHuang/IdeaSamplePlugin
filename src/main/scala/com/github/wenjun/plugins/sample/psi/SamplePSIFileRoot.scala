package com.github.wenjun.plugins.sample.psi

import com.github.wenjun.plugins.sample.SampleLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import org.antlr.intellij.adaptor.psi.ScopeNode

class SamplePSIFileRoot(viewProvider:FileViewProvider) extends PsiFileBase(viewProvider,SampleLanguage.INSTANCE) with ScopeNode {

}
