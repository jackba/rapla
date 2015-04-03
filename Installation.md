# This is the installation-guide for a single user Rapla binary distribution #

## Requirements: ##

You need JAVA: JRE 1.6 at least (1.8 recommended). You can download it from [java.com|http://www.java.com/download/]

  * The SDK works for the binary and source distribution but is very large (>50 MB)
  * The JRE will only work for the binary distribution (Compiler missing) but is much smaller (30MB)


---

## Starting Rapla: ##

Start rapla.bat (rapla.sh under Unix). If the .jar extension is associated to your Java Runtime Enviroment you can also double-click on the rapla.jar (rapla.jar is located in the lib subfolder of your binary-distribution)

> Type:

```
rapla.sh
```
> (Unix)

```
rapla.bat
```
> (vista/7)

```
call rapla.bat
```
> (win NT/2000)

### Starting rapla directly from the command-line with the java command ###

You can also start Rapla by directly calling the java command.
Change into the rapla-directory and type:
```
java -jar lib/common/rapla.jar
```

### I got the "Command not found" Error! ###

To start Rapla from the command-line, you have to set the java command
in your PATH-Variable (if its not already there) Example:

```
setenv PATH $PATH:/usr/local/java/bin
```
> (Unix)

```
set PATH=%PATH%:c:\Programme\Java\jre6\bin
```
> (Windows)


### I got the **"java.lang.OutOfMemoryError: Java heap space"** Error! ###

This error happens when there is many events (data.xml > 900Ko).
Before starting RAPLA, indicate a bigger maximum heap size.
In the examples it is set to 500Mb:

```
setenv JAVA_OPTIONS "-Xmx500M"
```
> (Unix)

```
set JAVA_OPTIONS=-Xmx500M
```
> (Windows)