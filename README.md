# Learning Scala

All my Scala tutorials.

## Install on Linux

Install with Coursier (`cs`), Scala's `npm`:

```bash
$ curl -fL https://github.com/coursier/launchers/raw/master/cs-x86_64-pc-linux.gz | gzip -d > cs && chmod +x cs && ./cs setup
```

- https://get-coursier.io/docs/cli-overview
- https://github.com/coursier/coursier
- https://github.com/coursier/launchers

## Tools

- `cs`: Coursier, package manager
- `scalac`: the Scala compiler
- `scala`: the Scala REPL and script runner
- `scala-cli`: Scala CLI, interactive toolkit for Scala
- `sbt` & `sbtn`: The sbt build tool
- `amm`: Ammonite is an enhanced REPL
- `scalafmt`: Scalafmt is the Scala code formatter

## Installing/Switching Versions

```bash
$ cs launch scala:2.13.10
$ cs launch scalac:2.13.10
$ cs install scala:2.13.10 scalac:2.13.10
```

## Hello World!

```bash
# Create Scala 3 project
sbt new scala/scala3.g8
# OR Create Scala 2 project
sbt new scala/hello-world.g8
```

Then type project name. You can compile, run or test it with:

```bash
$ cd hello_world
$ sbt compile
$ sbt run
$ sbt console
$ sbt test
```

## IDE

VSCode:

- https://marketplace.visualstudio.com/items?itemName=scalameta.metals
- https://marketplace.visualstudio.com/items?itemName=scala-lang.scala

IntelliJ IDEA

- https://docs.scala-lang.org/getting-started/intellij-track/getting-started-with-scala-in-intellij.html
- https://www.jetbrains.com/idea/download/#section=linux
- https://stackoverflow.com/questions/47748433/are-vs-code-keybindings-available-for-intellij-idea
- https://www.jetbrains.com/help/idea/mastering-keyboard-shortcuts.html#learn-shortcuts
