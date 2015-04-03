# Introduction #

Cloudbees is a cloud service provider able to host Java web applications like Rapla.

# Installation Instructions #

### Register and Upload Rapla ###
  1. Register with cloudbees
  1. Select RUN stack
  1. Select your region (eu/us)
  1. Create an application with the name of your choice. The name maybe already taken. The name of your application will be further referred as APPNAME. So replace APPNAME with the name in the instructions that follow.
  1. Download the SKD console from https://developer.cloudbees.com/bin/view/RUN/BeesSDK and follow the instructions to run the console
  1. Download Rapla binary (Version 1.7.3 or higher) and unzip
  1. upload rapla.war from the unziped rapla webapps directory into the cloud via the web interface or from the bees console
```
bees app:deploy -a APPNAME PATH_TO_RAPLA_WEBAPP_WAR
```
  1. You can now test rapla by clicking on the link in the webconsole (but it will not store the data permanently, we still have to configure data again)


### Install and bind Database ###
  1. Add database. The name you took will be referred as DATABASENAME. Username and Password are not used for installation so choose what you want.
  1. Bind the database to the application using the console
```
bees app:bind -a APPNAME -db DATABASENAME -as rapladb validationQuery="SELECT 1" testOnBorrow=true
```
  1. Restart the application
```
bees app:restart -a APPNAME 
```
  1. Check the logs in the webconsole it should list something like
```
NFO: Using rapladatasource rapladb
Oct 09, 2013 9:53:52 PM org.rapla.storage.dbsql.DBOperator loadData
INFO: Using datasource MySQL: jdbc:mysql://
```
> if it lists something like
```
java.lang.NullPointerException
	at sun.jdbc.odbc.JdbcOdbcDriver.getProtocol(Unknown Source)
```
> it means the database is not bound and you have to check the steps above



### Mail ###

Just add Sendgrip stack in webconsole and restart or redloy rapla