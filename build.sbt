val baseSettings = Seq(
  organization := "com.example",
  scalaVersion := "2.12.3",
  crossScalaVersions := Seq("2.11.11", "2.12.3"),
  version := "0.1.0-SNAPSHOT"
)

lazy val macros = (project in file("macros"))
  .settings(baseSettings)
  .settings(
    libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
  )

lazy val root = (project in file("."))
  .settings(baseSettings)
  .settings(
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % Test
  )
  .dependsOn(macros)
