# General Questions #

### What is Rapla? ###

A software tool for distributed planning the schedules of resources or persons.

### Do I need a server for Rapla? ###

You will only need a server in multiuser mode. For more information about server-setup consult README.txt.

### Do I need a database for Rapla? ###

No, Rapla stores all information in a xml-file. You can however use a database to store the xml-fragments for better scalability and to take advantage of the transaction and backup mechanisms provided by your Database.

### How can I use Rapla? ###

Get the latest binary from the download-section and follow the instructions in INSTALL.txt.

### Conflicts are not always displayed ###

Rapla doesnt show conflicts when they are in the past, i.e. before the current date. Also ressources can be marked as conflict free so no conflicts will be shown for them.

### What is the default login if i use the rapla client for the first time ###

The default username is admin with an empty password.

### How can I make an event editable by multiple users without granting admin rights ###

See the page [permission\_modify](permission_modify.md) for an answer.

### Can I change the size of the granularity of the timscale from 15 minutes to another granularity? ###

You can change them in the options menu under calendar



### The apache-license is not compatible with the GNU-license. Why can you link Rapla with apache-libraries? ###

There is a statement in the COPYRIGHT-NOTICE of each source-file, that gives you the permission to link the program with every library, wich license fulfills the Open Source Definition as published by the Open Source Initiative (OSI). (we asked someone at gnu.org for that statement).


### Can I build Rapla without ant in my favourite IDE? ###
We encourage the use of Ant, if you however can't or dont't want to use Ant in your IDE then you have to pay attention to following points:

  * Include the needed libraries into your Classpath. What libraries are needed to compile Rapla depends on your JDK and what features of rapla you want to use.
  * The Starting class is org.rapla.bootstrap.RaplaStandaloneLoader
  * The server start class is `org.rapla.bootstrap.RaplaServerLoader`
  * The client start class is `org.rapla.bootstrap.RaplaClientLoader`

### Where do I find the data stored in Rapla (e.g. für backup) ###

In the file
```
data/data.xml
```

under the rapla folder.

in 1.6 this was
```
webapp/WEB-INF/data.xml
```

### How can I migrate to a 1.7+ version of Rapla ###

If you don't use a database just copy the file
```
webapp/WEB-INF/data.xml
```
to the new version of rapla, you can overwrite the existing one. See question above for Rapla Versions 1.7 and higher, because the location of the data.xml has changed.

If you use a database then configure, just enter the database settings n raplaserver.xconf in the new version.
Don't forget to copy the database driver to the new version of rapla as A new version comes without the database drivers.

If you have modified any configuration in jetty/jetty.xml or raplaserver.xconf you have to make the same modifications in the new version as well.

In 1.7 the configuration location has changed. You'll find the jetty.xml in etc folder and do the database configuration in contexts/rapla.xml instead of raplaserver.xconf


### How can I migrate to another server ###

Just copy the rapla folder to the new location. If you installed rapla as a service you have to uninstall the service first with the service/bin scripts and install it on the new server.

To migrate the data in the database to a new server use the export script. This exports your data to the data.xml which can be copied to the new server.


### How do I install the Rapla-server as a win7/XP/Vista service? ###

Go into the folder service/bin. There you find batch jobs to install and test the server as a service.
Run Install first then start to test the service.
The scripts must be run with admin priviliges (right click, run as admin)

### How do I configer SSL? ###

Use keytool to generate your ssl keypair. You can find the tool in your java bin directory.
call
```
keytool -alias rapla -genkeypair
```

choose a password. (secret is the default in jetty.xml)

Uncomment the ssl section in jetty/jetty.xml
(etc/jetty.xml since rapla 1.7)

Change the password (if you didn't choose secret).
Either copy .keystore form your home folder to the rapla directory or enter the path to .keystore in jetty.xml

Start raplaserver and go to https://localhost:8443/rapla

If the 8443 port is already used on your server choose another one and restart rapla.


---


# Troubleshooting #



### I've downloaded Rapla but can't login after starting, the logins on your site don't work? ###

Rapla starts per default with a minimum data-file: data.xml. The only possible login is admin (empty password).
To use the simpsons-samples file follow the instructions in INSTALL.txt.


### Admin is a default user at all times. ###
This is the default for single-user single-computer. If you want to use multiple logins you have use client server mode:

### Rapla doesn't check my password. I can enter anything! ###

Rapla is probably configured to work on a local file-storage. On local files password checking makes no sense. If you configure Rapla for multiuser mode passwords will be validated. See README.txt and Server Installation.

This won't be happening with 1.7 as it always logins the first admin in standalone mode.


### Under Windows after calling build.bat or start.bat I got the message "command or filename not found." ###

That means: The java command was not found. Make sure Java was properly installed and the java command is on your path. Set java in your PATH (if its not already there) e.g.:
```
set PATH=%PATH%;c:\Programme\Java\jre7\bin 
```

To make this a permanent change
```
under Windows 95/98 add the line to autoexec.bat
under NT/2000 modify PATH in the Enviroment-Dialog in the System-Properties.
```


### Under Unix after calling build.sh or rapla.sh I got the message "Command not found." ###

Same as above, add java to your path, e.g.
```
export PATH=$PATH:/usr/local/java/bin
```

or set JAVA\_HOME (see the next question)


### Under Unix after calling build.sh or rapla.sh I got the message "cannot find class java/lang/Thread". ###

If JAVA\_HOME is not set rapla.sh guesses it by invoking
```
which java
```

Type
```
java -version
```

to show your default java version. Rapla needs at least Java 1.6 to run Rapla. You can try to set JAVA\_HOME to the java 2 installation before calling Rapla (See next question).

### I got the message "You must set JAVA\_HOME to point at your Java Development Kit installation". ###

This is done under Windows from the Commandline with the SET command e.g.

set JAVA\_HOME=c:\Programme\your\_java\_vendor\

Under unix use
```
 export JAVA_HOME=/usr/local/your_java_vendor
```

Note: A Java Runtime Enviroment is not sufficent, because it doesn't include a Compiler.

To make this a permanent change
```
 under Windows 95/98 add the line to autoexec.bat
 under NT/2000 modify/create the JAVA_HOME entry in the Enviroment-Dialog in the System-Properties.
```



### I've got an compilation-error with the latest Checkout Version. ###

To clean up the build run
```
build clean
```

before compilation. If compilation still fails send a mail to our mailing-list.



### I have a dual monitor and Rapla doesn't scroll on my second monitor. ###

This is a known issue with java. Please use the first monitor for displaying the main view. You can use the second for the appointments.

### I have a question not addresed by the FAQ. Where do I get more information? ###

Post your question or feature-request to the Rapla-Mailinglist