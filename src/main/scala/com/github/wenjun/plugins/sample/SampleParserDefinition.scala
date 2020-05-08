package com.github.wenjun.plugins.sample

import com.github.wenjun.plugins.sample.parser.{SampleLanguageLexer, SampleLanguageParser}
import com.intellij.lang.{ASTNode, ParserDefinition, PsiParser}
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.tree.{IElementType, IFileElementType, TokenSet}
import com.intellij.psi.{FileViewProvider, PsiElement, PsiFile}
import org.antlr.intellij.adaptor.lexer.{ANTLRLexerAdaptor, PSIElementTypeFactory, TokenIElementType}
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree

object SampleParserDefinition {
  val File = new IFileElementType(SampleLanguage.INSTANCE)

  PSIElementTypeFactory.defineLanguageIElementTypes(
    SampleLanguage.INSTANCE,
    SampleLanguageParser.tokenNames,
    SampleLanguageParser.ruleNames
  )
  val ID: TokenIElementType = PSIElementTypeFactory
    .getTokenIElementTypes(SampleLanguage.INSTANCE)
    .get(SampleLanguageLexer.ID)

  val COMMENTS: TokenSet = PSIElementTypeFactory.createTokenSet(
    SampleLanguage.INSTANCE,
    SampleLanguageLexer.COMMENT,
    SampleLanguageLexer.LINE_COMMENT
  )
  val WHITESPACE: TokenSet = PSIElementTypeFactory.createTokenSet(
    SampleLanguage.INSTANCE,
    SampleLanguageLexer.WS
  )
  val STRING: TokenSet = PSIElementTypeFactory.createTokenSet(
    SampleLanguage.INSTANCE,
    SampleLanguageLexer.STRING
  )
}
class SampleParserDefinition extends ParserDefinition {
  import SampleParserDefinition._

  override def createLexer(project: Project): Lexer = new ANTLRLexerAdaptor(SampleLanguage.INSTANCE,new SampleLanguageLexer(null))

  override def createParser(project: Project): PsiParser = {
    val parser = new SampleLanguageParser(null)
    new ANTLRParserAdaptor(SampleLanguage.INSTANCE,parser) {
      override def parse(parser: Parser, root: IElementType): ParseTree =  {
        root match {
          case IFileElementType ⇒ parser.asInstanceOf[SampleLanguageParser].script()
          case _ ⇒ parser.asInstanceOf[SampleLanguageParser].primary()
        }
      }
    }
  }

  override def getWhitespaceTokens: TokenSet = WHITESPACE

  override def getFileNodeType: IFileElementType = File

  override def getCommentTokens: TokenSet = COMMENTS

  override def getStringLiteralElements: TokenSet = STRING

  override def createElement(astNode: ASTNode): PsiElement = ???

  override def createFile(fileViewProvider: FileViewProvider): PsiFile = {
    new SampleP
  }
}
