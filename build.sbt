ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "scala-ssl-poke",
    idePackagePrefix := Some("com.lucidworks")
  )

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.13"