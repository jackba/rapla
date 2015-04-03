# This README is for building rapla from source #


## 1. Get the source: ##

Download the Source-Distribution
[Downloads](Downloads.md)

If you want to checkout the latest development version use

http://code.google.com/p/rapla/source/checkout

and read the [CheckingOutRapla](CheckingOutRapla.md).


## 2. Build Rapla: ##

We use the ant tool for our build process. Ant is the java-equivalent to make.


Use the following batch files to start the ant.jar included with
the rapla source distribution.

build.sh (Linux/Unix)

build.bat  (Win)


Calling build with no arguments will create a Binary-Distribution
in the sub-folder dist. There you will find the scripts to start rapla. (see [Installation](Installation.md))


You can call build with different arguments:

|argument   |description    |
|:----------|:--------------|
| choose-target (default)| Executes the target specified in build.properties. Default is dist-bin. |
| dist-bin   | Creates a new Binary-Distribution in the folder dist |
| build      | Builds a new rapla.jar and rapla-client.jar and rapla.war in the build sub-folder |
| clean      | Deletes the build sub-folder    |
| clean-dist | Deletes the dist sub-folder   |
| javadocs   | create the Javadoc in the build sub-folder |


Pass the target as a parameter to ant e.g. `build.sh dist-bin`

You can also change the target in `build.properties` so you dont't have to pass any parameter to ant at all (since version 0.10.0). `build.properties` will be created from `build.properties.template` when you call `build` the first time.

For a complete list of all targets use the -projecthelp option