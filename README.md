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

Add the plugins in `plugins.sbt`:

    addSbtPlugin("com.malliina" % "sbt-filetree" % "0.0.1")

Add `FileTreePlugin` to your project:

    val myProject = Project("demo", file("."))
      .enablePlugins(com.malliina.sbt.filetree.FileTreePlugin)

Specify the source directory for the file tree traversal:

    fileTreeSource := resourceDirectory.value
    
Optionally configure the package name for the generated source file:

    fileTreePackageName := "com.malliina.assets"
    
By default, each file path is represented as a `String`. You can supply a 
function that transforms each file path:

    fileTreeMapper := "com.malliina.Code.transform"
    
Where `transform` is an unary function of type `String => T`.

