name := "voids"

version := "0.1.0"

scalaVersion := "2.13.2"

libraryDependencies ++= Seq(
  "org.typelevel"     %% "simulacrum"           % "1.0.0",
  "org.junit.jupiter" %  "junit-jupiter-api"    % "5.6.1" % "test",
  "org.scalatest"     %% "scalatest"            % "3.1.1" % "test"
)

scalacOptions += "-Ymacro-annotations"