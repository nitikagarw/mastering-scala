package sbtstudent

import sbt._
import Keys._

object AdditionalSettings {

  val loadInitialCmds = false

  val initialCmdsConsole: Seq[Def.Setting[String]] =
    if (loadInitialCmds) {
      Seq(initialCommands in console := "import com.lightbend.akkassembly._")
    } else {
      Seq()
    }

  val initialCmdsTestConsole: Seq[Def.Setting[String]]  =
    if (loadInitialCmds) {
      Seq(initialCommands in(Test, console) := (initialCommands in console).value)
    } else {
      Seq()
    }

  // Note that if no command aliases need to be added, assign an empty Seq to cmdAliasesIn
  val cmdAliasesIn: Seq[Def.Setting[(State) => State]] = Seq(
  ).flatten

  val cmdAliases: Seq[Def.Setting[(State) => State]] =
    cmdAliasesIn
}
