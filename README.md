# sbt-filetree

This SBT plugin generates a Scala source file that represents the 
directory structure of a given file system directory.

For example, given a directory with the following structure:

    base/
      file1.jpg
      file2.jpg
      sub/
        file3.jpg
      
The plugin generates (roughly) the following Scala object:

    object AppAssets {
      def file1: String = "file1.jpg"
      def file2: String = "file2.jpg"
      object sub {
        def file3: String = "sub/file3.jpg"
      }
    }
    
Now you can refer to a given file path without writing the string literal by hand:

    AppAssets.sub.file3 // returns "sub/file3.jpg"

Furthermore, if the file is deleted or moved from the file system, any code that
references the file will no longer compile.

## Installation

Add the following settings in `plugins.sbt`:

    resolvers += Resolver.url("malliina bintray sbt", url("https://dl.bintray.com/malliina/sbt-plugins/"))(Resolver.ivyStylePatterns)
    
    addSbtPlugin("com.malliina" % "sbt-filetree" % "0.0.4")

Enable `FileTreePlugin` in your project:

    val myProject = Project("demo", file("."))
      .enablePlugins(com.malliina.sbt.filetree.FileTreePlugin)

Specify the source directories for the file tree traversal and corresponding destination objects to write:

    import com.malliina.sbt.filetree.DirMap
    fileTreeSources += DirMap(baseDirectory.value / "appfiles", "com.malliina.filetree.AppFiles")
    
Now when you `compile`, the build generates source code that defines an object `com.malliina.filetree.AppFiles`,
where each member is a file or directory under `baseDirectory / appfiles`.

By default, each file path is represented as a `String`. You can supply a function as a third paramater to a 
`DirMap` that transforms each file path:

    DirMap(baseDirectory.value / "appfiles", "com.malliina.filetree.AppFiles", "com.malliina.Code.transform")
    
Where `transform` is a unary function of type `String => T`.
