name := "sbtTest2"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc"       % "3.2.2",
  "org.postgresql"  %  "postgresql"        % "42.2.2",
  "ch.qos.logback"  %  "logback-classic"   % "1.2.3"
)