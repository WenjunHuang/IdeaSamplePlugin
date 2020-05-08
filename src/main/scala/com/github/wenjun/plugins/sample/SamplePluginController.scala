package com.github.wenjun.plugins.sample

import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.components.ProjectComponent
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.SystemInfo

object SamplePluginController {
  val kPluginId = "icons"
  val Log = Logger.getInstance("SamplePluginController")
}

class SamplePluginController(var project: Project) extends ProjectComponent {
  import SamplePluginController._

  var projectIsClosed = false

  override def projectClosed(): Unit = {
    Log.info(s"projectClosed ${project.getName}")
    projectIsClosed = true
    project = null
  }

  override def projectOpened(): Unit = {
    val version = Option(PluginManager.getPlugin(PluginId.getId(kPluginId)))
      .map { plugin ⇒
        plugin.getVersion
      }
      .getOrElse("unknown")

    Log.info(
      s"Sample Plugin version $version,Java version ${SystemInfo.JAVA_VERSION}"
    )
  }

  override def getComponentName: String = "sample.ProjectComponent"
}
