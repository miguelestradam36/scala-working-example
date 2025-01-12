lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-example-project",
    description := "Example sbt project that compiles using Scala 3",
    version := "0.1.0",
    scalaVersion := "3.6.2",
    scalacOptions ++= Seq("-deprecation"),
    libraryDependencies ++= Seq(
        "org.scala-lang" % "scala-reflect" % "2.11.7",
        "org.scala-lang" %% "toolkit" % "0.1.7",
        "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4"
        )
  )