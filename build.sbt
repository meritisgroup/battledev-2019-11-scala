scalaVersion := "2.12.1"

Test / parallelExecution := false
Test / logBuffered := false

resolvers += "Sonatype OSS Snapshots" at
	"https://oss.sonatype.org/content/repositories/snapshots"

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")

artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
  artifact.name + "-" + module.revision + "." + artifact.extension
}

lazy val root = (project in file("."))
	.settings(
		name := "BattleDev Nov 2019 Scala",

		libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test",
		libraryDependencies += "com.storm-enroute" %% "scalameter" % "0.18",
	)
