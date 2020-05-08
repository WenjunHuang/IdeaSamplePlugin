package com.github.wenjun.plugins.sample

import com.intellij.lang.Language

class SampleLanguage extends Language("Sample") {
}

object SampleLanguage {
  val INSTANCE = new SampleLanguage
}
