import org.jetbrains.sbtidea.Keys._

intellijPluginName in ThisBuild := "antlr-sample-plugin"
intellijBuild in ThisBuild := "201.7223.91"

lazy val root = project.in(file(".")).settings(
    scalaVersion := "2.12.10",
    version := "0.1",
    scalacOptions in Global ++= Seq(
        "-target:jvm-1.8",
        "-feature",
        "-unchecked",
        "-Xfuture"
    ),
    ideBasePackages := Seq("icons"),
    antlr4Version in Antlr4 := "4.8",
    antlr4PackageName in Antlr4 := Some("com.github.wenjun.plugins.sample.parser"),
    libraryDependencies ++= Seq(
        "org.antlr" % "antlr4-intellij-adaptor" % "0.1"
    )
).enablePlugins(SbtIdeaPlugin,Antlr4Plugin)

lazy val ideaRunner = createRunnerProject(root,"antlr-sample")



