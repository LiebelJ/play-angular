name := """play-slick-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.34"
libraryDependencies += "com.typesafe.play" %% "play-slick" % "2.0.2"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "2.0.2"
libraryDependencies += "com.h2database" % "h2" % "1.4.192"

libraryDependencies += specs2 % Test

/* ================================= WEBPACK ================================== */

val frontEndProjectName = "frontend"
val backEndProjectName = "backend"
val distDirectory = ".." + backEndProjectName + "public/dist"

// Starts: angularCLI build task
val frontendDirectory = baseDirectory {_ /".."/frontEndProjectName}

val webpack = sys.props("os.name").toLowerCase match {
  case os if os.contains("win") ⇒ "cmd /c node_modules\\.bin\\webpack"
  case _ ⇒ "node_modules/.bin/webpack"
}

val params = " --config webpack.config.js --progress --colors --display-error-details"

val ngBuild = taskKey[Unit]("webpack build task.")
ngBuild := { Process( webpack + params , frontendDirectory.value) ! }
(packageBin in Universal) <<= (packageBin in Universal) dependsOn ngBuild
// Ends.
  

