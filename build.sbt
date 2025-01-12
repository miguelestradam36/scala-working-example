lazy val root = project
  .in(file("."))
  .settings(
    name := "scala-example-project",
    description := "Example sbt project that compiles using Scala 3",
    version := "0.1.0",
    scalaVersion := "3.6.2",
  )