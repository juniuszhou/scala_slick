name := "scala_slick"

version := "1.0"

scalaVersion := "2.10.4"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "2.10.0",
  "com.typesafe.slick" %% "slick-direct_2.10" % "3.0.0-RC3"
)

libraryDependencies += "com.typesafe.slick" % "slick_2.10" % "3.0.0-RC3"

libraryDependencies += "com.typesafe.slick" % "slick-direct_2.10" % "3.0.0-RC3"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.35"
